package com.vectorsf.jvoice.core.reconciliator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.vectorsf.jvoice.core.project.AbstractJVoiceNature;

public class LegacyLoggerPomHandler {
	
	public final class LegacyLoggerPomHandlerJob extends WorkspaceJob {
		
		private final MavenXpp3Reader reader;
		private final IFile pomFile;
		private final boolean legacyLogger;

		private LegacyLoggerPomHandlerJob(MavenXpp3Reader reader, IFile pomFile, boolean legacyLogger) {
			super("");
			this.reader = reader;
			this.pomFile = pomFile;
			this.legacyLogger = legacyLogger;
			setRule(pomFile);
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
			Model mm = null;
			if(pomFile.exists()){
			try {
						mm = reader.read(pomFile.getContents());
				
					//Si legacyLogger es true y no existe la dependencia, la a�adimos
					if (legacyLogger){
						addLegacyLoggerDependency(mm);
					//Si legacyLogger es false y existe la dependencia, la borramos.
					} else{
						removeLegacyLoggerDependency(mm);
					}

					MavenXpp3Writer writer = new MavenXpp3Writer();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					writer.write(baos, mm);
					pomFile.setContents(new ByteArrayInputStream(baos.toByteArray()), true, true, null);
					
			} catch (IOException | XmlPullParserException e) {
				e.printStackTrace();
			}
		}
			return Status.OK_STATUS;
		}

		private void removeLegacyLoggerDependency(Model mm) {
			List<Dependency> dependencies = mm.getDependencies();
			
			int depSize = dependencies.size();
			for (int i = 0; i < depSize; i++) {
				if ("jvoiceframework-isban-logger".equals(dependencies.get(i).getArtifactId())){
					dependencies.remove(i);
					mm.setDependencies(dependencies);
				}
			}
			
		}

		private void addLegacyLoggerDependency(Model mm) {
			List<Dependency> dependencies = mm.getDependencies();
			
			int depSize = dependencies.size();
			//Comprobamos si ya existe la dependencia del isban logger
			for (int i = 0; i < depSize; i++) {
				if ("jvoiceframework-isban-logger".equals(dependencies.get(i).getArtifactId())){
					//Ya existe la dependencia, as� que no la volvemos a a�adir
					return;
				}
			}
			
			//Si no existe ya, creamos la dependencia de jvoiceframework-isban-logger y la a�adimos
			Dependency jvIsbLogger = new Dependency();
			jvIsbLogger.setGroupId("com.vectorsf");
			jvIsbLogger.setArtifactId("jvoiceframework-isban-logger");
			jvIsbLogger.setVersion(AbstractJVoiceNature.JVOICE_FRAMEWORK_VERSION);
			dependencies.add(jvIsbLogger);
			
			mm.setDependencies(dependencies);
			
		}

	}

	private static final String POM_XML = "/pom.xml";

	protected void addLegacyLoggerDep2Pom(final IProject iproject) {
		final MavenXpp3Reader reader = new MavenXpp3Reader();

		final IFile pomFile = (IFile) iproject.findMember(POM_XML);

		//Programamos la tarea que a�ade/elimina el POM la dependencia del isban logger.
		//Como le pasamos el atributo legacyLogger a true, intentar� a�adir la dependencia al POM.
		LegacyLoggerPomHandlerJob job = new LegacyLoggerPomHandlerJob(reader, pomFile, true);
		job.schedule();
	}
	
	protected void removeLegacyLoggerDep2Pom(final IProject iproject) {
		final MavenXpp3Reader reader = new MavenXpp3Reader();

		final IFile pomFile = (IFile) iproject.findMember(POM_XML);
		
		//Programamos la tarea que a�ade/elimina el POM la dependencia del isban logger.
		//Como le pasamos el atributo legacyLogger a false, intentar� borrar la dependencia al POM.
		LegacyLoggerPomHandlerJob job = new LegacyLoggerPomHandlerJob(reader, pomFile, false);
		job.schedule();
	}



}
