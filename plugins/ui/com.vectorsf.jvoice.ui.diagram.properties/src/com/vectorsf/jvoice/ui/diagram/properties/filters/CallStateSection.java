package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ParameterizedState;

public class CallStateSection extends ParametrizableStateSection {

	public CallStateSection() {
	}

	@Override
	protected String[] getParameterNames(ParameterizedState state) {
		CallState callState = (CallState) state;
		String[] parameterNames = {};
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.findMember(EcoreUtil.getURI(callState).toPlatformString(true)).getProject();
			IJavaProject jProject = JavaCore.create(project);

			IType type = jProject.findType(callState.getBean().getFqdn());

			IMethod[] methods = type.getMethods();
			for (IMethod method : methods) {
				if (method.getElementName().equals(callState.getMethodName())) {
					parameterNames = method.getParameterNames();
				}

			}

		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return parameterNames;
	}
}
