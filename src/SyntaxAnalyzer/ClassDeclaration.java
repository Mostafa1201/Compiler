package SyntaxAnalyzer;
import java.util.ArrayList;
public class ClassDeclaration implements Root{
	String ClasS;
	Identifier id;
	ExtendsID extendsID;
	String leftCurly;
	ArrayList<VarDeclaration> varr;
	ArrayList<ConstructorDeclaration> carr;
	ArrayList<MethodDeclaration> marr;
	String rightCurly;
	
	public ClassDeclaration() {
		this.id = null;
		this.extendsID = null;
		this.varr = new ArrayList<VarDeclaration>(0);
		this.carr = new ArrayList<ConstructorDeclaration>(0);
		this.marr = new ArrayList<MethodDeclaration>(0);
	}

	public ClassDeclaration(Identifier id, ExtendsID extendsID,ArrayList<VarDeclaration> varr, ArrayList<ConstructorDeclaration> carr, ArrayList<MethodDeclaration> marr) {
		ClasS = "class";
		this.id = id;
		this.extendsID = extendsID;
		this.leftCurly = "{";
		this.varr = varr;
		this.carr = carr;
		this.marr = marr;
		this.rightCurly = "}";
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
		return ClasS+" " + id.getValue()+" " + extendsID.getValue()+ " " + leftCurly + "\n" + vtemp+ctemp+  mtemp+ " \n " +rightCurly;
	}
}
