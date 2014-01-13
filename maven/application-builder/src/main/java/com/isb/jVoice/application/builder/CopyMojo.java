package com.isb.jVoice.application.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

/**
 * Goal which touches a timestamp file.
 * 
 * @goal copyXML
 * 
 * @phase process-resources
 * @requiresDependencyResolution compile+runtime
 */
public class CopyMojo extends AbstractMojo {

	private static final String SRC_MAIN_RESOURCES = "/src/main/resources";
	private static final String STATIC = "static/";
	private static final String WAV_EXT = ".wav";
	private static final String XML_EXT = ".xml";
	private static final String JAR_EXT = ".jar";
	private static final String GRXML_EXT = ".grxml";
	private static final String PROJECT_INFORMATION = "projectInformation";
	private static final String PROJECT_INFORMATION_EXT = ".projectInformation";
	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String JVOICES = "jVoice";
	private static final String DESTINO = "flows";
	private static final String APPSERVLET = "spring/appServlet";
	private static final String FLOW = "-flow";
	private static final String AUDIOS = "audios";
	private static final String GRAMMARS = "grammars";
	private static final String DESTINOWAV = "resources";
	private static final String WAV = "wav";
	private static final String XML = "xml";
	private static final String GRXML = "grxml";
	private static final String ARCHIVE_FILE = "archive:file:/";
	private static final String SEPARATOR2 = "\\";
	private static final String LOGGER_CONFIG_DIR = "/com/vectorsf/jvoiceframework/config/logger";
	private static final String WEBAPP_RESOURCES = "/src/main/webapp/resources";

	/**
	 * Location of the target directory.
	 * 
	 * @parameter expression="${basedir}/src/main/webapp/WEB-INF"
	 */
	private File outputDirectory;

	/**
	 * The Maven Project Object
	 * 
	 * @parameter expression="${project}"
	 * @required
	 */
	protected MavenProject mavenProject;

	/**
	 * @parameter expression="${project.runtimeClasspathElements}"
	 */
	private List<String> runtimeClasspathElements;

	private List<JVModule> modules = new ArrayList<JVModule>();
	String nameProject = null;
	private ClassLoader runtimeClassLoader;

	private URL[] buildURLs() {
		List<URL> urls = new ArrayList<URL>(runtimeClasspathElements.size());
		for (String element : runtimeClasspathElements) {

			try {
				urls.add(new File(element).toURI().toURL());
			} catch (MalformedURLException e) {
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
		
		runtimeClassLoader = createClassLoaderForProjectDependencies();

		try {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					PROJECT_INFORMATION, new XMIResourceFactoryImpl());
			EPackage.Registry.INSTANCE.put(BasePackage.eNS_URI,
					BasePackage.eINSTANCE);
			EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI,
					OperationsPackage.eINSTANCE);

			JVApplication application = getProjectInformation();
			File flows = new File(outputDirectory, DESTINO);
			flows.mkdirs();
			generateMainModule(application, flows);

			// copia los ficheros .wav y .xml, además recopila las propiedades
			// de los módulos de los que depende, preferencia de las propiedades
			// de los módulos por orden alfabetico del los nombres de los
			// módulos.
			searchInJarFiles();

			// Creamos la carpeta estatica spring/appServlet
			File appServlet = new File(outputDirectory, APPSERVLET);
			appServlet.mkdirs();
			// Generamos el XML servlet-context.xml de la carpeta spring
			XMLGeneratorServlet.generate(new File(appServlet,
					"servlet-context.xml"));

			// Creamos el app-context.xml en dentro de la carpeta WEB-INF
			File spring = new File(outputDirectory, "spring");
			XMLGeneratorAPP.generate(new File(spring, "app-context.xml"),
					modules);
			XMLGeneratorJFC.generate(new File(spring,
					"jvoiceframework-context.xml"), application.getName(), application.isLegacyLogger());
			XMLGeneratorRC.generate(new File(spring, "root-context.xml"));

			// Creamos el web.xml en dentro de la carpeta WEB-INF
			XMLGeneratorWeb.generate(new File(outputDirectory, "web.xml"));

			// Creamos la carpeta estatica views
			File views = new File(outputDirectory, "views");
			views.mkdirs();
			XMLGeneratorRHTML.generate(new File(views, "renderHTML.jsp"));
			XMLGeneratorRVXI.generate(new File(views, "renderVXI.jsp"));
			copyFile("views/_init.jsp", new File(views, "_init.jsp"));

			//Creamos la carpeta src/main/resources/com/vectorsf/jvoiceframework/config/logger
			File configLogger = new File (mavenProject.getBasedir().getAbsolutePath() + SRC_MAIN_RESOURCES + LOGGER_CONFIG_DIR);
			configLogger.mkdirs();
			
			// Generamos el archivo "padre" de configuración del logger
			// (logback.xml) en la carpeta src/main/resources
			XMLGeneratorLogback.generate(new File(mavenProject.getBasedir().getAbsolutePath() + SRC_MAIN_RESOURCES,"logback.xml"), application.isLegacyLogger());
			
			// Copiamos el archivo de configuración general del logger
			// (logback-core.xml) en la carpeta
			// src/main/resources/com/vectorsf/jvoiceframework/config/logger
			copyFile("logback-core.xml", new File(configLogger,"logback-core.xml"));
			
			// Copiamos/borramos los archivos que necesita el legacy logger en
			// función de si se usa o no
			handleLegacyLoggerFiles(application.isLegacyLogger(), configLogger);
			
		} catch (IOException e) {
			throw new MojoExecutionException("Error in CopyMojo:execute()", e);
		}

	}

	private void handleLegacyLoggerFiles(boolean legacyLogger, File configLogger) throws MojoExecutionException {
		
		File isbanLoggerConfig = new File(configLogger,"isban-logger-config.xml");
		File logbackIsbanLogger =  new File(configLogger,"logback-isban-logger.xml");
		File js = new File(mavenProject.getBasedir().getAbsolutePath() + WEBAPP_RESOURCES, "js");
		File isbanLoggerJs =  new File(js, "isban-logger.js");

		if (legacyLogger) {
			//Si se usa el isban logger:
			// Copiamos los archivos de configuración necesarios en la carpeta
			// src/main/resources/com/vectorsf/jvoiceframework/config/logger
			copyFile("isban-logger-config.xml", isbanLoggerConfig);
			copyFile("logback-isban-logger.xml", logbackIsbanLogger);
			//Creamos la carpeta js dentro de src/main/webapp/resources
			js.mkdirs();
			//Copiamos el archivo isban-logger.js en ella
			copyFile("isban-logger.js",isbanLoggerJs);
		} else {
			// Si no se usa el legacy logger, si están los archivos, se borran.
			if (isbanLoggerConfig.exists()){
				isbanLoggerConfig.delete();
			}
			if (logbackIsbanLogger.exists()){
				logbackIsbanLogger.delete();
			}
			if (isbanLoggerJs.exists()){
				isbanLoggerJs.delete();
				js.delete();
			}
		}
	}

	private void searchInJarFiles() throws IOException, MojoExecutionException {

		List<File> dependencies = getProjectDependencies();
		for (File dependency : dependencies) {
			if (dependency != null
					&& dependency.toURI().toString().endsWith(JAR_EXT)) {
				List<String> extensions = Arrays.asList(new String[] { XML_EXT,
						WAV_EXT, GRXML_EXT });
				findFullPath(extensions, dependency);
			}
		}
	}


	private List<File> getProjectDependencies() throws MojoExecutionException {

		List<File> dependencies = new ArrayList<File>();
		
		for (URL resource : buildURLs()) {
			if (resource.toString().endsWith(JAR_EXT)) {
				try (ZipInputStream zip = new ZipInputStream(
						new FileInputStream(resource.getFile()));) {
					if (zip != null) {
						ZipEntry ze = null;
						while ((ze = zip.getNextEntry()) != null) {
							String entryName = ze.getName();
							if (entryName.equals(PROJECT_INFORMATION_EXT)) {
								File f;
								try {
									f = new File(resource.toURI());
								} catch (URISyntaxException e) {
									f = new File(resource.getPath());
								}
								dependencies.add(f);
								break;
							}
						}
					}
				} catch (FileNotFoundException e) {
					throw new MojoExecutionException(
							"Error in CopyMojo:getProjectDependencies()", e);
				} catch (IOException e1) {
					throw new MojoExecutionException(
							"Error in CopyMojo:getProjectDependencies()", e1);
				}
			}
		}
		Collections.sort(dependencies);
		return dependencies;
	}

	private void copyFile(String origName, File destFile)
			throws MojoExecutionException {
		try (InputStream is = runtimeClassLoader.getResourceAsStream(STATIC + origName);
				FileOutputStream fos = new FileOutputStream(destFile)) {
			int read = -1;
			byte[] buf = new byte[4096];

			while ((read = is.read(buf)) != -1) {
				fos.write(buf, 0, read);
			}
		} catch (IOException e) {
			throw new MojoExecutionException("Error copying resources", e);
		}
	}

	/**
	 * Metodo que accede al projectInformation para obtener informacion de el.
	 */
	private JVApplication getProjectInformation() {
		String ruta = "file:///" + mavenProject.getBasedir().getAbsolutePath()
				+ SEPARATOR + PROJECT_INFORMATION_EXT;
		ResourceSet resSet = new ResourceSetImpl();
		URI uri = URI.createURI(ruta.replace(SEPARATOR2, SEPARATOR));
		Resource res = resSet.getResource(uri, true);
		JVApplication project = (JVApplication) res.getContents().get(0);
		return project;
	}

	private void generateMainModule(JVApplication project, File mainFolder) {
		File folder = new File(new File(mainFolder, "GlobalEventsHandlers"),
				"appGlobalTrans");
		folder.mkdirs();
		MainFlowGenerator.compile(new File(folder, "appGlobalTrans-flow.xml"),
				project);
	}

	/**
	 * @param name
	 * 
	 */
	protected void copyFile(InputStream in, String name, String type,
			String nameProject) {
		File ruta = new File(name);

		File pathname = null;
		File destino = null;
		// Se crea en rutas diferentes dependiendo de si se trata de un audio
		// type= wav o un flujo type=jVoice
		if (type.equals(JVOICES)) {
			pathname = new File(outputDirectory, DESTINO
					+ SEPARATOR
					+ name.replace(ruta.getName(), "").trim()
					+ ruta.getName().substring(0, ruta.getName().indexOf(DOT))
							.trim());
			/*
			 * Comprobamos que exista el directorio base donde vamos a crear los
			 * XML. Si no existe, se crea.
			 */
			pathname.mkdirs();

			destino = new File(pathname, ruta.getName().substring(0,
					ruta.getName().indexOf(DOT))
					+ FLOW
					+ ruta.getName().substring(ruta.getName().indexOf(DOT)));

		} else if (type.equals(WAV)) {
			pathname = new File(outputDirectory.getParentFile(), DESTINOWAV
					+ SEPARATOR + name.replace(ruta.getName(), "").trim()
					+ SEPARATOR + nameProject);
			/*
			 * Comprobamos que exista el directorio base donde vamos a crear los
			 * wav. Si no existe, se crea.
			 */
			pathname.mkdirs();

			destino = new File(pathname, ruta.getName());
		} else if (type.equals(GRXML)) {
			pathname = new File(outputDirectory.getParentFile(), DESTINOWAV + SEPARATOR
					+ name.replace(ruta.getName(), "").trim() + SEPARATOR + nameProject);
			/*
			 * Comprobamos que exista el directorio base donde vamos a crear los grxml. Si no existe, se crea.
			 */
			pathname.mkdirs();

			destino = new File(pathname, ruta.getName());
		}

		try {
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

	private void findFullPath(List<String> fileNameToSearch, File file)
			throws IOException {
		try (ZipInputStream zip = new ZipInputStream(new FileInputStream(file))) {
			ZipEntry ze = null;
			String ret = null;

			while ((ze = zip.getNextEntry()) != null) {
				String entryName = ze.getName();
				if (entryName.equals(PROJECT_INFORMATION_EXT)) {
					JVModule module = getProject(entryName, file);
					modules.add(module);
					nameProject = module.getName();
				}

				int index = entryName.lastIndexOf(DOT);

				if (index != -1) {
					String entryNameDots = entryName.replace(SEPARATOR, DOT);

						/*
						 * Recorremos la lista para comprobar la extension del
						 * fichero. En el caso de que coincida, se trata de un
						 * tipo de fichero que necesitamos copiar del jar.
						 */
						for (String element : fileNameToSearch) {
							if (entryNameDots.endsWith(element)) {
								// Comprobamos si el archivo es xml o jVoices
								// para proceder a su copia. El resto no se
								// copia en la plicacion.
								if (entryNameDots.contains(JVOICES + DOT) || entryNameDots.contains(AUDIOS + DOT) || entryNameDots.contains(GRAMMARS + DOT)) {
									try (ZipFile zipFile = new ZipFile(file)) {
										InputStream inputStream = zipFile
												.getInputStream(ze);
										if (entryNameDots.endsWith(DOT + WAV)) {
											ret = entryName;
											copyFile(inputStream, ret, WAV,
													nameProject);
										} else if (entryNameDots.endsWith(DOT + GRXML)) {
											ret = entryName;
											copyFile(inputStream, ret, GRXML, nameProject);
										} else if (entryNameDots.endsWith(DOT
												+ XML)) {
											ret = entryName.substring(entryName
													.indexOf(SEPARATOR) + 1,
													entryName.length());
											copyFile(inputStream, ret, JVOICES,
													null);
										}

									}
								}
								break;
						}

					}
				}
			}
		}

	}


	/**
	 * @param entryName
	 */
	protected JVModule getProject(String entryName, File file) {

		String ruta = ARCHIVE_FILE
				+ file.getAbsolutePath().replace(SEPARATOR2, SEPARATOR) + "!/"
				+ entryName;
		ResourceSet resSet = new ResourceSetImpl();
		URI uri = URI.createURI(ruta);

		Resource res = resSet.getResource(uri, true);
		return (JVModule) res.getContents().get(0);

	}

}
