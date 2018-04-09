package SyntaxAnalyzer;

public class ExpressionIdentifier implements Expression{

	Identifier id;
	ExpressionDash expDash;
	
	
	public ExpressionIdentifier() {
		super();
		this.id = null;
		this.expDash = null; 
	}
	
	public ExpressionIdentifier(Identifier id, ExpressionDash expDash) {
		super();
		this.id = id;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return id.getValue() + " " + expDash.getValue();
	}
	
	
}
