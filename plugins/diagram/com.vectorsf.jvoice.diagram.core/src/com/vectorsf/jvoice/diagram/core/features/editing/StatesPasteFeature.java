package com.vectorsf.jvoice.diagram.core.features.editing;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
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
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVElement;
import com.vectorsf.jvoice.model.base.JVPackage;
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
					state.eUnset(state.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));
					state.setName(generateName(((State) copy).getName(), context));
					Flow targetFlow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
					// Si es una locution hay que copiar el voiceDsl al que
					// apunta
					if (isLocution(copy)) {
						LocutionState locution = (LocutionState) state;
						VoiceDsl voiceDsl = locution.getLocution();

						URI uri = EcoreUtil.getURI(targetFlow);
						Flow connectedFlow = (Flow) BaseModel.getInstance().getResourceSet().getEObject(uri, true);

						JVPackage targetPackage = connectedFlow.getOwnerPackage();
						pasteVoiceDsl(targetPackage, voiceDsl, state);

						// Redireccionamos el nuevo estado al
						// voiceDsl que hemos copiado
						locution.setLocution((VoiceDsl) targetPackage.getBean(voiceDsl.getName()));
						state = locution;
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
							callState.setBean(null);
							targetFlow.getStates().add(state);
							ac.setLocation(context.getX(), context.getY());
							ac.setTargetContainer(getDiagram());
							PictogramElement pe = addGraphicalRepresentation(ac, copy);
							hm.put(state, pe);
						}

					} else {
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

	protected void pasteVoiceDsl(JVPackage targetPackage, VoiceDsl voiceDsl, State state) {
		final IFile voiceDslFile = (IFile) Platform.getAdapterManager().getAdapter(voiceDsl, IFile.class);

		rename = false;
		targetRes = (IResource) Platform.getAdapterManager().getAdapter(targetPackage, IResource.class);
		targetPath = targetRes.getFullPath().append(state.getName() + ".voiceDsl");

		// Realizamos la copia del fichero al destino.
		try {
			IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {

					if (rename) {
						renameBean(targetPath);
					}

					voiceDslFile.copy(targetPath, true, null);

				}
			};
			ResourcesPlugin.getWorkspace().run(runnable, targetRes.getProject(), IWorkspace.AVOID_UPDATE, null);

		} catch (CoreException e) {
			e.printStackTrace();
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

	private String generateName(String stateName, IPasteContext context) {

		PictogramElement[] pes = context.getPictogramElements();
		if (pes.length != 0) {
			if (pes[0] instanceof Diagram) {
				Diagram diagram = (Diagram) pes[0];
				String name = "CopyOf" + stateName;
				int repeated = 0;
				for (int i = 0; i < diagram.getChildren().size(); i++) {
					Shape shape = diagram.getChildren().get(i);
					if (getBusinessObjectForPictogramElement(shape) instanceof State) {
						State state = (State) getBusinessObjectForPictogramElement(shape);
						if (state.getName().equals(name)) {
							int k = repeated + 2;
							name = "Copy" + k + "Of" + stateName;
							repeated++;
							i = 0;
						}
					}

				}
				return name;
			} else {
				String name = "CopyOf" + stateName;
				int repeated = 0;
				for (int i = 0; i < pes.length; i++) {
					if (pes[i] instanceof Shape && !(pes[i] instanceof ConnectionDecorator)) {
						Shape shape = (Shape) pes[i];
						State state = (State) getBusinessObjectForPictogramElement(shape);
						if (state != null) {
							if (state.getName().equals(name)) {
								int k = repeated + 2;
								name = "Copy" + k + "Of" + stateName;
								repeated++;
								i = 0;
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

				} else if (obj instanceof JVBean) {
					((JVBean) obj).setName(newName);
					((JVBean) obj).setDescription(newName);
					List<EObject> listaObjetos = ((Flow) obj).eResource().getContents();
					for (int i = 0; i < listaObjetos.size(); i++) {
						EObject objeto = listaObjetos.get(i);
						if (objeto instanceof Diagram) {
							((Diagram) objeto).setName(newName);
						}
					}
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
}
