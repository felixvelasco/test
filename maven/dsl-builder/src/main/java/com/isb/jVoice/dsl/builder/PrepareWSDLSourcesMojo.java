package com.isb.jVoice.dsl.builder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.xml.Xpp3Dom;

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
	@SuppressWarnings("unused")
	private File outputDirectory;

	/**
	 * Location of the source directory.
	 * 
	 * @parameter expression="${basedir}/src/main/resources/jv"
	 */
	private File sourceDirectory;

	/**
	 * A set of patterns matching files from the sourceDirectory that should be
	 * processed as grammars.
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
	@SuppressWarnings("unused")
	private MavenProjectHelper projectHelper;

	/**
	 * @parameter expression="${project.runtimeClasspathElements}"
	 */

	@Override
	public void execute() throws MojoExecutionException {

		File wsdl = new File(sourceDirectory.getParentFile(), "wsdl");
		File[] files = wsdl.listFiles();
		Xpp3Dom dom = null;
		List<String> locations = new ArrayList<String>();

		if (files.length > 0) {
			File metaInf = new File(sourceDirectory.getParentFile(), "META-INF");
			generateDir(metaInf);

			for (Plugin pl : project.getModel().getBuild().getPlugins()) {
				if (pl.getKey().equals("org.codehaus.mojo:jaxws-maven-plugin")) {
					dom = (Xpp3Dom)pl.getExecutions().get(0).getConfiguration();
					break;
					
				}
			}
			for (File file : files) {
				locations = rellenarWsdlLocation(file, locations, dom.getChild("wsdlLocation").getValue());
			}

			File targetFile = new File(metaInf, "jax-ws-catalog.xml");
			XMLGeneratorWSDL.generate(targetFile, locations);
		}

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
	
	private List<String> rellenarWsdlLocation (File file, List<String> locations, String ruta){
		ruta = ruta.substring(0, ruta.lastIndexOf("*"));
		ruta = ruta + file.getName().substring(0, file.getName().lastIndexOf(".")) + "/" + file.getName();
		locations.add(ruta);
		return locations;
	}
}
