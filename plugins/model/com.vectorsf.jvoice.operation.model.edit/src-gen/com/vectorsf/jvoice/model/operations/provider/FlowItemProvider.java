/**
 */
package com.vectorsf.jvoice.model.operations.provider;


import com.vectorsf.jvoice.model.base.provider.JVBeanItemProvider;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.vectorsf.jvoice.model.operations.Flow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowItemProvider
	extends JVBeanItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNotesPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
			addHelperClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Notes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Flow_notes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Flow_notes_feature", "_UI_Flow_type"),
				 OperationsPackage.Literals.FLOW__NOTES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Flow_parameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Flow_parameters_feature", "_UI_Flow_type"),
				 OperationsPackage.Literals.FLOW__PARAMETERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Helper Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHelperClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Flow_helperClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Flow_helperClass_feature", "_UI_Flow_type"),
				 OperationsPackage.Literals.FLOW__HELPER_CLASS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OperationsPackage.Literals.FLOW__STATES);
			childrenFeatures.add(OperationsPackage.Literals.FLOW__TRANSITIONS);
			childrenFeatures.add(OperationsPackage.Literals.FLOW__BEANS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Flow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Flow"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Flow)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Flow_type") :
			getString("_UI_Flow_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Flow.class)) {
			case OperationsPackage.FLOW__PARAMETERS:
			case OperationsPackage.FLOW__HELPER_CLASS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case OperationsPackage.FLOW__STATES:
			case OperationsPackage.FLOW__TRANSITIONS:
			case OperationsPackage.FLOW__BEANS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createInitialState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createFinalState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createSwitchState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createCallState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createCallFlowState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createPromptState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createInputState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createMenuState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createTransferState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createRecordState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__STATES,
				 OperationsFactory.eINSTANCE.createCustomState()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__TRANSITIONS,
				 OperationsFactory.eINSTANCE.createTransition()));

		newChildDescriptors.add
			(createChildParameter
				(OperationsPackage.Literals.FLOW__BEANS,
				 OperationsFactory.eINSTANCE.createComponentBean()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CoreOperationsEditPlugin.INSTANCE;
	}

}
