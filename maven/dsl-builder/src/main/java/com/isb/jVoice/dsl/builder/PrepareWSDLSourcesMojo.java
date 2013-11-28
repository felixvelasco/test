package com.isb.jVoice.dsl.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;



/**
 * Goal which touches a timestamp file.
 * 
 * @goal prepareWSDLSources
 * 
 * @phase initialize
 * 
 * @configurator include-project-dependencies
 * 
 * @requiresDependencyResolution compile+runtime
 */
public class PrepareWSDLSourcesMojo extends AbstractMojo {


	/**
	 * Location of the target directory.
	 * 
	 * @parameter expression="${project.build.directory}"
	 */
	private File outputDirectory;

	/**
	 * Location of the source directory.
	 * 
	 * @parameter expression="${basedir}/src/main/resources/jv"
	 */
	private File sourceDirectory;

	/**
	 * A set of patterns matching files from the sourceDirectory that should be processed as grammars.
	 * 
	 * @parameter
	 */
	protected Set<String> includes = new HashSet<>();

	/**
	 * A set of exclude patterns.
	 * 
	 * @parameter
	 */
	protected Set<String> excludes = new HashSet<>();

	/**
	 * The Maven Project Object
	 * 
	 * @parameter expression="${project}"
	 * @required
	 */
	protected MavenProject project;

	/**
	 * The maven project's helper.
	 * 
	 * @component role="org.apache.maven.project.MavenProjectHelper"
	 * @required
	 * @readonly
	 */
	private MavenProjectHelper projectHelper;

	/**
	 * @parameter expression="${project.runtimeClasspathElements}"
	 */


	@Override
	public void execute() throws MojoExecutionException {

		File metaInf = new File(sourceDirectory.getParentFile(), "META-INF");
		generateDir(metaInf);
		
		//Generamos la carpeta META-INF
		File meta = new File(sourceDirectory.getParentFile()+"\\META-INF", "wsdl");
		generateDir(meta);
		
		//Copiar wsdl a META-INF
		File wsdl = new File(sourceDirectory.getParentFile(), "wsdl");
		File[] files = wsdl.listFiles();
		for (File file : files) {
			copyFile(file, meta);
		}
		
		File targetFile = new File(metaInf, "jax-ws-catalog.xml");
		XMLGeneratorWSDL.generate(targetFile, files);
		
	}

	/**
	 * @param meta2 
	 * 
	 */
	protected void generateDir(File file) {
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	//Copia la carpeta wsdl con todos los ficheros dentro del META-INF
	private void copyFile(File file, File meta) {
		try {
			File destino = new File(meta, file.getName());
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(destino);
			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
