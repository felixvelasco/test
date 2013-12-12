package com.isb.bks.ivr.voice.m2e.builder.internal;

import java.io.File;
import java.util.Set;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.IMaven;
import org.eclipse.m2e.core.project.configurator.MojoExecutionBuildParticipant;
import org.sonatype.plexus.build.incremental.BuildContext;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;

public class JVoiceModuleBuildParticipant extends MojoExecutionBuildParticipant {

	private IPath pkgPath = new Path(BaseModel.JV_PATH);
	private MarkerHelper helper;

	public JVoiceModuleBuildParticipant(MojoExecution execution) {
		super(execution, true);
		helper = new EditUIMarkerHelper();
	}

	@Override
	public Set<IProject> build(int kind, IProgressMonitor monitor) throws Exception {
		IMaven maven = MavenPlugin.getMaven();
		BuildContext buildContext = getBuildContext();

		IResourceDelta delta = getDelta(getMavenProjectFacade().getProject());
		if (delta != null && delta.getKind() == IResourceDelta.CHANGED) {
			for (IResourceDelta delt : delta.getAffectedChildren()) {
				IResource resource = delt.getResource();
				if (resource instanceof IFolder) {
					DeleteFileXML delete = new DeleteFileXML();
					try {
						delt.accept(delete);
					} catch (CoreException e) {
					}
				}

			}
		}

		cleanMarkers(delta);

		if (!validate(delta)) {
			return null;
		}

		// execute mojo
		Set<IProject> result = super.build(kind, monitor);

		// tell m2e builder to refresh generated files
		File generated = maven.getMojoParameterValue(getSession().getCurrentProject(), getMojoExecution(),
				"outputDirectory", File.class, monitor);
		if (generated != null) {
			buildContext.refresh(generated);
		}

		return result;
	}

	private boolean validate(IResourceDelta delta) throws CoreException {
		ValidateVisitor visitor = new ValidateVisitor();
		delta.accept(visitor);
		helper.createMarkers(visitor.getDiagnostic());

		return visitor.isValid();
	}

	private void cleanMarkers(IResourceDelta delta) throws CoreException {
		delta.accept(new RemoveMarkersVisitor());
	}

	public class RemoveMarkersVisitor implements IResourceDeltaVisitor {

		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			if (delta.getResource() instanceof IFile) {
				helper.deleteMarkers(delta.getResource());
				return false;
			} else {
				return delta.getKind() != IResourceDelta.REMOVED;
			}
		}

	}

	public class ValidateVisitor implements IResourceDeltaVisitor {

		private BasicDiagnostic chain = new BasicDiagnostic();

		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			if (delta.getResource() instanceof IFile && delta.getKind() != IResourceDelta.REMOVED) {
				IFile file = (IFile) delta.getResource();
				if (file.getName().endsWith(".voiceDsl") || file.getName().endsWith(".jvflow")) {
					chain.add(validateEObject(file));
				}
				return false;
			} else {
				return delta.getKind() != IResourceDelta.REMOVED;
			}
		}

		private Diagnostic validateEObject(IFile file) {
			BasicDiagnostic ret = new BasicDiagnostic();
			ResourceSet rset = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			try {
				Resource resource = rset.getResource(uri, true);
				for (EObject obj : resource.getContents()) {
					ret.merge(Diagnostician.INSTANCE.validate(obj));
				}

			} catch (RuntimeException re) {
				ret.merge(BasicDiagnostic.toDiagnostic(re));
			}
			return ret;
		}

		public boolean isValid() {
			return chain.getSeverity() < Diagnostic.ERROR;
		}

		public Diagnostic getDiagnostic() {
			return chain;
		}

	}

	private IPath getRelativePath(IResource resource) {
		if (pkgPath.isPrefixOf(resource.getProjectRelativePath()) && !pkgPath.equals(resource.getProjectRelativePath())) {
			return resource.getProjectRelativePath().makeRelativeTo(pkgPath);
		} else {
			return null;
		}
	}

	private JVBean getBeanFromResource(Resource eResource) {
		for (EObject e : eResource.getContents()) {
			if (e instanceof JVBean) {
				return (JVBean) e;
			}
		}
		return null;
	}

}
