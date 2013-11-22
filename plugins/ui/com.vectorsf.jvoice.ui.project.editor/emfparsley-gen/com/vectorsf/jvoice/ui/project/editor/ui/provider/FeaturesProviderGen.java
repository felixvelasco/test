package com.vectorsf.jvoice.ui.project.editor.ui.provider;

import org.eclipse.emf.parsley.ui.provider.EClassToEStructuralFeatureAsStringsMap;
import org.eclipse.emf.parsley.ui.provider.FeaturesProvider;

@SuppressWarnings("all")
public class FeaturesProviderGen extends FeaturesProvider {
  @Override
  public void buildStringMap(final EClassToEStructuralFeatureAsStringsMap stringMap) {
    super.buildStringMap(stringMap);
    
    stringMap.mapTo("com.vectorsf.jvoice.model.base.JVModule",
      "name", "description");
    stringMap.mapTo("com.vectorsf.jvoice.model.base.JVApplication",
      "name", "description");
    stringMap.mapTo("com.vectorsf.jvoice.model.base.EventHandler",
      "event", "handler");
  }
}
