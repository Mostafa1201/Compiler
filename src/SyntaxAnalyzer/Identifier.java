package SyntaxAnalyzer;

public class Identifier implements Root{

	String id;

	public Identifier() {
		super();
		id = "";
	}

	public Identifier(String id) {
		super();
		this.id = id;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
}
