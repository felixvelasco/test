package com.vectorsf.jvoice.ui.navigator.sort;

import java.text.Collator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class SimpleSorter extends ViewerSorter {

	public SimpleSorter() {
	}

	public SimpleSorter(Collator collator) {
		super(collator);
	}

	@Override
	public int category(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eClass().getClassifierID();
		}
		return 0;
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		int cat1 = category(e1);
		int cat2 = category(e2);

		if (cat1 != cat2) {
			return cat1 - cat2;
		}

		String name1 = getLabel(viewer, e1);
		String name2 = getLabel(viewer, e2);
		return getComparator().compare(name1, name2);
	}

	private String getLabel(Viewer viewer, Object e1) {
		String name1;
		if (viewer == null || !(viewer instanceof ContentViewer)) {
			name1 = e1.toString();
		} else {
			IBaseLabelProvider prov = ((ContentViewer) viewer).getLabelProvider();
			if (prov instanceof DecoratingStyledCellLabelProvider) {
				DecoratingStyledCellLabelProvider lprov = (DecoratingStyledCellLabelProvider) prov;
				name1 = lprov.getStyledStringProvider().getStyledText(e1).getString();

			} else if (prov instanceof ILabelProvider) {
				ILabelProvider lprov = (ILabelProvider) prov;
				name1 = lprov.getText(e1);
			} else {
				name1 = e1.toString();
			}
		}
		if (name1 == null) {
			name1 = "";//$NON-NLS-1$
		}
		return name1;
	}
}
