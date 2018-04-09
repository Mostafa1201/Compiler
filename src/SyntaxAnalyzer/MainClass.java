package SyntaxAnalyzer;

public class MainClass implements Root{

	Identifier id1;
	String Str;
	Identifier id2;
	Statement stmt;
	
	public MainClass() {
		super();
		this.id1 = null;
		this.Str = "";
		this.id2 = null;
		this.stmt = null;
	}

	public MainClass(Identifier id1,String str,Identifier id2,Statement stmt) {
		super();
		this.id1 = id1;
		this.Str = str;
		this.id2 = id2;
		this.stmt = stmt;
	}
	
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "class " + id1.getValue() + "{ public static void main (" + " " + Str + 
				" [] " + id2.getValue() + " )  } " + "Statement" + " "  + " } }";
	}
}
