/**
 */
package com.isb.bks.ivr.voice.dsl.voiceDsl.provider;


import com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslFactory;
import com.isb.bks.ivr.voice.dsl.voiceDsl.VoiceDslPackage;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InputElementItemProvider
	extends ItemProviderAdapter
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
	public InputElementItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addMaxNoInputPropertyDescriptor(object);
			addMaxNoMatchPropertyDescriptor(object);
			addMaxAttemptsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InputElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InputElement_name_feature", "_UI_InputElement_type"),
				 VoiceDslPackage.Literals.INPUT_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max No Input feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxNoInputPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InputElement_maxNoInput_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InputElement_maxNoInput_feature", "_UI_InputElement_type"),
				 VoiceDslPackage.Literals.INPUT_ELEMENT__MAX_NO_INPUT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max No Match feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxNoMatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InputElement_maxNoMatch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InputElement_maxNoMatch_feature", "_UI_InputElement_type"),
				 VoiceDslPackage.Literals.INPUT_ELEMENT__MAX_NO_MATCH,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Attempts feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxAttemptsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InputElement_maxAttempts_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InputElement_maxAttempts_feature", "_UI_InputElement_type"),
				 VoiceDslPackage.Literals.INPUT_ELEMENT__MAX_ATTEMPTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(VoiceDslPackage.Literals.INPUT_ELEMENT__GRAMMATICS);
			childrenFeatures.add(VoiceDslPackage.Literals.INPUT_ELEMENT__INITIAL_AUDIOS);
			childrenFeatures.add(VoiceDslPackage.Literals.INPUT_ELEMENT__NO_MATCH_AUDIOS);
			childrenFeatures.add(VoiceDslPackage.Literals.INPUT_ELEMENT__NO_INPUT_AUDIOS);
			childrenFeatures.add(VoiceDslPackage.Literals.INPUT_ELEMENT__MATCH_AUDIOS);
			childrenFeatures.add(VoiceDslPackage.Literals.INPUT_ELEMENT__CONDITIONS);
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
	 * This returns InputElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InputElement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((InputElement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_InputElement_type") :
			getString("_UI_InputElement_type") + " " + label;
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

		switch (notification.getFeatureID(InputElement.class)) {
			case VoiceDslPackage.INPUT_ELEMENT__NAME:
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_INPUT:
			case VoiceDslPackage.INPUT_ELEMENT__MAX_NO_MATCH:
			case VoiceDslPackage.INPUT_ELEMENT__MAX_ATTEMPTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case VoiceDslPackage.INPUT_ELEMENT__GRAMMATICS:
			case VoiceDslPackage.INPUT_ELEMENT__INITIAL_AUDIOS:
			case VoiceDslPackage.INPUT_ELEMENT__NO_MATCH_AUDIOS:
			case VoiceDslPackage.INPUT_ELEMENT__NO_INPUT_AUDIOS:
			case VoiceDslPackage.INPUT_ELEMENT__MATCH_AUDIOS:
			case VoiceDslPackage.INPUT_ELEMENT__CONDITIONS:
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
				(VoiceDslPackage.Literals.INPUT_ELEMENT__GRAMMATICS,
				 VoiceDslFactory.eINSTANCE.createGrammar()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__INITIAL_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__INITIAL_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createConditionalAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__NO_MATCH_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__NO_MATCH_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createConditionalAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__NO_INPUT_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__NO_INPUT_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createConditionalAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__MATCH_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__MATCH_AUDIOS,
				 VoiceDslFactory.eINSTANCE.createConditionalAudio()));

		newChildDescriptors.add
			(createChildParameter
				(VoiceDslPackage.Literals.INPUT_ELEMENT__CONDITIONS,
				 VoiceDslFactory.eINSTANCE.createCondition()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == VoiceDslPackage.Literals.INPUT_ELEMENT__INITIAL_AUDIOS ||
			childFeature == VoiceDslPackage.Literals.INPUT_ELEMENT__NO_MATCH_AUDIOS ||
			childFeature == VoiceDslPackage.Literals.INPUT_ELEMENT__NO_INPUT_AUDIOS ||
			childFeature == VoiceDslPackage.Literals.INPUT_ELEMENT__MATCH_AUDIOS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
