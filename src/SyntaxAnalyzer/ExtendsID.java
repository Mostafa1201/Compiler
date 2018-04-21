package SyntaxAnalyzer;

public class ExtendsID implements Root{

	Identifier id;

	public ExtendsID() {
		super();
		this.id = null;
	}

	public ExtendsID(Identifier id) {
		super();
		this.id = id;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		if(id.getValue() ==  "") return "";
		return "extends " + id.getValue(); 
	}
}
