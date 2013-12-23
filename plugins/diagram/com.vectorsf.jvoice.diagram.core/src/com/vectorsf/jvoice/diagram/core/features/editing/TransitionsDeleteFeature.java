package com.vectorsf.jvoice.diagram.core.features.editing;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMultiDeleteInfo;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.features.context.impl.RemoveContext;
import org.eclipse.graphiti.mm.pictograms.CompositeConnection;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

public class TransitionsDeleteFeature extends DefaultDeleteFeature {

	private boolean dialog = true;

	public TransitionsDeleteFeature(IFeatureProvider fp) {
		super(fp);
	}

	public TransitionsDeleteFeature(IFeatureProvider fp, boolean dialog) {
		super(fp);
		this.dialog = dialog;
	}

	@Override
	public void delete(IDeleteContext context) {
		// we need this reset, since the an instance of this feature can be
		// used multiple times, e.g. as a part of a pattern
		setDoneChanges(false);

		if (context.getPictogramElement() instanceof FreeFormConnection) {
			deleteConnection(context);
		}
		return;

	}

	@Override
	public boolean canDelete(IDeleteContext context) {

		return context.getPictogramElement() instanceof FreeFormConnection;

	}

	public void deleteConnection(IDeleteContext context) {
		IMultiDeleteInfo multiDeleteInfo = context.getMultiDeleteInfo();
		if (multiDeleteInfo != null && multiDeleteInfo.isDeleteCanceled()) {
			return;
		}
		PictogramElement pe = context.getPictogramElement();
		Object[] businessObjectsForPictogramElement = getAllBusinessObjectsForPictogramElement(pe);
		if (businessObjectsForPictogramElement != null && businessObjectsForPictogramElement.length > 0) {
			if (multiDeleteInfo == null) {
				if (dialog) {
					if (!getUserDecision(context)) {
						return;
					}
				}
			} else {
				if (multiDeleteInfo.isShowDialog()) {
					boolean okPressed = getUserDecision(context);
					if (okPressed) {
						// don't show further dialogs
						multiDeleteInfo.setShowDialog(false);
					} else {
						multiDeleteInfo.setDeleteCanceled(true);
						return;
					}
				}
			}
		}

		preDelete(context);

		Connection connection = (Connection) pe;
		DeleteContext ctx = new DeleteContext(connection);
		ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 1));
		IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(ctx);
		if (deleteFeature != null) {
			super.delete(ctx);
		}

		if (pe instanceof CompositeConnection) {
			// Find all domain objects for the children connections of the
			// composite connection...
			List<Object> compositeChildConnectionsBOs = collectCompositeConnectionsBOs((CompositeConnection) pe);
			// ... and add them to the list of BOs to delete (no duplicates)
			for (Object object : businessObjectsForPictogramElement) {
				if (!compositeChildConnectionsBOs.contains(object)) {
					compositeChildConnectionsBOs.add(object);
				}
			}
			// Update BOs to delete
			businessObjectsForPictogramElement = compositeChildConnectionsBOs
					.toArray(new Object[compositeChildConnectionsBOs.size()]);
		}
		IRemoveContext rc = new RemoveContext(pe);
		IFeatureProvider featureProvider = getFeatureProvider();
		IRemoveFeature removeFeature = featureProvider.getRemoveFeature(rc);
		if (removeFeature != null) {
			removeFeature.remove(rc);
			// Bug 347421: Set hasDoneChanges flag only after first modification
			setDoneChanges(true);
		}

		deleteBusinessObjects(businessObjectsForPictogramElement);

		postDelete(context);
	}

	private List<Object> collectCompositeConnectionsBOs(CompositeConnection composite) {
		List<Object> result = new ArrayList<Object>();
		for (Connection childConnection : composite.getChildren()) {
			Object[] allBusinessObjectsForChildConnection = getAllBusinessObjectsForPictogramElement(childConnection);
			for (Object object : allBusinessObjectsForChildConnection) {
				if (!result.contains(object)) {
					result.add(object);
				}
			}
		}
		return result;
	}

}
