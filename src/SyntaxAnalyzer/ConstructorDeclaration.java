package SyntaxAnalyzer;

import java.util.ArrayList;

public class ConstructorDeclaration implements Root{
	Identifier id1;
	String leftParanthesis;
	ArrayList<Type> type;
	ArrayList<String> comma;
	ArrayList<Identifier> id2;
	String rightParanthesis;
	String leftCurly;
	ArrayList<VarDeclaration> varr;
	ArrayList<Statement> stmt;
	String rightCurly;
	
	
	
	public ConstructorDeclaration() {
		this.id1 = null;
		this.leftParanthesis = "(";
		this.type = new ArrayList<Type>(0);
		this.comma = new ArrayList<String>(0);
		this.id2 = new ArrayList<Identifier>(0);
		this.rightParanthesis = ")";
		this.leftCurly = "{";
		this.varr = new ArrayList<VarDeclaration>(0);
		this.stmt = new ArrayList<Statement>(0);
		this.rightCurly = "}";
	}

	public ConstructorDeclaration(Identifier id1, String leftParanthesis, ArrayList<Type> type,
			ArrayList<String> comma, ArrayList<Identifier> id2, String rightParanthesis, String leftCurly,
			ArrayList<VarDeclaration> varr, ArrayList<Statement> stmt, String rightCurly) {
		this.id1 = id1;
		this.leftParanthesis = leftParanthesis;
		this.type = type;
		this.comma = comma;
		this.id2 = id2;
		this.rightParanthesis = rightParanthesis;
		this.leftCurly = leftCurly;
		this.varr = varr;
		this.stmt = stmt;
		this.rightCurly = rightCurly;
	}
	@Override
	public String getValue() {
		String typeid = "";
		String commatypeid="";
		if(type.size()>0){
			typeid=type.get(0).getValue()+" " + id2.get(0).getValue()+" ";
			if(type.size()>1){
				for(int i = 1  ; i < type.size() ; i++)
				{
					commatypeid += comma.get(i-1)+type.get(i).getValue()+" "+id2.get(i).getValue()+" ";
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
		
		return id1.getValue()+leftParanthesis +typeid +commatypeid+rightParanthesis+leftCurly+vtemp+" "+sttemp+rightCurly;
	}
	
	
	
}
