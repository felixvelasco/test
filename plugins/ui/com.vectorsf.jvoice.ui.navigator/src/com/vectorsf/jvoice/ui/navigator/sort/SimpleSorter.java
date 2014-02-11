package com.vectorsf.jvoice.ui.navigator.sort;

import java.text.Collator;

import org.eclipse.jface.viewers.ViewerSorter;

import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVProject;

public class SimpleSorter extends ViewerSorter {

	public SimpleSorter() {
	}

	public SimpleSorter(Collator collator) {
		super(collator);
	}

	@Override
	public int category(Object element) {
		if (element instanceof JVApplication) {
			return 1;
		} else if (element instanceof JVProject) {
			return 2;
		}
		return 3;
	}

}
