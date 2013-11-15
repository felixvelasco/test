package com.vectorsf.jvoice.ui.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.builders.TableViewerEditableColumnBuilder;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Composite;

public class TableViewerReferenceEditableColumnBuilder extends TableViewerEditableColumnBuilder {

	public TableViewerReferenceEditableColumnBuilder() {
		super();
	}

	@Override
	protected TableViewerColumn buildTableViewerColumn(TableViewer tableViewer, TableLayout layout,
			EStructuralFeature eStructuralFeature, IStructuredContentProvider contentProvider, int weight) {
		TableViewerColumn viewerColumn = super.buildTableViewerColumn(tableViewer, layout, eStructuralFeature,
				contentProvider, weight);

		if (eStructuralFeature instanceof EReference && isEditable(eStructuralFeature)) {
			viewerColumn.setEditingSupport(new ReferenceComboEditingSupport(tableViewer,
					(EReference) eStructuralFeature));
		}

		return viewerColumn;
	}

	protected boolean isEditable(EStructuralFeature eStructuralFeature) {
		return true;
	}

	protected String getLabel(EObject eObject) {
		return eObject.toString();
	}

	protected List<EObject> collectCandidates(Object object, EReference feature) {
		Set<EObject> set = new HashSet<>();

		EClass eClass = feature.getEReferenceType();

		if (object instanceof EObject) {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(object);
			for (Iterator<Object> it = EcoreUtil.getAllContents(editingDomain.getResourceSet(), false); it.hasNext();) {
				Object obj = it.next();
				if (eClass.isInstance(obj)) {
					set.add((EObject) obj);
				}
			}
		}

		return new ArrayList<>(set);
	}

	class ReferenceComboEditingSupport extends EditingSupport {

		private ColumnViewer viewer;
		private EReference feature;
		private List<EObject> candidates;

		public ReferenceComboEditingSupport(ColumnViewer viewer, EReference reference) {
			super(viewer);
			this.viewer = viewer;
			this.feature = reference;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {

			candidates = collectCandidates(element, feature);
			String[] descriptions = new String[candidates.size()];
			int i = 0;
			for (EObject candidate : candidates) {
				descriptions[i++] = getLabel(candidate);
			}

			return new ComboBoxCellEditor((Composite) getViewer().getControl(), descriptions);

		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			if (element != null && element instanceof EObject) {
				EObject eObject = (EObject) element;
				if (eObject.eGet(feature) instanceof EObject) {
					EObject value = (EObject) eObject.eGet(feature);
					return candidates.indexOf(value);
				}
			}
			return -1;
		}

		@Override
		protected void setValue(Object element, Object value) {
			Integer index = (Integer) value;
			EObject eObject = (EObject) element;
			EObject oldValue = (EObject) eObject.eGet(feature);

			if (oldValue != null && !oldValue.equals(candidates.get(index))) {
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
				Command setCommand = new SetCommand(domain, eObject, feature, candidates.get(index));
				domain.getCommandStack().execute(setCommand);
				viewer.refresh();
			}
		}
	}
}