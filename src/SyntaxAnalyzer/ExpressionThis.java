package SyntaxAnalyzer;

public class ExpressionThis implements Expression{

	ExpressionDash expDash;
	
	public ExpressionThis() {
		super();
		this.expDash = null;
	}

	public ExpressionThis(ExpressionDash expDash) {
		super();
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "this " + expDash.getValue();
	}
	
}
