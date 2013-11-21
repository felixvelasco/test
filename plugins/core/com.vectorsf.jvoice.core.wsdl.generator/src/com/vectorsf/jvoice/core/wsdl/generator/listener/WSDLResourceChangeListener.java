package com.vectorsf.jvoice.core.wsdl.generator.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;


public class WSDLResourceChangeListener implements IResourceChangeListener {

	private static final String POM_XML = "/pom.xml";

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
		
        //sólo nos interesan los cambios POST_CHANGE
        if (event.getType() != IResourceChangeEvent.POST_CHANGE)
           return;
        IResourceDelta rootDelta = event.getDelta();
        // si no existe el delta no hacemos nada
        if (rootDelta == null) {
			return;
		}
        
        final List<IResource> changed = new ArrayList<IResource>();
        IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
           public boolean visit(IResourceDelta delta) {
              //sólo nos interesan nuevos ficheros o cambios sobre ficheros existentes
              if (!(delta.getKind() == IResourceDelta.CHANGED || delta.getKind() == IResourceDelta.ADDED))
                 return true;
              IResource resource = delta.getResource();
              //sólo nos interesan ficheros con extensión "wsdl"
              if (resource.getType() == IResource.FILE && 
				"wsdl".equalsIgnoreCase(resource.getFileExtension())) {
                 changed.add(resource);
              }
              return true;
           }
        };
        try {
        	rootDelta.accept(visitor);
        } catch (CoreException e) {
        }
        //si no hay cambios no se hace nada más
        if (changed.size() == 0)
        {
          return;
        }
        else
        {
        	IProject iproject = changed.get(0).getProject();
			modifyPom(iproject);			     	
        }
	}

	private void modifyPom(final IProject iproject) {
		try {
			MavenXpp3Reader reader = new MavenXpp3Reader();
			Model mm = null;
			File pomFile = new File(iproject.getLocationURI().getPath(),POM_XML);
			
			// MODIFICARRRRRRRRRRRR
			// Se debe meter en esta variable la ruta del wsdl para que solamente toque el pom la primera vez, 
			// ya que en este listener se mete 2 veces al tocar o copiar un WSDL.
			CharSequence sWsdl_path= "src/main/wsdl/myservice.wsdl";
			if (!pomContainsLine(pomFile,sWsdl_path))
			{
				mm = reader.read(new FileInputStream(pomFile));
				
				addBuildToModel(mm);
				
				MavenXpp3Writer writer = new MavenXpp3Writer();
				writer.write(new FileOutputStream(pomFile), mm);
			}
		} catch (IOException
				| XmlPullParserException e) {
			e.printStackTrace();
		}
	}

	private void addBuildToModel(Model mm) {

		// MODIFICARRRRRRRRRRRR
		// Descomentar y rellenar cuando tengamos la configuración del plugin maven
		
//		Plugin dsl_builder = new Plugin();
//		dsl_builder.setGroupId("doble");
//		dsl_builder.setArtifactId("mandoble");
//		dsl_builder.setVersion("0.0.1-SNAPSHOT");
//		PluginExecution voiceDSL = new PluginExecution();
//		voiceDSL.setPhase("compile");
//		voiceDSL.addGoal("doce");
//		dsl_builder.addExecution(voiceDSL);
//		mm.getBuild().addPlugin(dsl_builder);
	}

	private boolean pomContainsLine(File pomFile, CharSequence in_line) throws FileNotFoundException 
	{
		Scanner fileScanner = new Scanner(pomFile); 
		boolean bExits =false;
		while(fileScanner.hasNextLine() && !bExits)
		{  
			String line = fileScanner.nextLine(); 
			if (line.contains(in_line))
			{
				bExits = true;	
			}  
		}
		fileScanner.close();
		return bExits;
	}        
}
