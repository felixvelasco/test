package com.vectorsf.jvoice.core.reconciliator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.model.service.JVModelCreateProject;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;

public class MavenProjectCreator implements JVModelCreateProject {
	@Override
	public JVModule createProject(IPath resourcePath) {
		JVModule module = BaseFactory.eINSTANCE.createJVModule();
		try {
			ZipInputStream inputStream = new ZipInputStream(new FileInputStream(resourcePath.toString()));
			String[] jarName = resourcePath.lastSegment().split("-");
			String projectName = jarName[0];
			module.setName(projectName);
			while (inputStream.available() == 1) {
				ZipEntry entry = inputStream.getNextEntry();
				if (entry != null) {
					if (!entry.isDirectory()
							&& (entry.getName().endsWith(".jvflow") || entry.getName().endsWith(".voiceDsl"))
							&& entry.getName().contains("/")) {
						String[] segments = entry.getName().split("/");
						if (segments.length > 2) {
							String[] flowNameSegments = segments[2].split("\\.");
							String flowName = flowNameSegments[0];
							String packName = segments[1];
							if (segments.length > 2) {
								JVPackage pack = BaseFactory.eINSTANCE.createJVPackage();
								pack.setName(packName);
								String pathPrueba = resourcePath + "!/" + packName + "/" + segments[2];
								URI uri = URI.createURI("archive:file:/" + resourcePath.toString() + "!/"
										+ entry.getName());

								JVBean flow = JVoiceModelReconcilier.getInstance().createBean(uri,
										BaseModel.getInstance().getResourceSet());
								if (flow != null) {
									flow.setName(flowName);
									if (module.getPackage(packName) == null) {
										pack.getBeans().add(flow);
										module.getPackages().add(pack);
									} else {
										if (module.getPackage(packName).getBean(flowName) == null) {
											module.getPackage(packName).getBeans().add(flow);
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
