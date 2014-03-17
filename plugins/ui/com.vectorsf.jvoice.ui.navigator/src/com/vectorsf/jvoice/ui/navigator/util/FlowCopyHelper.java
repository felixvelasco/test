package com.vectorsf.jvoice.ui.navigator.util;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.resource.SaveOptions;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class FlowCopyHelper {

	public static String toTitleCase(String original) {
		return Character.toUpperCase(original.charAt(0)) + original.substring(1);
	}

	public static void actualizaFlow(IPath targetPath, String helperClassFqdn, boolean rename)
			throws JavaModelException {
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		Resource emfRes = resourceSetImpl.createResource(URI.createPlatformResourceURI(targetPath.toString(), true));
		try {
			emfRes.load(null);

			for (EObject obj : emfRes.getContents()) {
				if (rename) {
					String newName = targetPath.lastSegment();
					newName = newName.substring(0, newName.lastIndexOf('.'));
					if (obj instanceof VoiceDsl) {
						((VoiceDsl) obj).setName(newName);

					} else if (obj instanceof Flow) {
						Flow flow = (Flow) obj;
						updateHelperClass(flow, helperClassFqdn);

						flow.setName(newName);
						List<EObject> listaObjetos = flow.eResource().getContents();
						for (int i = 0; i < listaObjetos.size(); i++) {
							EObject objeto = listaObjetos.get(i);
							if (objeto instanceof Diagram) {
								((Diagram) objeto).setName(newName);
							}
						}
						actualizaRecursos(flow);
					}
				} else {
					if (obj instanceof Flow) {
						Flow flow = (Flow) obj;
						updateHelperClass(flow, helperClassFqdn);
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

	public static void updateHelperClass(Flow flow, String helperClassFqdn) {
		flow.setHelperClass(helperClassFqdn);
		addItIfNeeded(flow, helperClassFqdn);
	}

	private static void addItIfNeeded(Flow flow, String helperClassFqdn) {
		String helperClassName = helperClassFqdn.substring(helperClassFqdn.lastIndexOf('.') + 1);
		String lowerCaseHelperClassName = Character.toLowerCase(helperClassName.charAt(0))
				+ helperClassName.substring(1);

		for (ComponentBean bean : flow.getBeans()) {
			if (bean.getName().equals("it")) {
				bean.setFqdn(helperClassFqdn);
				bean.setNameBean(lowerCaseHelperClassName);
				return;
			}
		}

		ComponentBean defaultBean = OperationsFactory.eINSTANCE.createComponentBean();
		defaultBean.setFqdn(helperClassFqdn);
		defaultBean.setName("it");
		defaultBean.setNameBean(lowerCaseHelperClassName);
		defaultBean.setPrototype(true);
		flow.getBeans().add(defaultBean);
	}

	public static IPackageFragment getHelperPackage(IPath targetPath) throws JavaModelException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(targetPath.segment(0));
		IJavaProject jProject = JavaCore.create(project);
		IPackageFragmentRoot packageFragmentRoot = jProject.getPackageFragmentRoot(project.findMember("src/main/java"));

		String componentsPackageName = ((JVModule) BaseModel.getInstance().getModel().getProject(project.getName()))
				.getComponentsPackage();

		IPath makeRelativeTo = targetPath.makeRelativeTo(project.getFullPath().append(BaseModel.JV_PATH));
		makeRelativeTo = makeRelativeTo.removeLastSegments(1);
		StringBuilder packageNameBuilder = new StringBuilder();
		for (String segment : makeRelativeTo.segments()) {
			packageNameBuilder.append(segment).append('.');
		}
		packageNameBuilder.deleteCharAt(packageNameBuilder.length() - 1);

		String packageName = packageNameBuilder.toString();
		if (packageName.startsWith(componentsPackageName)) {
			return packageFragmentRoot.createPackageFragment(packageName, true, null);
		} else {
			return packageFragmentRoot.createPackageFragment(componentsPackageName + "." + packageName, true, null);
		}
	}

	public static ICompilationUnit getHelperFile(Flow flow) throws JavaModelException {
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);
		IProject project = file.getProject();
		IJavaProject jProject = JavaCore.create(project);

		String name = flow.getHelperClass();
		if (name == null) {
			return null;
		}

		return jProject.findType(name).getCompilationUnit();
	}

	private static void actualizaRecursos(Flow flujo) {
		for (State estado : flujo.getStates()) {
			if (estado instanceof LocutionState) {
				LocutionState locution = (LocutionState) estado;
				VoiceDsl voiceDsl = locution.getLocution();
				IFile targetFlow = (IFile) Platform.getAdapterManager().getAdapter(flujo, IFile.class);

				IPath pathnuevosResources = new Path(flujo.getName() + ".resources");

				IResource recursoResource = targetFlow.getParent().getFolder(pathnuevosResources);
				IPath pathDsl = recursoResource.getFullPath().append(voiceDsl.getName() + ".voiceDsl");
				VoiceDsl modificado = changeURI(pathDsl);
				locution.setLocution(modificado);
			}
		}

	}

	private static VoiceDsl changeURI(IPath resourcesPath) {
		VoiceDsl modificado = null;
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		Resource emfRes = resourceSetImpl.createResource(URI.createPlatformResourceURI(resourcesPath.toString(), true));
		try {
			emfRes.load(null);

			for (EObject obj : emfRes.getContents()) {
				if (obj instanceof VoiceDsl) {
					modificado = (VoiceDsl) obj;

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return modificado;
	}
}
