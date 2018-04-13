package SyntaxAnalyzer;

public class VarDeclaration implements Root{
	Type type;
	Identifier id;
	String semicolon;
	
	
	public VarDeclaration() {
		this.type = null;
		this.id = null;
	}


	public VarDeclaration(Type type, Identifier id) {
		this.type = type;
		this.id = id;
		this.semicolon = ";";
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "\t" + type.getValue()+" "+id.getValue()+" " +semicolon + "\n";
	}
	
}
