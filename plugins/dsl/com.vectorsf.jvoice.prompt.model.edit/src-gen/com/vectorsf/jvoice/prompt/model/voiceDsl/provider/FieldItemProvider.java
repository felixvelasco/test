/**
 */
package com.vectorsf.jvoice.prompt.model.voiceDsl.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory;

import com.vectorsf.jvoice.prompt.model.voiceDsl.Field;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslPackage;

/**
 * This is the item provider adapter for a {@link com.vectorsf.jvoice.prompt.model.voiceDsl.Field} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@SuppressWarnings("restriction")
public class FieldItemProvider extends MemberItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FieldItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExtensionPropertyDescriptor(object);
			addFinalPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addStaticPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Extension feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExtensionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Field_extension_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Field_extension_feature", "_UI_Field_type"),
				VoiceDslPackage.Literals.FIELD__EXTENSION, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Final feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFinalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Field_final_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Field_final_feature", "_UI_Field_type"),
				VoiceDslPackage.Literals.FIELD__FINAL, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Field_name_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Field_name_feature", "_UI_Field_type"),
				VoiceDslPackage.Literals.FIELD__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Static feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addStaticPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Field_static_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_Field_static_feature", "_UI_Field_type"),
				VoiceDslPackage.Literals.FIELD__STATIC, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(VoiceDslPackage.Literals.FIELD__TYPE);
			childrenFeatures.add(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Field.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Field"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Field) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Field_type") : getString("_UI_Field_type") + " "
				+ label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Field.class)) {
		case VoiceDslPackage.FIELD__EXTENSION:
		case VoiceDslPackage.FIELD__FINAL:
		case VoiceDslPackage.FIELD__NAME:
		case VoiceDslPackage.FIELD__STATIC:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case VoiceDslPackage.FIELD__TYPE:
		case VoiceDslPackage.FIELD__INITIAL_VALUE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmParameterizedTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmWildcardTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmAnyTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmMultiTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmDelegateTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmSynonymTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__TYPE,
				TypesFactory.eINSTANCE.createJvmUnknownTypeReference()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XAnnotationsFactory.eINSTANCE.createXAnnotation()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XAnnotationsFactory.eINSTANCE.createXAnnotationElementValueBinaryOperation()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXIfExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXSwitchExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXBlockExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXVariableDeclaration()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXMemberFeatureCall()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXFeatureCall()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXConstructorCall()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXBooleanLiteral()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXNullLiteral()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXNumberLiteral()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXStringLiteral()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXListLiteral()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXSetLiteral()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXClosure()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXCastedExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXBinaryOperation()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXUnaryOperation()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXForLoopExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXDoWhileExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXWhileExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXTypeLiteral()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXInstanceOfExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXThrowExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXTryCatchFinallyExpression()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXAssignment()));

		newChildDescriptors.add(createChildParameter(VoiceDslPackage.Literals.FIELD__INITIAL_VALUE,
				XbaseFactory.eINSTANCE.createXReturnExpression()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == VoiceDslPackage.Literals.MEMBER__ANNOTATIONS
				|| childFeature == VoiceDslPackage.Literals.FIELD__INITIAL_VALUE;

		if (qualify) {
			return getString("_UI_CreateChild_text2", new Object[] { getTypeText(childObject),
					getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
