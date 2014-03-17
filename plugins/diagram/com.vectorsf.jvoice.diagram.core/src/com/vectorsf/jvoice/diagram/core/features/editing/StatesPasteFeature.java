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
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.AbstractPasteFeature;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.util.Arrays;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.diagram.core.pattern.states.SimpleStatePattern;
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
import com.vectorsf.jvoice.ui.navigator.util.FlowCopyHelper;

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

			if (copy != null) {
				if (isState(copy)) {
					State state = (State) copy;

					Flow targetFlow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
					state.setName(SimpleStatePattern.getValidStateName(targetFlow, state.getName()));
					// Si es una locution hay que copiar el voiceDsl al que
					// apunta
					if (state instanceof LocutionState) {
						PictogramElement pe = pasteLocution(context, (LocutionState) state, targetFlow);
						hm.put(state, pe);

					} else if (state instanceof CallState) {
						PictogramElement pe = pasteExecution(context, (CallState) state, targetFlow);
						hm.put(state, pe);

					} else if (state instanceof CustomState) {
						PictogramElement pe = pasteCustom(context, (CustomState) state, targetFlow);
						hm.put(state, pe);

					} else {
						AddContext ac = new AddContext();
						targetFlow.getStates().add(state);
						ac.setLocation(context.getX(), context.getY());
						ac.setTargetContainer(getDiagram());
						PictogramElement pe = addGraphicalRepresentation(ac, state);
						hm.put(state, pe);
					}
					state.eUnset(state.eClass().getEStructuralFeature(BasePackage.JV_ELEMENT__ID));

				} else if (copy instanceof Note) {
					Note note = (Note) copy;
					AddContext ac = new AddContext();
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
						addContextInicial.setTargetContainer((ContainerShape) peSource);
						Connection connection = (Connection) getFeatureProvider().addIfPossible(addContextInicial);
						layoutPictogramElement(connection);

					}
				}
			}
		}
	}

	/**
	 * Pastes a custom state into the given flow, on the coordinates defined in the context
	 * 
	 * @param context
	 * @param state
	 * @param targetFlow
	 * @return
	 */
	private PictogramElement pasteCustom(IPasteContext context, CustomState custom, Flow targetFlow) {

		AddContext ac = new AddContext();

		CustomState customOriginal = (CustomState) findOriginalStateById(custom.getId());

		Flow flujoOriginal = (Flow) customOriginal.eContainer();
		IFile fileFlujoOrigen = (IFile) Platform.getAdapterManager().getAdapter(flujoOriginal, IFile.class);
		IFolder folderOriginal = (IFolder) fileFlujoOrigen.getParent();
		IPath pathJsp = new Path(flujoOriginal.getName() + ".resources");
		IFolder folderResources = folderOriginal.getFolder(pathJsp);
		if (folderResources.exists()) {
			IFile jspBuscado = folderResources.getFile(custom.getPath());
			if (jspBuscado.exists()) {
				// encontramos el jsp asociado al custom, ahora hay que copiarlo
				// a la carpeta resources del flujo destino
				IFile fileFlujoDestino = (IFile) Platform.getAdapterManager().getAdapter(targetFlow, IFile.class);
				IFolder folderDestino = (IFolder) fileFlujoDestino.getParent();
				IPath pathJspDestino = new Path(targetFlow.getName() + ".resources");
				IFolder folderResourcesDestino = folderDestino.getFolder(pathJspDestino);
				if (folderResourcesDestino.exists()) {
					String newName = getValidCustomPath(folderResourcesDestino, custom.getPath());

					IPath destinoFinal = folderResourcesDestino.getFullPath().append(newName);
					try {
						jspBuscado.copy(destinoFinal, true, null);
						custom.setPath(newName);
					} catch (CoreException e) {
						e.printStackTrace();
						custom.setPath("");
					}

				} else {
					custom.setPath("");
				}
			} else {
				custom.setPath("");
			}
		} else {
			custom.setPath("");
		}
		targetFlow.getStates().add(custom);
		ac.setLocation(context.getX(), context.getY());
		ac.setTargetContainer(getDiagram());
		PictogramElement pe = addGraphicalRepresentation(ac, custom);
		return pe;
	}

	private State findOriginalStateById(String id) {
		for (Object original : getFromClipboard()) {
			if (original instanceof State) {
				State state = (State) original;
				if (id.equals(state.getId())) {
					return state;
				}
			}
		}

		return null;
	}

	/**
	 * Pastes a call state into the given flow, on the coordinates defined in the context
	 * 
	 * @param context
	 * @param callState
	 * @param targetFlow
	 * @return
	 */
	private PictogramElement pasteExecution(IPasteContext context, CallState callState, Flow targetFlow) {
		// Si es un estado execution comprobamos si tiene una instancia al bean referido desde el
		// estado execution del que procede y si se llama igual. En caso contrario se deja como null.
		AddContext ac = new AddContext();
		ComponentBean originalBean = callState.getBean();
		callState.setBean(null);
		String currentBeanName = originalBean.getName();
		Flow originalFlow = (Flow) findOriginalStateById(callState.getId()).eContainer();

		if (originalFlow != targetFlow) {
			// Si no copiamos dentro del mismo flujo, tenemos que ajustar el bean del método
			if ("it".equals(currentBeanName)) {
				try {

					ICompilationUnit icUnit = FlowCopyHelper.getHelperFile(originalFlow);
					for (IMethod method : icUnit.findPrimaryType().getMethods()) {
						// Solo podemos matchear por nombre y número de parámetros, puesto que la inferencia de tipos no
						// se resuelve hasta la propia ejecución
						if (method.getElementName().equals(callState.getMethodName())
								&& method.getNumberOfParameters() == callState.getParameters().size()) {

							IResource resource = (IResource) Platform.getAdapterManager().getAdapter(targetFlow,
									IResource.class);
							IPackageFragment helperTargetPackage = FlowCopyHelper.getHelperPackage(resource
									.getFullPath());
							String helperClassName = FlowCopyHelper.toTitleCase(targetFlow.getName());

							FlowCopyHelper.updateHelperClass(targetFlow, helperTargetPackage.getElementName() + "."
									+ helperClassName);
							IType targetType = FlowCopyHelper.getHelperFile(targetFlow).findPrimaryType();

							for (ComponentBean bean : targetFlow.getBeans()) {
								if (bean.getName().equals("it")) {
									callState.setBean(bean);
									break;
								}
							}

							try {
								method.copy(targetType, null, null, false, null);
							} catch (JavaModelException e) {
								MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Duplicate method",
										"There already exists a method called '" + method.getElementName()
												+ "' in class '" + helperClassName + "'.\nIt will not be overwritten.");
							}

						}
					}
				} catch (JavaModelException e) {
				}
			} else {
				outer: for (ComponentBean bean : targetFlow.getBeans()) {
					if (bean.getName().equals(currentBeanName)) {
						IProject project = ResourcesPlugin.getWorkspace().getRoot()
								.findMember(EcoreUtil.getURI(targetFlow).toPlatformString(true)).getProject();
						IJavaProject jProject = JavaCore.create(project);
						IType type;
						try {
							type = jProject.findType(bean.getFqdn());
							IMethod[] methods = type.getMethods();
							for (IMethod method : methods) {
								if (method.getElementName().equals(callState.getMethodName())) {
									callState.setBean(bean);
									break outer;
								}
							}
						} catch (JavaModelException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		targetFlow.getStates().add(callState);
		ac.setLocation(context.getX(), context.getY());
		ac.setTargetContainer(getDiagram());
		PictogramElement pe = addGraphicalRepresentation(ac, callState);
		return pe;
	}

	/**
	 * Pastes a locution state into the given flow, on the coordinates defined in the context. It also copies the
	 * associated voice file
	 * 
	 * @param context
	 * @param locution
	 * @param targetFlow
	 * @return
	 */
	private PictogramElement pasteLocution(IPasteContext context, LocutionState locution, Flow targetFlow) {
		AddContext ac = new AddContext();
		VoiceDsl voiceDsl = locution.getLocution();

		URI uri = EcoreUtil.getURI(targetFlow);
		Flow connectedFlow = (Flow) BaseModel.getInstance().getResourceSet().getEObject(uri, true);

		pasteVoiceDsl(voiceDsl, connectedFlow);

		// Redireccionamos el nuevo estado al
		// voiceDsl que hemos copiado
		locution.setLocution(modified);

		targetFlow.getStates().add(locution);
		ac.setLocation(context.getX(), context.getY());
		ac.setTargetContainer(getDiagram());
		PictogramElement pe = addGraphicalRepresentation(ac, locution);
		return pe;
	}

	protected void pasteVoiceDsl(VoiceDsl voiceDsl, Flow flow) {
		final IFile voiceDslFile = (IFile) Platform.getAdapterManager().getAdapter(voiceDsl, IFile.class);
		modified = voiceDsl;

		rename = false;
		IFile targetFlow = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);
		IPath pathRecursos = new Path(targetFlow.getName().replace(".jvflow", ".resources"));
		targetRes = targetFlow.getParent().getFolder(pathRecursos);
		if (targetRes.exists()) {
			newName = getValidLocutionName((IFolder) targetRes, voiceDsl.getName()) + ".voiceDsl";
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

	private String getValidLocutionName(IFolder targetFolder, String name) {

		String validName = name;
		int counter = 1;
		for (;;) {
			if (isValidLocutionName(targetFolder, validName)) {
				return validName;
			}
			validName = name + counter;
			counter++;
		}
	}

	private boolean isValidLocutionName(IFolder targetFolder, String name) {

		IFile file = targetFolder.getFile(name + ".voiceDsl");

		if (file.exists()) {
			return false;
		}
		return true;

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getValidCustomPath(IFolder resourcesFolder, String path) {
		// Eliminamos extensión
		String pathWithoutExt = path.substring(0, path.length() - 4);
		String validPath = pathWithoutExt;
		int counter = 1;
		for (;;) {
			if (isValidCustomPath(resourcesFolder, validPath)) {
				// Añadimos extensión
				return validPath + ".jsp";
			}
			validPath = pathWithoutExt + counter;
			counter++;
		}
	}

	private boolean isValidCustomPath(IFolder resourcesFolder, String path) {

		IFile file = resourcesFolder.getFile(path + ".jsp");

		if (file.exists()) {
			return false;
		}
		return true;

	}

}
