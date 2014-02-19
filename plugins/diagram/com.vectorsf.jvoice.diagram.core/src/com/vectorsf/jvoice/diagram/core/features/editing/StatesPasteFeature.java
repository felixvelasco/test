package com.vectorsf.jvoice.diagram.core.features.editing;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.util.Arrays;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVElement;
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.Note;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class StatesPasteFeature extends AbstractPasteFeature {

	private IPath targetPath;
	private IResource targetRes;
	private boolean rename;
	private String newName;
	private VoiceDsl modified;

	public StatesPasteFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void paste(IPasteContext context) {
		Object[] copies = getCopiesFromClipBoard(context);
		Map<JVElement, PictogramElement> hm = new HashMap<>();
		for (Object copy : copies) {

			AddContext ac = new AddContext();
			if (copy != null) {
				if (isState(copy)) {
					State state = (State) copy;
					state.setName(generateStateName(((State) copy).getName(), context));
					Flow targetFlow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
					// Si es una locution hay que copiar el voiceDsl al que
					// apunta
					if (isLocution(copy)) {
						state.eUnset(state.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));
						LocutionState locution = (LocutionState) state;
						VoiceDsl voiceDsl = locution.getLocution();

						URI uri = EcoreUtil.getURI(targetFlow);
						Flow connectedFlow = (Flow) BaseModel.getInstance().getResourceSet().getEObject(uri, true);

						pasteVoiceDsl(voiceDsl, state, connectedFlow);

						// Redireccionamos el nuevo estado al
						// voiceDsl que hemos copiado
						locution.setLocution(modified);
						state = locution;

						targetFlow.getStates().add(state);
						ac.setLocation(context.getX(), context.getY());
						ac.setTargetContainer(getDiagram());
						PictogramElement pe = addGraphicalRepresentation(ac, state);
						hm.put(state, pe);

					} else if (state instanceof CallState) {
						// Si es un estado execution comprobamos si tiene una instancia al bean referido desde el
						// estado execution del que procede y si se llama igual. En caso contrario se deja como null.
						CallState callState = (CallState) state;
						boolean setNull = false;
						if (targetFlow.getBeans() == null || targetFlow.getBeans().size() == 0) {
							setNull = true;
						} else {
							for (ComponentBean bean : targetFlow.getBeans()) {
								if (bean.getName().equals(callState.getBean().getName())) {
									IProject project = ResourcesPlugin.getWorkspace().getRoot()
											.findMember(EcoreUtil.getURI(targetFlow).toPlatformString(true))
											.getProject();
									IJavaProject jProject = JavaCore.create(project);
									IType type;
									try {
										type = jProject.findType(bean.getFqdn());
										IMethod[] methods = type.getMethods();
										boolean hasMethod = false;
										for (IMethod method : methods) {
											if (method.getElementName().equals(callState.getMethodName())) {
												hasMethod = true;
											}
										}
										if (hasMethod) {
											state.eUnset(state.eClass().getEStructuralFeature(
													BasePackage.JV_ELEMENT__ID));
											targetFlow.getStates().add(state);
											ac.setLocation(context.getX(), context.getY());
											ac.setTargetContainer(getDiagram());
											PictogramElement pe = addGraphicalRepresentation(ac, copy);
											hm.put(state, pe);
										} else {
											setNull = true;
										}
									} catch (JavaModelException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}

							}

						}
						if (setNull) {
							state.eUnset(state.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));
							callState.setBean(null);
							targetFlow.getStates().add(state);
							ac.setLocation(context.getX(), context.getY());
							ac.setTargetContainer(getDiagram());
							PictogramElement pe = addGraphicalRepresentation(ac, copy);
							hm.put(state, pe);
						}

					} else if (state instanceof CustomState) {
						CustomState customice = (CustomState) state;
						Object[] originals = getFromClipboard();

						for (Object original : originals) {
							if (original instanceof CustomState) {
								CustomState customOriginal = (CustomState) original;
								if (customice.getId().equals(customOriginal.getId())) {
									Flow flujoOriginal = (Flow) customOriginal.eContainer();
									IFile fileFlujoOrigen = (IFile) Platform.getAdapterManager().getAdapter(
											flujoOriginal, IFile.class);
									IFolder folderOriginal = (IFolder) fileFlujoOrigen.getParent();
									IPath pathJsp = new Path(flujoOriginal.getName() + ".resources");
									IFolder folderResources = folderOriginal.getFolder(pathJsp);
									if (folderResources.exists()) {
										IFile jspBuscado = folderResources.getFile(customice.getPath());
										if (jspBuscado.exists()) {
											// encontramos el jsp asociado al custom, ahora hay que copiarlo
											// a la carpeta resources del flujo destino
											IFile fileFlujoDestino = (IFile) Platform.getAdapterManager().getAdapter(
													targetFlow, IFile.class);
											IFolder folderDestino = (IFolder) fileFlujoDestino.getParent();
											IPath pathJspDestino = new Path(targetFlow.getName() + ".resources");
											IFolder folderResourcesDestino = folderDestino.getFolder(pathJspDestino);
											if (folderResourcesDestino.exists()) {
												String newName = getNewName(folderResourcesDestino, customice.getPath());

												IPath destinoFinal = folderResourcesDestino.getFullPath().append(
														newName);
												try {
													jspBuscado.copy(destinoFinal, true, null);
													customice.setPath(newName);
												} catch (CoreException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
													customice.setPath("");
												}

											} else {
												customice.setPath("");
											}
										} else {
											customice.setPath("");
										}
									} else {
										customice.setPath("");
									}
								}
							}
						}
						customice.eUnset(customice.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));
						targetFlow.getStates().add(customice);
						ac.setLocation(context.getX(), context.getY());
						ac.setTargetContainer(getDiagram());
						PictogramElement pe = addGraphicalRepresentation(ac, copy);
						hm.put(state, pe);
					} else {
						state.eUnset(state.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));
						targetFlow.getStates().add(state);
						ac.setLocation(context.getX(), context.getY());
						ac.setTargetContainer(getDiagram());
						PictogramElement pe = addGraphicalRepresentation(ac, copy);
						hm.put(state, pe);
					}

				} else if (copy instanceof Note) {
					Note note = (Note) copy;
					note.eUnset(note.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));
					Flow targetFlow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
					targetFlow.getNotes().add(note);
					ac.setLocation(context.getX(), context.getY());
					ac.setTargetContainer(getDiagram());
					PictogramElement pe = addGraphicalRepresentation(ac, copy);
					hm.put(note, pe);
				}
			}

		}
		for (Object copy : copies) {
			if (copy instanceof Transition) {
				Transition transition = (Transition) copy;
				transition.eUnset(transition.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));
				State sourceState = transition.getSource();
				State targetState = transition.getTarget();
				Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
				flow.getTransitions().add(transition);
				PictogramElement[] pes = context.getPictogramElements();
				if (pes[0] instanceof Diagram) {
					PictogramElement peSource = hm.get(sourceState);
					ContainerShape csSource = (ContainerShape) peSource;
					PictogramElement peTarget = hm.get(targetState);
					ContainerShape csTarget = (ContainerShape) peTarget;
					AddConnectionContext addContextInicial = new AddConnectionContext(csSource.getAnchors().get(0),
							csTarget.getAnchors().get(0));
					addContextInicial.setNewObject(transition);
					addContextInicial.setTargetContainer((ContainerShape) peSource);
					Connection connection = (Connection) getFeatureProvider().addIfPossible(addContextInicial);
					layoutPictogramElement(connection);
				}

			}
		}
		for (Object copy : copies) {
			if (copy instanceof Note) {
				Note note = (Note) copy;
				List<State> refStates = note.getReferencedStates();
				// Comprobamos si alguno de los estados referidos por la nota tambien esta siendo copiado
				for (State sta : refStates) {
					if (Arrays.contains(copies, sta)) {
						PictogramElement peSource = hm.get(note);
						ContainerShape csSource = (ContainerShape) peSource;
						PictogramElement peTarget = hm.get(sta);
						ContainerShape csTarget = (ContainerShape) peTarget;
						AddConnectionContext addContextInicial = new AddConnectionContext(csSource.getAnchors().get(0),
								csTarget.getAnchors().get(0));
						// addContextInicial.setNewObject(relation);
						addContextInicial.setTargetContainer((ContainerShape) peSource);
						Connection connection = (Connection) getFeatureProvider().addIfPossible(addContextInicial);
						layoutPictogramElement(connection);

					}
				}
			}
		}
	}

	protected void pasteVoiceDsl(VoiceDsl voiceDsl, State state, Flow flow) {
		final IFile voiceDslFile = (IFile) Platform.getAdapterManager().getAdapter(voiceDsl, IFile.class);
		modified = voiceDsl;

		rename = false;
		IFile targetFlow = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);
		IPath pathRecursos = new Path(targetFlow.getName().replace(".jvflow", ".resources"));
		targetRes = targetFlow.getParent().getFolder(pathRecursos);
		if (targetRes.exists()) {
			// targetRes = (IResource) Platform.getAdapterManager().getAdapter(targetPackage, IResource.class);
			newName = generateLocutionName((IFolder) targetRes, voiceDsl.getName() + ".voiceDsl", voiceDsl.getName()
					+ ".voiceDsl", 1);
			try {
				if (!newName.equals(voiceDsl.getName() + ".voiceDsl")) {
					rename = true;
				}

				// Realizamos la copia del fichero al destino.

				IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

					@Override
					public void run(IProgressMonitor monitor) throws CoreException {
						targetPath = targetRes.getFullPath().append(newName);
						if (rename) {
							IFile dsl = ((IFolder) targetRes).getFile(newName);

							if (!dsl.exists()) {
								dsl.create(voiceDslFile.getContents(), true, null);
							}
							renameBean(targetPath);
						} else {

							voiceDslFile.copy(targetPath, true, null);
							changeURI(targetPath);
						}

					}
				};
				ResourcesPlugin.getWorkspace().run(runnable, targetRes.getProject(), IWorkspace.AVOID_UPDATE, null);

			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

	}

	private String generateLocutionName(IFolder targetFolder, String name, String newName, int i) {
		IFile file = targetFolder.getFile(newName);
		if (file.exists()) {
			rename = true;
			if (i == 1) {
				return generateLocutionName(targetFolder, name, "CopyOf" + name, i + 1);
			} else {
				return generateLocutionName(targetFolder, name, "Copy" + i + "Of" + name, i + 1);
			}
		} else {
			if (i == 1 && targetFolder.getFile(name).exists()) {
				return "CopyOf" + name;
			} else {
				return newName;
			}
		}
	}

	@Override
	public boolean canPaste(IPasteContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length != 1
				|| !(pes[0] instanceof Diagram || pes[0] instanceof ContainerShape || pes[0] instanceof Transition)) {
			return false;
		}

		Object[] fromClipboard = getFromClipboard();
		if (fromClipboard == null || fromClipboard.length == 0) {
			return false;
		}
		for (Object object : fromClipboard) {
			if (!isState(object) && !(object instanceof Transition) && !(object instanceof Note)) {
				return false;
			}
			if (object instanceof InitialState) {
				// Check if exists any InitialState
				Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
				List<State> states = flow.getStates();
				for (State sta : states) {
					if (sta instanceof InitialState) {
						return false;
					}
				}
				return true;
			}
		}

		return true;
	}

	private boolean isState(Object object) {
		return object instanceof CallFlowState || object instanceof CallState || object instanceof FinalState
				|| object instanceof InitialState || object instanceof SwitchState || object instanceof LocutionState
				|| object instanceof CustomState;
	}

	private boolean isLocution(Object object) {
		return object instanceof LocutionState;
	}

	private String generateStateName(String stateName, IPasteContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length != 0) {
			if (pes[0] instanceof Diagram) {
				Diagram diagram = (Diagram) pes[0];
				String name = stateName;
				int repeated = 0;
				for (int i = 0; i < diagram.getChildren().size(); i++) {
					Shape shape = diagram.getChildren().get(i);
					if (getBusinessObjectForPictogramElement(shape) instanceof State) {
						State state = (State) getBusinessObjectForPictogramElement(shape);
						if (state.getName().equals(name)) {
							int k = repeated + 1;
							name = "Copy" + k + "Of" + stateName;
							repeated++;
							i = 0;
							if (repeated == 1) {
								name = "CopyOf" + stateName;
							}
						}
					}

				}
				return name;
			} else {
				String name = stateName;
				int repeated = 0;
				for (int i = 0; i < pes.length; i++) {
					if (pes[i] instanceof Shape && !(pes[i] instanceof ConnectionDecorator)) {
						Shape shape = (Shape) pes[i];
						State state = (State) getBusinessObjectForPictogramElement(shape);
						if (state != null) {
							if (state.getName().equals(name)) {
								int k = repeated + 1;
								name = "Copy" + k + "Of" + stateName;
								repeated++;
								i = 0;
								if (repeated == 1) {
									name = "CopyOf" + stateName;
								}
							}
						}
					}

				}
				return name;

			}
		}
		return "CopyOf";
	}

	private void renameBean(IPath targetPath) {
		String newName = targetPath.lastSegment();
		newName = newName.substring(0, newName.lastIndexOf('.'));
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		Resource emfRes = resourceSetImpl.createResource(URI.createPlatformResourceURI(targetPath.toString(), true));
		try {
			emfRes.load(null);

			for (EObject obj : emfRes.getContents()) {
				if (obj instanceof VoiceDsl) {
					((VoiceDsl) obj).setName(newName);
					modified = (VoiceDsl) obj;
				}
			}
			try {
				emfRes.save(SaveOptions.newBuilder().noValidation().getOptions().toOptionsMap());
			} catch (RuntimeException re) {
				re.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changeURI(IPath targetPath) {
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		Resource emfRes = resourceSetImpl.createResource(URI.createPlatformResourceURI(targetPath.toString(), true));
		try {
			emfRes.load(null);

			for (EObject obj : emfRes.getContents()) {
				if (obj instanceof VoiceDsl) {
					modified = (VoiceDsl) obj;

				}
			}
			try {
				// emfRes.save(SaveOptions.newBuilder().noValidation().getOptions().toOptionsMap());
			} catch (RuntimeException re) {
				re.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getNewName(IFolder resourcesFolder, String name) {
		String newName = name;
		if (resourcesFolder.getFile(name).exists()) {
			name = "CopyOf" + name;
			name = getNewName(resourcesFolder, name);
			newName = name;
		}
		return newName;
	}
}
