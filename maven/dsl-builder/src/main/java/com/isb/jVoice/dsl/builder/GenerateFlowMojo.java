package com.isb.jVoice.dsl.builder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.compiler.util.scan.InclusionScanException;
import org.codehaus.plexus.compiler.util.scan.SimpleSourceInclusionScanner;
import org.codehaus.plexus.compiler.util.scan.SourceInclusionScanner;
import org.codehaus.plexus.compiler.util.scan.mapping.SourceMapping;
import org.codehaus.plexus.compiler.util.scan.mapping.SuffixMapping;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.graphiti.mm.algorithms.AlgorithmsPackage;
import org.eclipse.graphiti.mm.algorithms.styles.StylesPackage;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;
import com.isb.bks.ivr.voice.dsl.VoiceDslStandaloneSetup;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal generateFlow
 * 
 * @phase generate-sources
 * 
 * @configurator include-project-dependencies
 * 
 * @requiresDependencyResolution compile+runtime
 */
public class GenerateFlowMojo extends AbstractMojo {
	
	private static final CharSequence SEPARATOR2 = "\\";

	private static final CharSequence SEPARATOR = "/";

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
	private List<String> runtimeClasspathElements;

	private String nameProject;

	private URL[] buildURLs() {
		List<URL> urls = new ArrayList<URL>(runtimeClasspathElements.size());
		for (String element : runtimeClasspathElements) {

			try {
				urls.add(new File(element).toURI().toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return urls.toArray(new URL[urls.size()]);
	}

	private ClassLoader createClassLoaderForProjectDependencies() {
		URL[] urls = buildURLs();
		return new URLClassLoader(urls, this.getClass().getClassLoader());
	}

	@Override
	public void execute() throws MojoExecutionException {

		File f = new File(outputDirectory,"jVoice");
		if (!f.exists()) {
			f.mkdirs();
		}
		try {

			Injector injector = new VoiceDslStandaloneSetup().createInjectorAndDoEMFRegistration();

			EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI, OperationsPackage.eINSTANCE);
			EPackage.Registry.INSTANCE.put(PictogramsPackage.eNS_URI, PictogramsPackage.eINSTANCE);
			EPackage.Registry.INSTANCE.put(AlgorithmsPackage.eNS_URI, AlgorithmsPackage.eINSTANCE);
			EPackage.Registry.INSTANCE.put(StylesPackage.eNS_URI, StylesPackage.eINSTANCE);

			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("jvflow", new XMIResourceFactoryImpl());
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("projectInformation", new XMIResourceFactoryImpl());

			ResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
			resourceSet.getLoadOptions().put(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

			VegaXMLURIHandlerMavenImpl vegaURIHandler = new VegaXMLURIHandlerMavenImpl(project,
					createClassLoaderForProjectDependencies());
			resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
			
			//Obtenemos el nombre del modulo del projectInformation
			JVModule modulo=getProjectInformation();
			nameProject = modulo.getName();

			processFlowFiles(resourceSet, f);
			if (project != null) {
				projectHelper.addResource(project, outputDirectory.getAbsolutePath(),
						Collections.singletonList("jVoice/**/*.xml"), Collections.emptyList());
				projectHelper.addResource(project, project.getBasedir().getAbsolutePath(),
						Collections.singletonList(".projectInformation"), Collections.emptyList());
			}

		} catch (Exception e) {
			throw new MojoExecutionException("", e);
		}

	}

	/**
	 * Metodo que accede al projectInformation para obtener informacion de el.
	 */
	private JVModule getProjectInformation() {		
		String ruta = "file:///"+ project.getBasedir().getAbsolutePath()+SEPARATOR+".projectInformation";
		ResourceSet resSet = new ResourceSetImpl();
		URI uri=URI.createURI(ruta.replace(SEPARATOR2, SEPARATOR));
		Resource res = resSet.getResource(uri, true);
		JVModule module= (JVModule)res.getContents().get(0);
		return module;
	}

	private String getTargetFlowName(String name) {
		String basename = name.substring(0, name.lastIndexOf('.'));

		return basename + ".xml";
	}

	private Set<String> getFlowIncludesPatterns() {
		if (includes == null || includes.isEmpty()) {
			return Collections.singleton("**/*.jvflow");
		}
		return includes;
	}

	/**
	 * Checks to see if the list of outputFiles all exist, and have last-modified timestamps which are later than the
	 * last-modified timestamp of the grammar file. If these conditions hold, the method returns false, otherwise, it
	 * returns true.
	 * 
	 * @param sourceFile
	 * @param outputFiles
	 * @return
	 */
	private static boolean buildRequired(File sourceFile, List<File> outputFiles) {

		long sourceLastModified = sourceFile.lastModified();

		for (File outputFile : outputFiles) {
			if (!outputFile.exists() || sourceLastModified > outputFile.lastModified()) {
				return true;
			}
		}
		return false;
	}

	private void processFlowFiles(ResourceSet resourceSet, File folder) throws InclusionScanException, IOException {
		SourceMapping mapping = new SuffixMapping("jvflow", Collections.<String> emptySet());
		Set<String> includes = getFlowIncludesPatterns();
		SourceInclusionScanner scan = new SimpleSourceInclusionScanner(includes, excludes);

		scan.addSourceMapping(mapping);
		Set<File> flowFiles = scan.getIncludedSources(sourceDirectory, null);
		if (flowFiles.isEmpty()) {
			if (getLog().isInfoEnabled()) {
				getLog().info("No Flows to process");
			}
		} else {
			boolean built = false;
			for (File flow : flowFiles) {
				built |= processFlowFile(resourceSet, flow, folder);
			}
			if (!built && getLog().isInfoEnabled()) {
				getLog().info("No DSL processed; generated files are up to date");
			}
		}

	}

	private boolean processFlowFile(ResourceSet resourceSet, File origFile, File targetFolder) throws IOException {
		//Obtenemos los paquetes en los que se encuentra el archivo.
		String rutafile = origFile.getAbsolutePath().toString().replace(sourceDirectory.toString(),"").trim();
		//Copiamos la estrucutra de paquetes.		
		targetFolder = new File(targetFolder,rutafile.replace(origFile.getName(), "").trim());
		if (!targetFolder.exists()) {
			targetFolder.mkdirs();
		}
		
		File targetFile = new File(targetFolder, getTargetFlowName(origFile.getName()));
		
		if (buildRequired(origFile, Collections.singletonList(targetFile))) {
			targetFile.createNewFile();

			// resolve test
			URI uri = URI.createFileURI(origFile.getCanonicalPath().toString());
			Resource res = resourceSet.getResource(uri, true);
			Resource diagrama = res.getContents().get(0).eResource();
			SpringWebFlowGenerator.compile(targetFile, diagrama,nameProject);

			return true;
		} else {
			return false;
		}
	}

}
