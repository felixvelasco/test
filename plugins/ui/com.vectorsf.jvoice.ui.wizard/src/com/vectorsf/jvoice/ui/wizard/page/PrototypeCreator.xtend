package com.vectorsf.jvoice.ui.wizard.page

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
}