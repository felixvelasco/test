package com.vectorsf.jvoice.core.operation.helper

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.jdt.core.IPackageFragment
import org.eclipse.jdt.core.JavaModelException

class PrototypeCreator {

	def static createBean(String packageName, String name) '''
		package «packageName»;
		
		import java.io.Serializable;
		
		import org.springframework.context.annotation.Scope;
		import org.springframework.stereotype.Component;
		
		@Component
		@Scope("prototype")
		public class «name» implements Serializable {
		
			private static final long serialVersionUID = 1L;
		
			// Add your methods here
		}
	'''

	def static createMethod(String methodName, String returnType) '''
		public «returnType» «methodName»() {
			return definitionsService.create«returnType»();
		}
	'''
	def static createInjectedField(String fieldName, String fileType) '''
		@Autowired
		private «fileType» «fieldName»;
	'''

	def static createBeanFor(String name, IPackageFragment packageFragment, IProgressMonitor monitor) throws JavaModelException {
		var contents = createBean(packageFragment.getElementName(), name).toString();
		packageFragment.createCompilationUnit(name + ".java", contents, true, monitor);
	}
}
