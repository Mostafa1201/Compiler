package SyntaxAnalyzer;

import java.util.ArrayList;

public class ConstructorDeclaration implements Root{
	Identifier id;
	String leftParanthesis;
	MethodTypeIDs mtid;
	String rightParanthesis;
	String leftCurly;
	ArrayList<VarDeclaration> varr;
	ArrayList<Statement> stmt;
	String rightCurly;
	
		
	public ConstructorDeclaration() {
		this.id = null;
		this.mtid = new MethodTypeIDs();
		this.varr = new ArrayList<VarDeclaration>(0);
		this.stmt = new ArrayList<Statement>(0);
	}

	public ConstructorDeclaration(Identifier id,MethodTypeIDs typeIDs ,ArrayList<VarDeclaration> varr, ArrayList<Statement> stmt) {
		this.id = id;
		this.leftParanthesis = "(";
		this.mtid =  typeIDs;
		this.rightParanthesis = ")";
		this.leftCurly = "{";
		this.varr = varr;
		this.stmt = stmt;
		this.rightCurly = "}";
	}
	
	@Override
	public String getValue() {
		String vtemp = "";
		if(varr.size() == 1)vtemp += varr.get(0).getValue();
		else
		{
			for(int i = 0  ; i < varr.size() ; i++)
			
			{
				vtemp += varr.get(i).getValue();
			}
		}
		String sttemp = "";
		if(stmt.size() == 1)sttemp += stmt.get(0).getValue();
		else
		{
			for(int i = 0  ; i < stmt.size() ; i++)
			{
				sttemp += stmt.get(i).getValue()+" ";
			}
		}
		if(mtid!=null)
		return "\t" + id.getValue() + " " + leftParanthesis + mtid.getValue()  + rightParanthesis+leftCurly+ " \n" + vtemp+" \n"+sttemp+ "\n" + rightCurly;
		else
			return "\t" + id.getValue() + " " + leftParanthesis + rightParanthesis+leftCurly+ " \n" + vtemp+" \n"+sttemp+ "\n" + rightCurly;

	}
}
