package SyntaxAnalyzer;

public class TypeIdentifier implements Root{

	Type type;
	Identifier id;
	
	
	public TypeIdentifier() {
		super();
		this.type = null;
		this.id = null;
	}


	public TypeIdentifier(Type type, Identifier id) {
		super();
		this.type = type;
		this.id = id;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return type.getValue() + " " + id.getValue();
	}
	
	
}
