package com.vectorsf.jvoice.ui.diagram.properties.section;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.ui.diagram.properties.Activator;
import com.vectorsf.jvoice.ui.diagram.properties.editing.ConditionEditingSupport;
import com.vectorsf.jvoice.ui.diagram.properties.editing.EventNameEditingSupport;
import com.vectorsf.jvoice.ui.diagram.properties.listeners.ListenerIntentionName;
import com.vectorsf.jvoice.ui.diagram.properties.listeners.PropertiesListener;
import com.vectorsf.jvoice.ui.diagram.properties.provider.CaseContentProvider;
import com.vectorsf.jvoice.ui.diagram.properties.provider.CaseLabelProvider;

public class StateSection extends GFPropertySection implements ITabbedPropertyConstants {

	private static final String CONDITION = "Condition";
	private static final String NAME = "EventName";
	private static final String[] PROPS = { CONDITION, NAME };

	protected Text nameText;
	private Text locutionText;
	private Button btEditFlow;
	private Button btAdd;
	private Button btRemove;
	private Button btUp;
	private Button btDown;
	private FormData data;
	private Table table;
	private TableViewer tableViewer;
	private List<Case> casos = new ArrayList<Case>();
	private CLabel error;
	private static IFeatureProvider fp;
	private PictogramElement pe;
	private ListenerIntentionName nameStateListener;
	private PropertiesListener propertielistener;
	protected Composite composite;

	public StateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);

		nombre_path(factory, composite);
	}

	/**
	 * @param factory
	 * @param composite
	 */
	protected void tableSwitchCase(TabbedPropertySheetWidgetFactory factory, Composite composite) {
		// Tabla con los Case de un Switch
		table = factory.createTable(composite, SWT.SINGLE | SWT.FULL_SELECTION);
		data = new FormData();
		data.left = new FormAttachment(nameText, 0, SWT.LEFT);
		data.right = new FormAttachment(nameText, -120, SWT.RIGHT);
		data.top = new FormAttachment(nameText, 10);
		data.height = 110;
		table.setLayoutData(data);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);

		TableViewerColumn condition = createTableViewerColumn(CONDITION, 400);
		condition.setEditingSupport(new ConditionEditingSupport(tableViewer));
		TableViewerColumn eventName = createTableViewerColumn(NAME, 120);
		eventName.setEditingSupport(new EventNameEditingSupport(tableViewer, error, this));

		tableViewer.setContentProvider(new CaseContentProvider());
		tableViewer.setLabelProvider(new CaseLabelProvider());
		tableViewer.setInput(casos);

		CellEditor[] editors = new CellEditor[2];
		editors[0] = new TextCellEditor(table);
		editors[1] = new TextCellEditor(table);

		tableViewer.setColumnProperties(PROPS);
		tableViewer.setCellEditors(editors);

		propertielistener = new PropertiesListener(this, tableViewer);

		btAdd = factory.createButton(composite, "", SWT.PUSH);
		btAdd.setData("add");
		btAdd.setImage(Activator.getDefault().getImageRegistry().get("imageAdd"));
		data = new FormData();
		data.left = new FormAttachment(table, 5);
		data.top = new FormAttachment(table, 0, SWT.TOP);
		btAdd.setLayoutData(data);
		btAdd.addListener(SWT.Selection, propertielistener);

		btRemove = factory.createButton(composite, "", SWT.PUSH);
		btRemove.setData("remove");
		btRemove.setImage(Activator.getDefault().getImageRegistry().get("imageRemove"));
		data = new FormData();
		data.left = new FormAttachment(btAdd, 0, SWT.LEFT);
		data.right = new FormAttachment(btAdd, 0, SWT.RIGHT);
		data.top = new FormAttachment(btAdd, 10);
		btRemove.setLayoutData(data);
		btRemove.addListener(SWT.Selection, propertielistener);

		btUp = factory.createButton(composite, "", SWT.PUSH);
		btUp.setData("up");
		btUp.setImage(Activator.getDefault().getImageRegistry().get("imageUp"));
		data = new FormData();
		data.left = new FormAttachment(btAdd, 5);
		data.top = new FormAttachment(table, 0, SWT.TOP);
		btUp.setLayoutData(data);
		btUp.addListener(SWT.Selection, propertielistener);

		btDown = factory.createButton(composite, "", SWT.PUSH);
		btDown.setData("down");
		btDown.setImage(Activator.getDefault().getImageRegistry().get("imageDown"));
		data = new FormData();
		data.left = new FormAttachment(btUp, 0, SWT.LEFT);
		data.right = new FormAttachment(btUp, 0, SWT.RIGHT);
		data.top = new FormAttachment(btUp, 10);
		btDown.setLayoutData(data);
		btDown.addListener(SWT.Selection, propertielistener);
	}

	/**
	 * @param factory
	 * @param composite
	 */
	protected void nombre_path(TabbedPropertySheetWidgetFactory factory, Composite composite) {
		error = factory.createCLabel(composite, "", SWT.CENTER);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		error.setLayoutData(data);

		// Nombre del elemento
		nameText = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH + 50);
		data.right = new FormAttachment(error, 0, SWT.RIGHT);
		data.top = new FormAttachment(error, 10);
		nameText.setLayoutData(data);

		nameStateListener = new ListenerIntentionName(this, nameText);

		nameText.addFocusListener(nameStateListener);

		CLabel LabelName = factory.createCLabel(composite, "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameText, -HSPACE);
		data.top = new FormAttachment(nameText, 0, SWT.CENTER);
		LabelName.setLayoutData(data);

	}

	protected void subFlowPath(TabbedPropertySheetWidgetFactory factory, Composite composite, String nameLabel) {
		// Nombre del elemento

		locutionText = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(nameText, 0, SWT.LEFT);
		data.right = new FormAttachment(nameText, -120, SWT.RIGHT);
		data.top = new FormAttachment(nameText, 10);
		locutionText.setLayoutData(data);
		locutionText.setEditable(false);
		locutionText.setEnabled(false);

		CLabel LabelName = factory.createCLabel(composite, nameLabel);
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(locutionText, -HSPACE);
		data.top = new FormAttachment(locutionText, 0, SWT.CENTER);
		LabelName.setLayoutData(data);

		btEditFlow = factory.createButton(composite, "", SWT.PUSH);
		btEditFlow.setImage(Activator.getDefault().getImageRegistry().get("imageModify"));
		data = new FormData();
		data.left = new FormAttachment(locutionText, 5);
		data.top = new FormAttachment(locutionText, 0, SWT.CENTER);
		btEditFlow.setLayoutData(data);

		propertielistener = new PropertiesListener(this, locutionText);

		btEditFlow.addListener(SWT.Selection, propertielistener);
	}

	@Override
	public void refresh() {
		pe = getSelectedPictogramElement();
		if (pe != null) {
			fp = getDiagramTypeProvider().getFeatureProvider();

			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a EClass
			if (bo == null) {
				return;
			}

			removelistener(bo);
			refreshName(bo);

			if (bo instanceof SwitchState) {
				SwitchState switchState = (SwitchState) bo;
				casos = switchState.getCase();
				tableViewer.setInput(casos);
				addListenerSwtich();

			} else if (bo instanceof LocutionState) {
				LocutionState locutionState = (LocutionState) bo;
				if (locutionState.getLocution().getName() != null) {
					locutionText.setText(locutionState.getLocution().getName());
				} else {
					locutionText.setText("");
				}
				addListenerSubflujos();
			}
		}
	}

	private void addListenerSubflujos() {
		propertielistener = new PropertiesListener(this, locutionText);
		btEditFlow.addListener(SWT.Selection, propertielistener);
	}

	private void addListenerSwtich() {
		propertielistener = new PropertiesListener(this, tableViewer);
		btAdd.addListener(SWT.Selection, propertielistener);
		btRemove.addListener(SWT.Selection, propertielistener);
		btUp.addListener(SWT.Selection, propertielistener);
		btDown.addListener(SWT.Selection, propertielistener);
	}

	public PictogramElement obtenerPe() {
		return pe;
	}

	/**
	 * Eliminamos el listener
	 */
	protected void removelistener(Object bo) {
		nameText.removeFocusListener(nameStateListener);
		if (bo instanceof LocutionState) {

			btEditFlow.removeListener(SWT.Selection, propertielistener);
		} else if (bo instanceof SwitchState) {
			btAdd.removeListener(SWT.Selection, propertielistener);
			btRemove.removeListener(SWT.Selection, propertielistener);
			btUp.removeListener(SWT.Selection, propertielistener);
			btDown.removeListener(SWT.Selection, propertielistener);
		}
	}

	/**
	 * @param bo
	 */
	protected void refreshName(Object bo) {
		String name = null;
		name = ((State) bo).getName();
		nameText.setText(name == null ? "" : name);
		nameText.addFocusListener(new ListenerIntentionName(this, nameText));
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	public IFeatureProvider obtenerFeatureProvider() {
		return fp;
	}

	public List<Case> obtenerCases() {
		return casos;
	}
}