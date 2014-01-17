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
		try (ZipInputStream inputStream = new ZipInputStream(
				new FileInputStream(resourcePath.toString()))) {
			// Sets module name
			String[] jarName = resourcePath.lastSegment().split("-");
			String projectName = jarName[0];
			module.setName(projectName);
			// Sets packages and flows names
			while (inputStream.available() == 1) {
				ZipEntry entry = inputStream.getNextEntry();
				if (entry != null && (!entry.isDirectory()
						&& (entry.getName().endsWith(".jvflow") || entry.getName().endsWith(".voiceDsl"))
						&& entry.getName().contains("/"))) {

					String[] segments = entry.getName().split("/");
					if (segments.length > 2) {
						JVPackage pack = BaseFactory.eINSTANCE.createJVPackage();
						pack.setName(getPackageName(segments));

						URI uri = URI.createURI("archive:file:/"
								+ resourcePath.toString() + "!/"
								+ entry.getName());

						JVBean flow = JVoiceModelReconcilier.getInstance()
								.createBean(
										uri,
										BaseModel.getInstance()
												.getResourceSet());
						if (flow != null) {
							flow.setName(getFlowName(segments));
							if (module.getPackage(getPackageName(segments)) == null) {
								pack.getBeans().add(flow);
								module.getPackages().add(pack);
							} else {
								if (module.getPackage(getPackageName(segments))
										.getBean(getFlowName(segments)) == null) {
									module.getPackage(getPackageName(segments))
											.getBeans().add(flow);
								}
							}

						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return module;
	}

	private String getFlowName(String[] segments) {
		String[] flowNameSegments = segments[segments.length - 1].split("\\.");
		return flowNameSegments[0];
	}

	protected String getPackageName(String[] segments) {
		String packName = segments[1];
		if (segments.length > 3) {
			packName = packName + ".";
			for (int i = 2; i < segments.length - 2; i++) {
				packName = packName + segments[i] + ".";
			}
			packName = packName + segments[segments.length - 2];
		}
		return packName;

	}
}
