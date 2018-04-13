package SyntaxAnalyzer;

import java.util.ArrayList;

public class ConstructorDeclaration implements Root{
	Identifier id;
	String leftParanthesis;
	ArrayList<TypeIdentifier> typeIDs;
	String rightParanthesis;
	String leftCurly;
	ArrayList<VarDeclaration> varr;
	ArrayList<Statement> stmt;
	String rightCurly;
	
	
	
	public ConstructorDeclaration() {
		this.id = null;
		this.typeIDs = new ArrayList<TypeIdentifier>(0);
		this.varr = new ArrayList<VarDeclaration>(0);
		this.stmt = new ArrayList<Statement>(0);
	}

	public ConstructorDeclaration(Identifier id,ArrayList<TypeIdentifier> typeIDs ,ArrayList<VarDeclaration> varr, ArrayList<Statement> stmt) {
		this.id = id;
		this.leftParanthesis = "(";
		this.typeIDs =  typeIDs;
		this.rightParanthesis = ")";
		this.leftCurly = "{";
		this.varr = varr;
		this.stmt = stmt;
		this.rightCurly = "}";
	}
	@Override
	public String getValue() {
		
		String types = "";
		if(varr.size() == 1)types += typeIDs.get(0).getValue();
		else
		{
			for(int i = 0  ; i < typeIDs.size() ; i++)
			
			{
				types += varr.get(i).getValue()+",";
			}
		}
		String vtemp = "";
		if(varr.size() == 1)vtemp += varr.get(0).getValue();
		else
		{
			for(int i = 0  ; i < varr.size() ; i++)
			
			{
				vtemp += varr.get(i).getValue()+",";
			}
		}
		String sttemp = "";
		if(varr.size() == 1)sttemp += stmt.get(0).getValue();
		else
		{
			for(int i = 0  ; i < stmt.size() ; i++)
			
			{
				sttemp += stmt.get(i).getValue()+",";
			}
		}
		return id.getValue() + " " + leftParanthesis + types + rightParanthesis+leftCurly+ " \n" + vtemp+" \n"+sttemp+ "\n" + rightCurly;
	}
	
	
	
}
