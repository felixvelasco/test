package com.vectorsf.jvoice.ui.diagram.properties.section.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public interface IObjectChooser {

	Object getValue(EObject bo, TransactionalEditingDomain editingDomain);

}
