package SyntaxAnalyzer;

public class ExpressionNot implements Expression{

	String Not;
	Expression exp;
	ExpressionDash expDash;

	
	public ExpressionNot() {
		super();
		this.Not = "!";
		this.exp = null;
		this.expDash = null;
	}

	public ExpressionNot(String Not,Expression exp,ExpressionDash expDash) {
		super();
		this.Not = Not;
		this.exp = exp;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Not + " " + exp.getValue() + " " + expDash.getValue();
	}	
	
}
