package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import com.vectorsf.jvoice.model.operations.SwitchState;

public class SwitchStateFilter extends AbstractPropertySectionFilter {
	
    @Override
    protected boolean accept(PictogramElement pe) {
        EObject eObject =
            Graphiti.getLinkService()
            .getBusinessObjectForLinkedPictogramElement(pe);
        if (eObject instanceof SwitchState) {
            return true;
        }
        return false;
    }


}
