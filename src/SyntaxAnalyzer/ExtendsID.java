package SyntaxAnalyzer;

public class ExtendsID implements Root{

	String Extends;
	Identifier id;

	public ExtendsID() {
		super();
		this.Extends = "extends";
		this.id = null;
	}

	public ExtendsID(Identifier id) {
		super();
		this.Extends = "extends";
		this.id = id;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Extends + " " + id.getValue(); 
	}
}
