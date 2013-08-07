/**
 */
package xbase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;

import xbase.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XbaseFactoryImpl extends EFactoryImpl implements XbaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XbaseFactory init() {
		try {
			XbaseFactory theXbaseFactory = (XbaseFactory)EPackage.Registry.INSTANCE.getEFactory(XbasePackage.eNS_URI);
			if (theXbaseFactory != null) {
				return theXbaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XbaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XbasePackage.XIF_EXPRESSION: return createXIfExpression();
			case XbasePackage.XSWITCH_EXPRESSION: return createXSwitchExpression();
			case XbasePackage.XCASE_PART: return createXCasePart();
			case XbasePackage.XBLOCK_EXPRESSION: return createXBlockExpression();
			case XbasePackage.XVARIABLE_DECLARATION: return createXVariableDeclaration();
			case XbasePackage.XMEMBER_FEATURE_CALL: return createXMemberFeatureCall();
			case XbasePackage.XFEATURE_CALL: return createXFeatureCall();
			case XbasePackage.XCONSTRUCTOR_CALL: return createXConstructorCall();
			case XbasePackage.XBOOLEAN_LITERAL: return createXBooleanLiteral();
			case XbasePackage.XNULL_LITERAL: return createXNullLiteral();
			case XbasePackage.XNUMBER_LITERAL: return createXNumberLiteral();
			case XbasePackage.XSTRING_LITERAL: return createXStringLiteral();
			case XbasePackage.XLIST_LITERAL: return createXListLiteral();
			case XbasePackage.XSET_LITERAL: return createXSetLiteral();
			case XbasePackage.XCLOSURE: return createXClosure();
			case XbasePackage.XCASTED_EXPRESSION: return createXCastedExpression();
			case XbasePackage.XBINARY_OPERATION: return createXBinaryOperation();
			case XbasePackage.XUNARY_OPERATION: return createXUnaryOperation();
			case XbasePackage.XFOR_LOOP_EXPRESSION: return createXForLoopExpression();
			case XbasePackage.XDO_WHILE_EXPRESSION: return createXDoWhileExpression();
			case XbasePackage.XWHILE_EXPRESSION: return createXWhileExpression();
			case XbasePackage.XTYPE_LITERAL: return createXTypeLiteral();
			case XbasePackage.XINSTANCE_OF_EXPRESSION: return createXInstanceOfExpression();
			case XbasePackage.XTHROW_EXPRESSION: return createXThrowExpression();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION: return createXTryCatchFinallyExpression();
			case XbasePackage.XCATCH_CLAUSE: return createXCatchClause();
			case XbasePackage.XASSIGNMENT: return createXAssignment();
			case XbasePackage.XRETURN_EXPRESSION: return createXReturnExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XIfExpression createXIfExpression() {
		XIfExpressionImpl xIfExpression = new XIfExpressionImpl();
		return xIfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSwitchExpression createXSwitchExpression() {
		XSwitchExpressionImpl xSwitchExpression = new XSwitchExpressionImpl();
		return xSwitchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCasePart createXCasePart() {
		XCasePartImpl xCasePart = new XCasePartImpl();
		return xCasePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBlockExpression createXBlockExpression() {
		XBlockExpressionImpl xBlockExpression = new XBlockExpressionImpl();
		return xBlockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XVariableDeclaration createXVariableDeclaration() {
		XVariableDeclarationImpl xVariableDeclaration = new XVariableDeclarationImpl();
		return xVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMemberFeatureCall createXMemberFeatureCall() {
		XMemberFeatureCallImpl xMemberFeatureCall = new XMemberFeatureCallImpl();
		return xMemberFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XFeatureCall createXFeatureCall() {
		XFeatureCallImpl xFeatureCall = new XFeatureCallImpl();
		return xFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XConstructorCall createXConstructorCall() {
		XConstructorCallImpl xConstructorCall = new XConstructorCallImpl();
		return xConstructorCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBooleanLiteral createXBooleanLiteral() {
		XBooleanLiteralImpl xBooleanLiteral = new XBooleanLiteralImpl();
		return xBooleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XNullLiteral createXNullLiteral() {
		XNullLiteralImpl xNullLiteral = new XNullLiteralImpl();
		return xNullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XNumberLiteral createXNumberLiteral() {
		XNumberLiteralImpl xNumberLiteral = new XNumberLiteralImpl();
		return xNumberLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStringLiteral createXStringLiteral() {
		XStringLiteralImpl xStringLiteral = new XStringLiteralImpl();
		return xStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XListLiteral createXListLiteral() {
		XListLiteralImpl xListLiteral = new XListLiteralImpl();
		return xListLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSetLiteral createXSetLiteral() {
		XSetLiteralImpl xSetLiteral = new XSetLiteralImpl();
		return xSetLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XClosure createXClosure() {
		XClosureImpl xClosure = new XClosureImpl();
		return xClosure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCastedExpression createXCastedExpression() {
		XCastedExpressionImpl xCastedExpression = new XCastedExpressionImpl();
		return xCastedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBinaryOperation createXBinaryOperation() {
		XBinaryOperationImpl xBinaryOperation = new XBinaryOperationImpl();
		return xBinaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XUnaryOperation createXUnaryOperation() {
		XUnaryOperationImpl xUnaryOperation = new XUnaryOperationImpl();
		return xUnaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XForLoopExpression createXForLoopExpression() {
		XForLoopExpressionImpl xForLoopExpression = new XForLoopExpressionImpl();
		return xForLoopExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XDoWhileExpression createXDoWhileExpression() {
		XDoWhileExpressionImpl xDoWhileExpression = new XDoWhileExpressionImpl();
		return xDoWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XWhileExpression createXWhileExpression() {
		XWhileExpressionImpl xWhileExpression = new XWhileExpressionImpl();
		return xWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTypeLiteral createXTypeLiteral() {
		XTypeLiteralImpl xTypeLiteral = new XTypeLiteralImpl();
		return xTypeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XInstanceOfExpression createXInstanceOfExpression() {
		XInstanceOfExpressionImpl xInstanceOfExpression = new XInstanceOfExpressionImpl();
		return xInstanceOfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XThrowExpression createXThrowExpression() {
		XThrowExpressionImpl xThrowExpression = new XThrowExpressionImpl();
		return xThrowExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTryCatchFinallyExpression createXTryCatchFinallyExpression() {
		XTryCatchFinallyExpressionImpl xTryCatchFinallyExpression = new XTryCatchFinallyExpressionImpl();
		return xTryCatchFinallyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCatchClause createXCatchClause() {
		XCatchClauseImpl xCatchClause = new XCatchClauseImpl();
		return xCatchClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAssignment createXAssignment() {
		XAssignmentImpl xAssignment = new XAssignmentImpl();
		return xAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XReturnExpression createXReturnExpression() {
		XReturnExpressionImpl xReturnExpression = new XReturnExpressionImpl();
		return xReturnExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbasePackage getXbasePackage() {
		return (XbasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XbasePackage getPackage() {
		return XbasePackage.eINSTANCE;
	}

} //XbaseFactoryImpl
