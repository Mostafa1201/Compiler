package SyntaxAnalyzer;

import java.util.ArrayList;

public class MethodDeclarationPublic implements MethodDeclaration {

	String PubliC;
	ArrayList<Type> type;
	ArrayList<String> comma;
	ArrayList<Identifier> id2;
	String leftParanthesis;
	String rightParanthesis;
	String leftCurly;
	ArrayList<VarDeclaration> varr;
	ArrayList<Statement> stmt;
	String Return;
	Expression exp;
	String semicolon;
	String rightCurly;
	
	
	public MethodDeclarationPublic() {
		this.PubliC = "public";
		this.leftParanthesis = "(";
		this.type = new ArrayList<Type>(0);
		this.comma = new ArrayList<String>(0);
		this.id2 = new ArrayList<Identifier>(0);
		this.rightParanthesis = ")";
		this.leftCurly = "{";
		this.varr = new ArrayList<VarDeclaration>(0);
		this.stmt = new ArrayList<Statement>(0);
		this.Return = "return";
		this.exp = null;
		this.semicolon = ";";
		this.rightCurly = "}";
	}


	public MethodDeclarationPublic(String publicC, ArrayList<Type> type, ArrayList<String> comma,
			ArrayList<Identifier> id2, String leftParanthesis, String rightParanthesis, String leftCurly,
			ArrayList<VarDeclaration> varr, ArrayList<Statement> stmt, String return1, Expression exp, String semicolon,
			String rightCurly) {
		this.PubliC = publicC;
		this.type = type;
		this.comma = comma;
		this.id2 = id2;
		this.leftParanthesis = leftParanthesis;
		this.rightParanthesis = rightParanthesis;
		this.leftCurly = leftCurly;
		this.varr = varr;
		this.stmt = stmt;
		this.Return = return1;
		this.exp = exp;
		this.semicolon = semicolon;
		this.rightCurly = rightCurly;
	}


	@Override
	public String getValue() {
		String typeidbeforeparan = type.get(0).getValue()+" " + id2.get(0).getValue()+" ";
		String typeid = "";
		String commatypeid="";
		if(type.size()>1){
			typeid=type.get(1).getValue()+" " + id2.get(1).getValue()+" ";
			if(type.size()>2){
				for(int i = 2  ; i < type.size() ; i++)
				{
					commatypeid += comma.get(i-2)+type.get(i).getValue()+" "+id2.get(i).getValue()+" ";
				}
			}
		}
		
		String vtemp = "";
		for(int i = 0  ; i < varr.size() ; i++)
		{
			vtemp += varr.get(i).getValue()+" ";
		}
		String sttemp = "";
		for(int i = 0  ; i < stmt.size() ; i++)
		{
			sttemp += stmt.get(i).getValue()+" ";
		}
		
		return PubliC+" "+typeidbeforeparan+leftParanthesis +typeid +commatypeid+rightParanthesis+leftCurly+vtemp+" "+sttemp+" "+Return+exp.getValue()+semicolon+rightCurly;
	}

}
