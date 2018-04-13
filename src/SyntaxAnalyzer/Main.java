
package SyntaxAnalyzer;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Identifier idComputeFac = new Identifier("ComputeFac");
		ArrayList<ManyExpressions> intLitExp = new ArrayList<ManyExpressions>();
		intLitExp.add(new ManyExpressions(new ExpressionLiterals("10",new ExpressionDashLamda()) ,new ArrayList<AnotherExpression>()));
		ExpressionDotDashIdentifier expComputeFac = new ExpressionDotDashIdentifier(idComputeFac,intLitExp, new ExpressionDashLamda());
		ExpressionDashDotExp expDot = new ExpressionDashDotExp(expComputeFac);
		Identifier idFac = new Identifier("Fac");
		ExpressionNewDashIdentifier expNewFac = new ExpressionNewDashIdentifier(idFac,new ArrayList<ManyExpressions>(),expDot);
		ExpressionNew sysoExp = new ExpressionNew(expNewFac);
		StatementSysoExp mainStmt = new StatementSysoExp(sysoExp);
		Identifier idClassName = new Identifier("Factorial");
		Identifier idA = new Identifier("a");
		MainClass mainClass = new MainClass(idClassName,idA,mainStmt);
		
		ArrayList<ClassDeclaration> classDeclarations= new ArrayList<ClassDeclaration>();
		ArrayList<MethodDeclaration> methodDeclarations = new ArrayList<MethodDeclaration>();
		ArrayList<VarDeclaration> varDeclarations = new ArrayList<VarDeclaration>();
		TypeDataType funcType = new TypeDataType("int",new TypeDashLamda());
		Identifier num = new Identifier("num");
		Identifier num_aux = new Identifier("num_aux");
		VarDeclaration varDec = new VarDeclaration(funcType,num_aux);
		varDeclarations.add(varDec);
		TypeIdentifier typeID = new TypeIdentifier(funcType, num);
		MethodTypeIDs parameter = new MethodTypeIDs(typeID, new ArrayList<TypeIdentifier>());
		ArrayList<MethodTypeIDs> allParams = new ArrayList<MethodTypeIDs>();
		allParams.add(parameter);
		
		ArrayList<Statement> stmts = new ArrayList<Statement>();
		ExpressionLiterals expLiteral = new ExpressionLiterals("1",new ExpressionDashLamda());
		ExpressionDashOperators expOps =  new ExpressionDashOperators("<",expLiteral,new ExpressionDashLamda());
		ExpressionIdentifier expID =  new ExpressionIdentifier(num,expOps);
		StatementIdentifierDashEqExp stmtEq = new StatementIdentifierDashEqExp(expLiteral);
		StatementIdentifier stmtIfID =  new StatementIdentifier(num_aux,stmtEq);
		
		
		ArrayList<ManyExpressions> exps = new ArrayList<ManyExpressions>();
		ExpressionDashOperators expMinus = new ExpressionDashOperators("-",new ExpressionIdentifier(new Identifier("1"),new ExpressionDashLamda()),new ExpressionDashLamda());
		ExpressionIdentifier expIDMinus = new ExpressionIdentifier(num,expMinus);
		ManyExpressions myExp = new ManyExpressions(expIDMinus, new ArrayList<AnotherExpression>());
		exps.add(myExp);		
		ExpressionDotDashIdentifier expDotDashID = new ExpressionDotDashIdentifier(idComputeFac,exps,new ExpressionDashLamda());
		ExpressionDashDotExp expDashDot = new ExpressionDashDotExp(expDotDashID);
		ExpressionThis expThis = new ExpressionThis(expDashDot);
		
		ExpressionLeftBracket expLeftBracket = new ExpressionLeftBracket(expThis , new ExpressionDashLamda());
		ExpressionDashOperators expMultiplyOperator = new ExpressionDashOperators("*",expLeftBracket, new ExpressionDashLamda());
		ExpressionIdentifier expMultiplyID = new ExpressionIdentifier(num,expMultiplyOperator);
		StatementIdentifierDashEqExp elseStmtEq = new StatementIdentifierDashEqExp(expMultiplyID);
		StatementIdentifier stmtElseID = new StatementIdentifier(num_aux,elseStmtEq);
		StatementDashElseStatement elseStmt = new StatementDashElseStatement(stmtElseID);
		StatementIfStatmentDash ifStmt = new StatementIfStatmentDash(expID,stmtIfID,elseStmt);
		stmts.add(ifStmt);
		ExpressionIdentifier returnExp = new ExpressionIdentifier(num, new ExpressionDashLamda());
		MethodDeclaration methodPublicInt = new MethodDeclaration("public",funcType,idComputeFac,allParams,varDeclarations,stmts,returnExp);	
		methodDeclarations.add(methodPublicInt);
		
		ExtendsID extID = new ExtendsID(new Identifier());
		classDeclarations.add(new ClassDeclaration(idComputeFac,extID,new ArrayList<VarDeclaration>(),new ArrayList<ConstructorDeclaration>(),methodDeclarations));
		Goal goal = new Goal(mainClass,classDeclarations);
		System.out.println(goal.getValue());
	}
}
