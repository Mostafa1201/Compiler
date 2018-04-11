package SyntaxAnalyzer;
import java.util.ArrayList;
public class ClassDeclaration implements Root{
	String ClasS;
	Identifier id1;
	ArrayList<String> Extends;
	ArrayList<Identifier> id2;
	String leftCurly;
	ArrayList<VarDeclaration> varr;
	ArrayList<ConstructorDeclaration> carr;
	ArrayList<MethodDeclaration> marr;
	String rightCurly;
	
	public ClassDeclaration() {
		ClasS = "class";
		this.id1 = null;
		Extends = new ArrayList<String>(0);
		this.id2 = new ArrayList<Identifier>(0);
		this.leftCurly = "{";
		this.varr = new ArrayList<VarDeclaration>(0);
		this.carr = new ArrayList<ConstructorDeclaration>(0);
		this.marr = new ArrayList<MethodDeclaration>(0);
		this.rightCurly = "}";
	}

	public ClassDeclaration(String clasS, Identifier id1, ArrayList<String> extends1, ArrayList<Identifier> id2, String leftCurly,
			ArrayList<VarDeclaration> varr, ArrayList<ConstructorDeclaration> carr, ArrayList<MethodDeclaration> marr,
			String rightCurly) {
		ClasS = clasS;
		this.id1 = id1;
		Extends = extends1;
		this.id2 = id2;
		this.leftCurly = leftCurly;
		this.varr = varr;
		this.carr = carr;
		this.marr = marr;
		this.rightCurly = rightCurly;
	}
	
	

	@Override
	public String getValue() {
		String vtemp = "";
		for(int i = 0  ; i < varr.size() ; i++)
		{
			vtemp += varr.get(i).getValue()+" ";
		}
		String ctemp = "";
		for(int i = 0  ; i < carr.size() ; i++)
		{
			ctemp += carr.get(i).getValue()+" ";
		}
		String mtemp = "";
		for(int i = 0  ; i < marr.size() ; i++)
		{
			mtemp += marr.get(i).getValue()+" ";
		}
		String extident="";
		for(int i = 0  ; i < Extends.size() ; i++)
		{
			extident += Extends.get(i)+" "+id2.get(i).getValue()+" ";
		}
		return ClasS+" " + id1.getValue()+" " + extident+leftCurly+vtemp+ctemp+mtemp+rightCurly;
	}
}
