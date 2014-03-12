package com.vectorsf.jvoice.core.operation.helper

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.jdt.core.IPackageFragment
import org.eclipse.jdt.core.JavaModelException

class PrototypeCreator {

	def static create(String packageName, String name) '''
		package «packageName»;
		
		import java.io.Serializable;
		
		import org.springframework.stereotype.Component;
		
		@Component("prototype")
		public class «name» implements Serializable {
		
			private static final long serialVersionUID = 1L;
		
			// Add your methods here
		}
	'''

	def static createBeanFor(String name, IPackageFragment packageFragment, IProgressMonitor monitor) throws JavaModelException {
		var contents = create(packageFragment.getElementName(), name).toString();
		packageFragment.createCompilationUnit(name + ".java", contents, true, monitor);
	}
}
