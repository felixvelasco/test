package com.isb.jVoice.application.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
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
import com.vectorsf.jvoice.model.base.JVModule;


/**
 * Goal which touches a timestamp file.
 * 
 * @goal copyXML
 * 
 * @phase process-resources
 * 
 * @requiresDependencyResolution compile+runtime
 */
public class CopyMojo extends AbstractMojo {

	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String JVOICES = "jVoice";
	private static final String DESTINO = "flows";
	private static final String APPSERVLET = "spring/appServlet";
	private static final String FLOW = "-flow";
	private static final String AUDIOS = "audios";
	private static final String DESTINOWAV ="resources";
	private static final String WAV = "wav";
	private static final String XML = "xml";
	private File file;
	private static final String ARCHIVE_FILE=  "archive:file:/";
	private static final String SEPARATOR2 = "\\";

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
	protected MavenProject project;

	/**
	 * @parameter expression="${project.runtimeClasspathElements}"
	 */
	private List<String> runtimeClasspathElements;
	private List<JVModule> modules;

	private void findFullPath(List<String> fileNameToSearch, File file) throws IOException {
		ZipInputStream zip = new ZipInputStream(new FileInputStream(file));
		ZipEntry ze = null;
		String ret = null;
		String nameProject = null;
		while ((ze = zip.getNextEntry()) != null) {
			String entryName = ze.getName();
			if(entryName.equals(".projectInformation")){
				JVModule module = getProject(entryName, file);
				modules.add(module);
				nameProject = module.getName();
			}
			
			int index = entryName.lastIndexOf(DOT);
			
			if (index != -1) {
				String entryNameDots = entryName.replace(SEPARATOR, DOT);
				/*Creamos un boolean inicializado a false y Recorremos la lista para comprobar la terminacion del fichero.
				  En el caso de que coincida la terminacion, el booleano se pondra a true, indicando que es un tipo de fichero
				  que necesitamos copiar del jar.
				*/
				boolean terminacion = false;
				for (String element : fileNameToSearch) {
					if(entryNameDots.endsWith(element)){
						terminacion= true;
						break;
					}					
				}							
				// Comprobamos si el archivo es xml o jVoices para proceder a su copia. El resto no se copia en la aplicacion.
				if (terminacion && (entryNameDots.contains(JVOICES + DOT) || entryNameDots.contains(AUDIOS + DOT))) {
					ZipFile zipFile = new ZipFile(file);
					InputStream inputStream = zipFile.getInputStream(ze);
					if(entryNameDots.endsWith(DOT+WAV)){
						ret = entryName;
						copyFile(inputStream, ret, WAV, nameProject );
					}else if (entryNameDots.endsWith(DOT+XML)){
						ret = entryName.substring(entryName.indexOf(SEPARATOR) + 1, entryName.length());
						copyFile(inputStream, ret, JVOICES, null);
					}

					zipFile.close();
				}
			}
		}
		zip.close();
	}

	@Override
	public void execute() throws MojoExecutionException {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("projectInformation", new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(BasePackage.eNS_URI, BasePackage.eINSTANCE);
		
		for (String element : runtimeClasspathElements) {

			if (new File(element).toURI().toString().endsWith(".jar")) {
				file = new File(element);
				List<String> extensions = Arrays.asList(new String[]{".xml", ".wav"});
				try {
					findFullPath(extensions, file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		// Creamos la carpeta estatica spring/appServlet
		File appServlet = new File(outputDirectory, APPSERVLET);
		getDir(appServlet);
		// Generamos el XML servlet-context.xml de la carpeta spring
		generateFile(appServlet, "servlet-context.xml");
		
		
		// Creamos el app-context.xml en dentro de la carpeta WEB-INF
		File spring = new File(outputDirectory, "spring");
		generateFile(spring, "app-context.xml");
		generateFile(spring, "jvoiceframework-context.xml");
		generateFile(spring, "root-context.xml");

		// Creamos el web.xml en dentro de la carpeta WEB-INF
		generateFile(outputDirectory, "web.xml");
		
		// Creamos la carpeta estatica views
		File views = new File(outputDirectory, "views");
		getDir(views);
		generateFile(views, "renderHTML.jsp");
		generateFile(views, "renderVXI.jsp");
		
	}

	/**
	 * @param appServlet
	 * @param name
	 */
	protected void generateFile(File ruta, String inFileName) {
		File targetFile = new File(ruta, inFileName);
		if (!targetFile.exists()) {
			try {
				targetFile.createNewFile();
				if (inFileName.equals("web.xml")) {
					XMLGeneratorWeb.generate(targetFile);
				} else if (inFileName.equals("servlet-context.xml")) {
					XMLGeneratorServlet.generate(targetFile);
				} else if (inFileName.equals("app-context.xml")){
					XMLGeneratorAPP.generate(targetFile, modules);
				}
				else if (inFileName.equals("renderHTML.jsp"))
				{
					XMLGeneratorRHTML.generate(targetFile);
				}
				else if (inFileName.equals("renderVXI.jsp"))
				{
					XMLGeneratorRVXI.generate(targetFile);
				}
				else if (inFileName.equals("jvoiceframework-context.xml"))
				{
					XMLGeneratorJFC.generate(targetFile);
				}
				else if (inFileName.equals("root-context.xml"))
				{
					XMLGeneratorRC.generate(targetFile);
				}

			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param pathname
	 * 
	 */
	protected void getDir(File path) {
		if (!path.exists()) {
			path.mkdirs();
		}
	}

	/**
	 * @param name
	 * 
	 */
	protected void copyFile(InputStream in, String name, String type, String nameProject) {
		File ruta = new File(name);
				
		File pathname = null;
		File destino = null;
		//Se crea en rutas diferentes dependiendo de si se trata de un audio type= wav o un flujo type=jVoice
		if(type.equals(JVOICES)){			
			pathname = new File(outputDirectory, DESTINO + SEPARATOR + name.replace(ruta.getName(), "").trim() + 
					 ruta.getName().substring(0,ruta.getName().indexOf(DOT)).trim());
			/*
			 * Comprobamos que exista el directorio base donde vamos a crear los XML. Si no existe, se crea.
			 */
			getDir(pathname);

			destino = new File(pathname, ruta.getName().substring(0, ruta.getName().indexOf(DOT)) + FLOW + ruta.getName().substring(ruta.getName().indexOf(DOT)));
			
		}else if(type.equals(WAV)){
			pathname = new File(outputDirectory.getParentFile(), DESTINOWAV + SEPARATOR + name.replace(ruta.getName(), "").trim()+SEPARATOR+ nameProject);
			/*
			 * Comprobamos que exista el directorio base donde vamos a crear los wav. Si no existe, se crea.
			 */
			getDir(pathname);

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
	

	/**
	 * @param entryName
	 */
	protected JVModule getProject(String entryName, File file) {		
		
		String ruta = ARCHIVE_FILE+file.getAbsolutePath()
				.replace(SEPARATOR2, SEPARATOR)+ "!/"
				+ entryName;
		ResourceSet resSet = new ResourceSetImpl();
		URI uri=URI.createURI(ruta);
		
		
		Resource res = resSet.getResource(uri, true);
		return ((JVModule)res.getContents().get(0));
		
	}
	
}
