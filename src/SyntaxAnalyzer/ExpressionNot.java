package SyntaxAnalyzer;

public class ExpressionNot implements Expression{

	Expression exp;
	ExpressionDash expDash;

	
	public ExpressionNot() {
		super();
		this.exp = null;
		this.expDash = null;
	}

	public ExpressionNot(Expression exp,ExpressionDash expDash) {
		super();
		this.exp = exp;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "! " + exp.getValue() + " " + expDash.getValue();
	}	
	
}
