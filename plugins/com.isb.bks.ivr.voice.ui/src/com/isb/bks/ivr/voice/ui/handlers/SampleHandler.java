package com.isb.bks.ivr.voice.ui.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.isb.bks.ivr.voice.dsl.voiceDsl.Grammar;
import com.isb.bks.ivr.voice.dsl.voiceDsl.InputElement;

public class SampleHandler extends AbstractHandler {

    /**
     * The constructor.
     */
    public SampleHandler() {
    }

    /**
     * the command has been executed, so extract extract the needed information
     * from the application context.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
	IStructuredSelection selection = (IStructuredSelection) HandlerUtil
		.getCurrentSelection(event);
	Object o = selection.getFirstElement();
	if (o instanceof IFile) {
	    IFile file = (IFile) o;
	    ResourceSet rSet = new ResourceSetImpl();
	    URI uri = URI.createPlatformResourceURI(file.getFullPath()
		    .toString(), true);
	    Resource res = rSet.createResource(uri);
	    try {
		res.load(null);
	    } catch (IOException e) {
		throw new ExecutionException("", e);
	    }
	    InputElement iElement = (InputElement) res.getContents().get(0);
	    Grammar grammatics = iElement.getGrammatics();
	    String gramma = "La gramatica "
		    + (grammatics.isBuiltin() ? "es built-in, " : "es ")
		    + "de modo " + grammatics.getMode() + ", y su fuente es "
		    + grammatics.getSrc();
	    String prompts = "Tiene "
		    + iElement.getAudios().getNoMatch().getAudio().size()
		    + " configuraciones de nomatch y "
		    + iElement.getAudios().getNoInput().getAudio().size()
		    + " de noinput";
	    IWorkbenchWindow window = HandlerUtil
		    .getActiveWorkbenchWindowChecked(event);
	    MessageDialog.openInformation(window.getShell(), "Info", gramma);
	    MessageDialog.openInformation(window.getShell(), "Info", prompts);
	}
	return null;
    }
}
