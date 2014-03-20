package com.vectorsf.jvoice.diagram.core.editor;

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.actions.MatchHeightAction;
import org.eclipse.gef.ui.actions.MatchWidthAction;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ISaveImageFeature;
import org.eclipse.graphiti.ui.editor.DefaultMarkerBehavior;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.editor.IDiagramEditorInput;
import org.eclipse.graphiti.ui.internal.action.CopyAction;
import org.eclipse.graphiti.ui.internal.action.DeleteAction;
import org.eclipse.graphiti.ui.internal.action.FeatureExecutionHandler;
import org.eclipse.graphiti.ui.internal.action.PasteAction;
import org.eclipse.graphiti.ui.internal.action.SaveImageAction;
import org.eclipse.graphiti.ui.internal.action.ToggleContextButtonPadAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.handlers.IHandlerService;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;

@SuppressWarnings("restriction")
public class JVoiceDiagramBehavior extends DiagramBehavior {

	private JVoiceValidationListener validator;
	private TransactionalEditingDomain domain;
	private boolean readOnly;

	public JVoiceDiagramBehavior(IDiagramContainerUI diagramContainer, TransactionalEditingDomain domain) {
		super(diagramContainer);
		this.domain = domain;
	}

	@Override
	protected void editingDomainInitialized() {
		super.editingDomainInitialized();
		getResourceSet().getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, new VegaXMLURIHandlerImpl());
	}

	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new JVoicePersistencyBehavior(this);
	}

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new JVoiceUpdateBehavior(this, domain);
	}

	@Override
	protected DefaultMarkerBehavior createMarkerBehavior() {
		DefaultMarkerBehavior defaultMarkerBehavior = super.createMarkerBehavior();
		defaultMarkerBehavior.disableProblemIndicationUpdate();

		return defaultMarkerBehavior;
	}

	@Override
	protected void setInput(IDiagramEditorInput input) {
		super.setInput(input);
		validator = new JVoiceValidationListener(this);
		getEditingDomain().addResourceSetListener(validator);
		validator.validate();
	}

	@Override
	protected void initActionRegistry(ZoomManager zoomManager) {
		if (getParentPart() == null) {
			return;
		}
		final ActionRegistry actionRegistry = getDiagramContainer().getActionRegistry();
		@SuppressWarnings("unchecked")
		final List<String> selectionActions = getDiagramContainer().getSelectionActions();

		// register predefined actions (e.g. update, remove, delete, ...)

		IAction action = new DeleteAction(getParentPart(), getConfigurationProvider());
		actionRegistry.registerAction(action);
		selectionActions.add(action.getId());

		action = new CopyAction(getParentPart(), getConfigurationProvider());
		actionRegistry.registerAction(action);
		selectionActions.add(action.getId());

		action = new PasteAction(getParentPart(), getConfigurationProvider());
		actionRegistry.registerAction(action);
		selectionActions.add(action.getId());

		IFeatureProvider fp = getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();
		if (fp != null) {
			ISaveImageFeature sf = fp.getSaveImageFeature();

			if (sf != null) {
				action = new SaveImageAction(this, getConfigurationProvider());
				actionRegistry.registerAction(action);
				selectionActions.add(action.getId());
			}
		}

		registerAction(new ZoomInAction(zoomManager));
		registerAction(new ZoomOutAction(zoomManager));
		registerAction(new DirectEditAction(getParentPart()));

		registerAction(new AlignmentAction(getParentPart(), PositionConstants.LEFT));
		registerAction(new AlignmentAction(getParentPart(), PositionConstants.RIGHT));
		registerAction(new AlignmentAction(getParentPart(), PositionConstants.TOP));
		registerAction(new AlignmentAction(getParentPart(), PositionConstants.BOTTOM));
		registerAction(new AlignmentAction(getParentPart(), PositionConstants.CENTER));
		registerAction(new AlignmentAction(getParentPart(), PositionConstants.MIDDLE));
		registerAction(new MatchWidthAction(getParentPart()));
		registerAction(new MatchHeightAction(getParentPart()));
		IAction showGrid = new ToggleGridAction(getDiagramContainer().getGraphicalViewer());
		getDiagramContainer().getActionRegistry().registerAction(showGrid);

		// Bug 323351: Add button to toggle a flag if the context pad buttons
		// shall be shown or not
		IAction toggleContextButtonPad = new ToggleContextButtonPadAction(this);
		toggleContextButtonPad.setChecked(false);
		actionRegistry.registerAction(toggleContextButtonPad);
		// End bug 323351

		IHandlerService hs = (IHandlerService) getParentPart().getSite().getService(IHandlerService.class);
		hs.activateHandler(FeatureExecutionHandler.COMMAND_ID, new FeatureExecutionHandler(getConfigurationProvider()));
	}

	@Override
	public void disableAdapters() {
		super.disableAdapters();
	}

	@Override
	public void enableAdapters() {
		super.enableAdapters();
	}

	/**
	 * Para que refresque los estados al arrancar el editor. Por ejemplo, que actualice los options del estado Menu.
	 */
	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {
		return new JVoiceRefreshBehavior(this);
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	@Override
	protected boolean isDirty() {
		return getPersistencyBehavior().isDirty();
	}
}
