package SyntaxAnalyzer;

public class ExpressionDashTwo implements ExpressionDash{

	Expression exp;
	ExpressionDash expDash;
	
	public ExpressionDashTwo() {
		super();
		this.exp = null;
		this.expDash = null;
	}

	public ExpressionDashTwo(Expression exp, ExpressionDash expDash) {
		super();
		this.exp = exp;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "[ " + exp.getValue() + " ] " + expDash.getValue();
	}
}
