package com.isb.jVoice.application.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

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

	private void findFullPath(String fileNameToSearch, File file) throws IOException {
		ZipInputStream zip = new ZipInputStream(new FileInputStream(file));
		ZipEntry ze = null;
		String ret = null;
		while ((ze = zip.getNextEntry()) != null) {
			String entryName = ze.getName();
			int index = entryName.lastIndexOf(DOT);
			if (index != -1) {
				String entryNameDots = entryName.replace(SEPARATOR, DOT);
				if (entryNameDots.endsWith(fileNameToSearch) && entryNameDots.contains(JVOICES + DOT)) {
					ret = entryName.substring(entryName.indexOf(SEPARATOR) + 1, entryName.length());
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

		for (String element : runtimeClasspathElements) {

			if (new File(element).toURI().toString().endsWith(".jar")) {
				File file = new File(element);
				try {
					findFullPath(".xml", file);
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
					XMLGeneratorAPP.generate(targetFile);
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
	protected void copyFile(InputStream in, String name) {
		File ruta = new File(name);
		File pathname = new File(outputDirectory, DESTINO + SEPARATOR + name.replace(ruta.getName(), "").trim() + 
				 ruta.getName().substring(0,ruta.getName().indexOf(DOT)).trim());
		/*
		 * Comprobamos que exista el directorio base donde vamos a crear los XMLSi no existe, se crea.
		 */
		getDir(pathname);

		File destino = new File(pathname, ruta.getName());

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

}
