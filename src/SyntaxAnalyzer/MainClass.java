package SyntaxAnalyzer;

public class MainClass implements Root{
	Identifier id1;
	Identifier id2;
	Statement stmt;
	
	public MainClass() {
		super();
		this.id1 = null;
		this.id2 = null;
		this.stmt = null;
	}
	
	
	public MainClass(Identifier id1,Identifier id2,Statement stmt) {
		super();
		
		this.id1 = id1;
		this.id2 = id2;
		this.stmt = stmt;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "class " + id1.getValue() + " {  \n  \t public static void main ("+"String"+"[] "
				+id2.getValue()+ ") { \n \t \t " +stmt.getValue()+" \n \t \t  } \n \t } \n";
	}
}
