package SyntaxAnalyzer;

public class ExtendsID implements Root{

	String Extends = "extends";
	Identifier id;

	public ExtendsID() {
		super();
		this.id = null;
	}

	public ExtendsID(String Extends,Identifier id) {
		super();
		this.Extends = Extends;
		this.id = id;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Extends + " " + id.getValue(); 
	}
}
