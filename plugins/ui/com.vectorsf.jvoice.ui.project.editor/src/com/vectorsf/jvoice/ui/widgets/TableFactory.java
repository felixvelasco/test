package com.vectorsf.jvoice.ui.widgets;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author bettini
 * 
 */
public class TableFactory {

	@Inject
	protected MembersInjector<TableComposite> tableCompositeMembersInjector;

	@Inject
	public TableFactory() {

	}

	public TableComposite createTableComposite(Composite parent, int style, EClass type) {
		TableComposite tableComposite = new TableComposite(parent, style);
		tableCompositeMembersInjector.injectMembers(tableComposite);
		tableComposite.buildTable(type);
		return tableComposite;
	}

	public TableComposite createTableComposite(Composite parent, int style) {
		TableComposite tableComposite = new TableComposite(parent, style, true);
		tableCompositeMembersInjector.injectMembers(tableComposite);
		return tableComposite;
	}
}
