package com.isb.jVoice.dsl.builder;

import java.io.File;
import java.io.IOException;
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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.State;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal voiceDSL
 * 
 * @phase generate-sources
 */
public class MyMojo extends AbstractMojo {
	/**
	 * Location of the target directory.
	 * 
	 * @parameter expression="${project.build.directory}/generated-sources/jVoice"
	 * @required
	 */
	private File outputDirectory;

	/**
	 * Location of the source directory.
	 * 
	 * @parameter expression="${basedir}/src/main/resources/jv"
	 * @required
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

	@Override
	public void execute() throws MojoExecutionException {

		File f = outputDirectory;
		getLog().info("ENTRA");
		if (!f.exists()) {
			f.mkdirs();
		}

		try {

			EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI, OperationsPackage.eINSTANCE);

			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("jvflow", new XMIResourceFactoryImpl());

			
			processFlowFiles();
		} catch (Exception e) {
			throw new MojoExecutionException("", e);
		}
		project.getArtifacts();
		if (project != null) {
			projectHelper.addResource(project, sourceDirectory.getAbsolutePath(),
					Collections.singletonList("**/**.jvflow"), Collections.emptyList());
			// project.addCompileSourceRoot(outputDirectory.getAbsolutePath());

		}
	}


	private String getTargetDSLName(String name) {
		String basename = name.substring(0, name.lastIndexOf('.'));

		return basename + ".jsp";
	}

	private String getTargetFlowName(String name) {
		String basename = name.substring(0, name.lastIndexOf('.'));

		return basename + ".xml";
	}

	private Set<String> getDSLIncludesPatterns() {
		if (includes == null || includes.isEmpty()) {
			return Collections.singleton("**/*.voiceDsl");
		}
		return includes;
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

	private void processFlowFiles() throws InclusionScanException, IOException {
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
				built |= processFlowFile(flow);
			}
			if (!built && getLog().isInfoEnabled()) {
				getLog().info("No DSL processed; generated files are up to date");
			}
		}

	}

	private boolean processFlowFile(File flowFile) throws IOException {
		File targetFile = new File(outputDirectory, getTargetFlowName(flowFile.getName()));
		if (buildRequired(flowFile, Collections.singletonList(targetFile))) {
			targetFile.createNewFile();

			// resolve test
			ResourceSet rSet = new ResourceSetImpl();
			VegaXMLURIHandlerMavenImpl vegaURIHandler = new VegaXMLURIHandlerMavenImpl(project);
			rSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
			URI uri = URI.createFileURI(flowFile.getCanonicalPath().toString());
			Resource res = rSet.getResource(uri, true);

			Flow flow = (Flow) res.getContents().get(0);

			for (State state : flow.getStates()) {

			}
			// deresolve test
			URI uri2 = URI.createFileURI("C:/Users/xIS02462/git/test/maven/test/testMavenResolveDeresolveProject/src/main/resources/jv/qwe.jvflow");

			ResourceSet rSet2 = new ResourceSetImpl();
			rSet2.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
			Resource res2 = rSet2.getResource(uri2, true);

			if (res2 instanceof XMLResource) {

				((XMLResource) res2).getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
			}

			try {
				res2.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return true;
		} else {
			return false;
		}
	}

}
