package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.log.Logger;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.DefaultFeatureProviderWithPatterns;
import org.eclipse.graphiti.pattern.IPattern;
import org.osgi.service.log.LogService;

import com.vectorsf.jvoice.diagram.core.Activator;
import com.vectorsf.jvoice.diagram.core.features.editing.TextEventDirectEditFeature;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionSwitchPattern;

public class CoreFeatureProvider extends DefaultFeatureProviderWithPatterns {
	public static final String PATTERN_EXTENSIONS_ID = "com.vectorsf.jvoice.diagram.core.patternContributor"; //$NON-NLS-1$

	public CoreFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(PATTERN_EXTENSIONS_ID);

		try {
			for (IConfigurationElement configEl : config) {
				Object o;
				o = configEl
						.createExecutableExtension("patternContributorClass");
				if (o instanceof IPattern) {
					IPattern patternContributor = (IPattern) o;
					addPattern(patternContributor);
				}
			}
		} catch (CoreException e) {
			Logger logger = Activator.getLogger();
			if (logger != null) {
				logger.log(
						LogService.LOG_ERROR,
						"CoreFeatureProvider::CoreFeatureProvider, Error adding patterns",
						e);
			}
		}
		addConnectionPattern(new TransitionPattern(this));
		addConnectionPattern(new TransitionSwitchPattern(this));

	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(
			IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (pe instanceof ConnectionDecorator) {
			return new TextEventDirectEditFeature(this);
		}
		return super.getDirectEditingFeature(context);
	}

}
