package com.isb.jVoice.application.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;


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
	
	private File f;
	private File targetFile;
	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String JVOICES = "jVoice";
	private static final String DESTINO = "/src/main/webapp/WEB-INF/flows";
	private static final String WEBINF = "/src/main/webapp/WEB-INF";
	private static final String APPSERVLET="spring/appServlet";

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

	private void findFullPath(String fileNameToSearch, File file)
			throws IOException {
		ZipInputStream zip = new ZipInputStream(new FileInputStream(file));
		ZipEntry ze = null;
		String ret = null;
		while ((ze = zip.getNextEntry()) != null) {
			String entryName = ze.getName();
			int index = entryName.lastIndexOf(DOT);
			if (index != -1) {
				String entryNameDots = entryName.replace(
						SEPARATOR, DOT);
				if (entryNameDots.endsWith(fileNameToSearch)
						&& entryNameDots.contains(JVOICES + DOT)) {
					ret = entryName.substring(entryName.indexOf(SEPARATOR)+1, entryName.length());
					ZipFile zipFile = new ZipFile(file);					
                    InputStream inputStream = zipFile.getInputStream(ze);
                    copyFile(inputStream, ret);
                    zipFile.close();
				}
			}
		}
		zip.close();
	}
	
	@Override
	public void execute() throws MojoExecutionException {
		System.out.println("hola!!!");
		
		for (String element : runtimeClasspathElements) {

				if (new File(element).toURI().toString().endsWith(".jar")) {
					File file = new File(element);
					try {
						findFullPath(".xml",file);						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
				}
		}	
		//Creamos la carpeta estatica spring/appServlet
		String appServlet = project.getBasedir()+ WEBINF+SEPARATOR+APPSERVLET;
		getDir(appServlet);
		//Generamos el XML servlet-context.xml de la carpeta spring
		generateXML(appServlet, "servlet-context");
		
		//Creamos el web.xml en dentro de la carpeta WEB-INF
		String spring = project.getBasedir()+WEBINF+SEPARATOR+"spring";
		generateXML(spring, "app-context");
		
		//Creamos el web.xml en dentro de la carpeta WEB-INF
		String webInf = project.getBasedir()+WEBINF;
		generateXML(webInf, "web");
	}

	/**
	 * @param appServlet
	 * @param name 
	 */
	protected void generateXML(String ruta, String nameXML) {
		targetFile = new File(ruta, nameXML+".xml");
		if (!targetFile.exists()){
			try {
				targetFile.createNewFile();
				if (nameXML.equals("web")) {
					XMLGeneratorWeb.generate(targetFile);
				}else if (nameXML.equals("servlet-context")) {
					XMLGeneratorServlet.generate(targetFile);
					}else {
						XMLGeneratorAPP.generate(targetFile);
					}
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}

	/**
	 * @param pathname 
	 * 
	 */
	protected void getDir(String pathname) {
		f = new File(pathname);
		if (!f.exists()) {
			f.mkdirs();
		}
	}
	
	/**
	 * @param name 
	 * 
	 */
	protected void copyFile(InputStream in, String name) {
		File ruta = new File (name);
		String pathname= project.getBasedir()+DESTINO+SEPARATOR+name.replace(ruta.getName(),"").trim();
		/*Comprobamos que exista el directorio base donde vamos a crear los XML
		 *Si no existe, se crea.
		 */
		getDir(pathname);

		File destino = new File(pathname+ruta.getName());

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
