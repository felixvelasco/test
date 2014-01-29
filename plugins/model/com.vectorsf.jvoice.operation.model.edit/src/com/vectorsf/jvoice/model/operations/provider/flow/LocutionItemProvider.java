package com.vectorsf.jvoice.model.operations.provider.flow;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslFactory;

public class LocutionItemProvider extends TransientFlowItemProvider {

	public LocutionItemProvider(AdapterFactory adapterFactory, Flow supplier) {
		super(adapterFactory, supplier);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(BasePackage.Literals.JV_PACKAGE__BEANS);
		}
		return childrenFeatures;
	}

	@Override
	public String getText(Object object) {
		return "definitions";
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/icon_nav_locutions.png");
	}

	@Override
	public Collection<?> getChildren(Object object) {
		IFile flowFile = (IFile) Platform.getAdapterManager().getAdapter(getFlow(), IFile.class);
		Collection<VoiceDsl> childrenCollection = new ArrayList<>();
		ResourceSet resourceSet = BaseModel.getInstance().getResourceSet();
		if (flowFile.exists()) {
			IPath resourcesPath = flowFile.getFullPath().removeFileExtension().addFileExtension("resources");
			IFolder resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(resourcesPath);

			if (resourcesFolder != null && resourcesFolder.exists()) {
				try {
					for (IResource resourceFile : resourcesFolder.members()) {
						if (resourceFile.getName().toString().endsWith("voiceDsl")) {
							URI emfURI = URI.createPlatformResourceURI(resourceFile.getFullPath().toString(), true);
							Resource resource = resourceSet.getResource(emfURI, false);
							if (resource == null) {
								resource = resourceSet.getResource(emfURI, true);
							} else if (resource.getTimeStamp() < resourceFile.getLocalTimeStamp()) {
								resource.unload();
								resource = resourceSet.getResource(emfURI, true);
							}

							EObject o = resource.getContents().get(0);

							if (o != null && o instanceof VoiceDsl) {
								VoiceDsl definition = (VoiceDsl) o;
								childrenCollection.add(definition);
							}
						}
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}

		return childrenCollection;
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(BasePackage.Literals.JV_PACKAGE__BEANS,
				VoiceDslFactory.eINSTANCE.createMenuDsl()));
		newChildDescriptors.add(createChildParameter(BasePackage.Literals.JV_PACKAGE__BEANS,
				VoiceDslFactory.eINSTANCE.createInputDsl()));
		newChildDescriptors.add(createChildParameter(BasePackage.Literals.JV_PACKAGE__BEANS,
				VoiceDslFactory.eINSTANCE.createPromptDsl()));
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		if (new AddCommand(domain, (EObject) owner, BasePackage.Literals.JV_PACKAGE__BEANS, collection).canExecute()) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}
		return UnexecutableCommand.INSTANCE;
	}

}