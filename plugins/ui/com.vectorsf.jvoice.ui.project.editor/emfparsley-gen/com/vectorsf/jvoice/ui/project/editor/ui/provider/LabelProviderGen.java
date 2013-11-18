package com.vectorsf.jvoice.ui.project.editor.ui.provider;

import com.google.inject.Inject;
import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.parsley.ui.provider.ViewerLabelProvider;

@SuppressWarnings("all")
public class LabelProviderGen extends ViewerLabelProvider {
  @Inject
  public LabelProviderGen(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public String text(final JVProject it) {
    String _name = it.getName();
    return _name;
  }
  
  public String text(final JVBean it) {
    JVPackage _ownerPackage = it.getOwnerPackage();
    String _name = _ownerPackage.getName();
    String _plus = (_name + ".");
    String _name_1 = it.getName();
    String _plus_1 = (_plus + _name_1);
    return _plus_1;
  }
  
  public String text(final EventHandler it) {
    return "Specify event handling";
  }
}
