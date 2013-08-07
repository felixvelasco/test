/**
 */
package xbase;

import org.eclipse.emf.ecore.EFactory;

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

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see xbase.XbasePackage
 * @generated
 */
public interface XbaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XbaseFactory eINSTANCE = xbase.impl.XbaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XIf Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XIf Expression</em>'.
	 * @generated
	 */
	XIfExpression createXIfExpression();

	/**
	 * Returns a new object of class '<em>XSwitch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSwitch Expression</em>'.
	 * @generated
	 */
	XSwitchExpression createXSwitchExpression();

	/**
	 * Returns a new object of class '<em>XCase Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCase Part</em>'.
	 * @generated
	 */
	XCasePart createXCasePart();

	/**
	 * Returns a new object of class '<em>XBlock Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBlock Expression</em>'.
	 * @generated
	 */
	XBlockExpression createXBlockExpression();

	/**
	 * Returns a new object of class '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XVariable Declaration</em>'.
	 * @generated
	 */
	XVariableDeclaration createXVariableDeclaration();

	/**
	 * Returns a new object of class '<em>XMember Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMember Feature Call</em>'.
	 * @generated
	 */
	XMemberFeatureCall createXMemberFeatureCall();

	/**
	 * Returns a new object of class '<em>XFeature Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFeature Call</em>'.
	 * @generated
	 */
	XFeatureCall createXFeatureCall();

	/**
	 * Returns a new object of class '<em>XConstructor Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XConstructor Call</em>'.
	 * @generated
	 */
	XConstructorCall createXConstructorCall();

	/**
	 * Returns a new object of class '<em>XBoolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBoolean Literal</em>'.
	 * @generated
	 */
	XBooleanLiteral createXBooleanLiteral();

	/**
	 * Returns a new object of class '<em>XNull Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XNull Literal</em>'.
	 * @generated
	 */
	XNullLiteral createXNullLiteral();

	/**
	 * Returns a new object of class '<em>XNumber Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XNumber Literal</em>'.
	 * @generated
	 */
	XNumberLiteral createXNumberLiteral();

	/**
	 * Returns a new object of class '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XString Literal</em>'.
	 * @generated
	 */
	XStringLiteral createXStringLiteral();

	/**
	 * Returns a new object of class '<em>XList Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XList Literal</em>'.
	 * @generated
	 */
	XListLiteral createXListLiteral();

	/**
	 * Returns a new object of class '<em>XSet Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSet Literal</em>'.
	 * @generated
	 */
	XSetLiteral createXSetLiteral();

	/**
	 * Returns a new object of class '<em>XClosure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XClosure</em>'.
	 * @generated
	 */
	XClosure createXClosure();

	/**
	 * Returns a new object of class '<em>XCasted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCasted Expression</em>'.
	 * @generated
	 */
	XCastedExpression createXCastedExpression();

	/**
	 * Returns a new object of class '<em>XBinary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBinary Operation</em>'.
	 * @generated
	 */
	XBinaryOperation createXBinaryOperation();

	/**
	 * Returns a new object of class '<em>XUnary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XUnary Operation</em>'.
	 * @generated
	 */
	XUnaryOperation createXUnaryOperation();

	/**
	 * Returns a new object of class '<em>XFor Loop Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFor Loop Expression</em>'.
	 * @generated
	 */
	XForLoopExpression createXForLoopExpression();

	/**
	 * Returns a new object of class '<em>XDo While Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XDo While Expression</em>'.
	 * @generated
	 */
	XDoWhileExpression createXDoWhileExpression();

	/**
	 * Returns a new object of class '<em>XWhile Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XWhile Expression</em>'.
	 * @generated
	 */
	XWhileExpression createXWhileExpression();

	/**
	 * Returns a new object of class '<em>XType Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XType Literal</em>'.
	 * @generated
	 */
	XTypeLiteral createXTypeLiteral();

	/**
	 * Returns a new object of class '<em>XInstance Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XInstance Of Expression</em>'.
	 * @generated
	 */
	XInstanceOfExpression createXInstanceOfExpression();

	/**
	 * Returns a new object of class '<em>XThrow Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XThrow Expression</em>'.
	 * @generated
	 */
	XThrowExpression createXThrowExpression();

	/**
	 * Returns a new object of class '<em>XTry Catch Finally Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XTry Catch Finally Expression</em>'.
	 * @generated
	 */
	XTryCatchFinallyExpression createXTryCatchFinallyExpression();

	/**
	 * Returns a new object of class '<em>XCatch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCatch Clause</em>'.
	 * @generated
	 */
	XCatchClause createXCatchClause();

	/**
	 * Returns a new object of class '<em>XAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAssignment</em>'.
	 * @generated
	 */
	XAssignment createXAssignment();

	/**
	 * Returns a new object of class '<em>XReturn Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XReturn Expression</em>'.
	 * @generated
	 */
	XReturnExpression createXReturnExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XbasePackage getXbasePackage();

} //XbaseFactory
