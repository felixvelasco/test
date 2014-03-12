package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.model.base.JVElement;

/**
 * Validator Util class
 * 
 * @author mvinuesa
 * 
 */
public class ValidatorUtils {

	/**
	 * Find project File
	 * 
	 * @param file
	 * @return
	 */
	public static File findProjectFile(File file) {
		if (file == null) {
			return null;
		}
		if (new File(file, "src/main/resources").exists()) {
			return file;
		}
		return findProjectFile(file.getParentFile());
	}

	/**
	 * @param element
	 * @return
	 */
	public static File getFile(JVElement element) {
		URI uri = element.eResource().getURI();

		File rawFile = null;
		if (uri.isPlatformResource()) {
			IPath rawPath = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true))
					.getRawLocation();

			rawFile = rawPath.toFile();
		} else if (uri.isFile()) {
			rawFile = new File(uri.toFileString());
		}
		return rawFile;
	}
}
