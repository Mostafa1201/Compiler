package SyntaxAnalyzer;

import java.util.ArrayList;

public class MethodDeclaration implements Root {

	String classType;
	TypeIdentifier tid;
	String leftParanthesis;
	MethodTypeIDs typeIDs;
	String rightParanthesis;
	String leftCurly;
	ArrayList<VarDeclaration> varr;
	ArrayList<Statement> stmt;
	String Return;
	Expression exp;
	String semicolon;
	String rightCurly;
	
	


	public MethodDeclaration() {
		super();
		this.classType = "";
		this.tid = null;
		this.typeIDs = null;
		this.varr = null;
		this.stmt = null;
		this.exp = null;
	}

	


	public MethodDeclaration(String classType,TypeIdentifier tid,MethodTypeIDs typeIDs,  ArrayList<VarDeclaration> varr,
			ArrayList<Statement> stmt,Expression exp) {
		super();
		this.classType = classType;
		this.tid = tid;
		this.leftParanthesis = "(";
		this.typeIDs = typeIDs;
		this.rightParanthesis = ")";
		this.leftCurly = "{";
		this.varr = varr;
		this.stmt = stmt;
		Return = "return";
		this.exp = exp;
		this.semicolon = ";";
		this.rightCurly = "}";
	}




	@Override
	public String getValue() {
		
		String vtemp = "";
		if(stmt.size() == 1)vtemp += varr.get(0).getValue();
		else
		{
			for(int i = 0  ; i < varr.size() ; i++)
			{
				vtemp += varr.get(i).getValue()+",";
			}
		}
		
		String sttemp = "";
		if(stmt.size() == 1)sttemp += stmt.get(0).getValue();
		else{
			for(int i = 0  ; i < stmt.size() ; i++)	
			{
				sttemp += stmt.get(i).getValue()+",";
			}
		}
		
		return "\t " + classType+" " + tid.getValue()+  leftParanthesis + typeIDs.getValue() + rightParanthesis +leftCurly+"\n \t" + vtemp+" \t"+sttemp+" \t \t \t"+Return+ " " + exp.getValue()+semicolon+ "\n \t "+rightCurly;
	}

}
