package com.vectorsf.jvoice.core.reconciliator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.base.model.service.JVModelCreateProject;
import com.vectorsf.jvoice.core.factory.JVBeanFactory;
import com.vectorsf.jvoice.core.factory.JVBeanFactoryManager;
import com.vectorsf.jvoice.core.project.JVoiceApplicationNature;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVElement;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

public class MavenProjectCreator implements JVModelCreateProject
{
	public JVModule createProject(IPath resourcePath) {
		JVModule module = BaseFactory.eINSTANCE.createJVModule();
		try {
			ZipInputStream inputStream =  new ZipInputStream(new FileInputStream(resourcePath.toString()));
			String[] jarName = resourcePath.lastSegment().split("-");
			String projectName = jarName[0];
			module.setName(projectName);
			while ( inputStream.available()==1){
				ZipEntry entry = inputStream.getNextEntry();
				if(entry!=null){
					if (!entry.isDirectory() && (entry.getName().endsWith(".jvflow")||entry.getName().endsWith(".voiceDsl") )
							&& entry.getName().contains("/")){					
						String[] segments = entry.getName().split("/");
						if (segments.length>2){
						String[] flowNameSegments = segments[2].split("\\.");
						String flowName = flowNameSegments[0];
						String packName = segments[1];
						if(segments.length>2){
							JVPackage pack = BaseFactory.eINSTANCE.createJVPackage();
							pack.setName(packName);
							String pathPrueba = resourcePath+"!/"+packName+"/"+segments[2];
							URI uri = URI.createURI("archive:file:/"
										+ resourcePath.toString()
												+"!/"
										+ entry.getName());
							
							JVBean flow = JVoiceModelReconcilier.getInstance().createBean(uri);
							if (flow!=null)
							{
								flow.setName(flowName);
								if (module.getPackage(packName)==null){
									pack.getBeans().add((JVBean) flow);
									module.getPackages().add(pack);
								}else{
									if (module.getPackage(packName).getBean(flowName)==null){
										module.getPackage(packName).getBeans().add((JVBean) flow);
									}
								}
							}
						}
						}
					}
				}

			}
			
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return module;
	}
}
