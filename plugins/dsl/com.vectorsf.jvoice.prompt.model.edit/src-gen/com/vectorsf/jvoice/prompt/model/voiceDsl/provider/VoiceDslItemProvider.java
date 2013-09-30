/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.provider;


import com.vectorsf.jvoice.model.base.provider.JVBeanItemProvider;

import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslFactory;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

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
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VoiceDslItemProvider
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
	public VoiceDslItemProvider(AdapterFactory adapterFactory) {
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

			addInputDslPropertyDescriptor(object);
			addPromptDslPropertyDescriptor(object);
			addMenuDslPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Input Dsl feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputDslPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VoiceDsl_inputDsl_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_VoiceDsl_inputDsl_feature", "_UI_VoiceDsl_type"),
				 VoiceDslPackage.Literals.VOICE_DSL__INPUT_DSL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Prompt Dsl feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPromptDslPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VoiceDsl_promptDsl_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_VoiceDsl_promptDsl_feature", "_UI_VoiceDsl_type"),
				 VoiceDslPackage.Literals.VOICE_DSL__PROMPT_DSL,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Menu Dsl feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMenuDslPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VoiceDsl_menuDsl_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_VoiceDsl_menuDsl_feature", "_UI_VoiceDsl_type"),
				 VoiceDslPackage.Literals.VOICE_DSL__MENU_DSL,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__CONFIGURATION);
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__PROPERTIES);
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__CONDITIONS);
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__AUDIOS);
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__GRAMMARS);
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__VARIABLES);
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__TYPES);
			childrenFeatures.add(VoiceDslPackage.Literals.VOICE_DSL__OUTPUTS);
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
	 * This returns VoiceDsl.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/VoiceDsl"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((VoiceDsl)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_VoiceDsl_type") :
			getString("_UI_VoiceDsl_type") + " " + label;
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

		switch (notification.getFeatureID(VoiceDsl.class)) {
			case VoiceDslPackage.VOICE_DSL__CONFIGURATION:
			case VoiceDslPackage.VOICE_DSL__PROPERTIES:
			case VoiceDslPackage.VOICE_DSL__CONDITIONS:
			case VoiceDslPackage.VOICE_DSL__AUDIOS:
			case VoiceDslPackage.VOICE_DSL__GRAMMARS:
			case VoiceDslPackage.VOICE_DSL__VARIABLES:
			case VoiceDslPackage.VOICE_DSL__TYPES:
			case VoiceDslPackage.VOICE_DSL__OUTPUTS:
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
				(VoiceDslPackage.Literals.VOICE_DSL__CONFIGURATION,
				 VoiceDslFactory.eINSTANCE.createConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__PROPERTIES,
				 VoiceDslFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__CONDITIONS,
				 VoiceDslFactory.eINSTANCE.createCondition()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__AUDIOS,
				 VoiceDslFactory.eINSTANCE.createAudios()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__GRAMMARS,
				 VoiceDslFactory.eINSTANCE.createGrammars()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__VARIABLES,
				 VoiceDslFactory.eINSTANCE.createVariables()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__TYPES,
				 VoiceDslFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__TYPES,
				 VoiceDslFactory.eINSTANCE.createClass()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.VOICE_DSL__OUTPUTS,
				 VoiceDslFactory.eINSTANCE.createOutputs()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return VoiceDslEditPlugin.INSTANCE;
	}

}
