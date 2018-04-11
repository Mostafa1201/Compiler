package SyntaxAnalyzer;

public class VarDeclaration implements Root{
	Type type;
	Identifier id;
	String semicolon;
	
	
	public VarDeclaration() {
		this.type = null;
		this.id = null;
		this.semicolon = ";";
	}


	public VarDeclaration(Type type, Identifier id, String semicolon) {
		this.type = type;
		this.id = id;
		this.semicolon = semicolon;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return type.getValue()+" "+id.getValue()+semicolon;
	}
	
}
