package com.vectorsf.jvoice.ui.project.editor.ui.provider;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.parsley.ui.provider.FormFeatureCaptionProvider;

@SuppressWarnings("all")
public class FormFeatureCaptionProviderGen extends FormFeatureCaptionProvider {
  public String text_EventHandler_event(final EStructuralFeature it) {
    return "Event name";
  }
  
  public String text_EventHandler_handler(final EStructuralFeature it) {
    return "Handled by";
  }
  
  public String text_NamedElement_name(final EStructuralFeature it) {
    return "Name";
  }
  
  public String text_NamedElement_description(final EStructuralFeature it) {
    return "Description";
  }
  
  public String text_JVModule_componentsPackage(final EStructuralFeature it) {
    return "Components package";
  }
  
  public String text_JVApplication_legacyLogger(final EStructuralFeature it) {
    return "Uses legacy logger";
  }
}
