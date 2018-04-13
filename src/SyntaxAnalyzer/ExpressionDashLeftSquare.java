package SyntaxAnalyzer;

public class ExpressionDashLeftSquare implements ExpressionDash{

	Expression exp;
	ExpressionDash expDash;
	
	public ExpressionDashLeftSquare() {
		super();
		this.exp = null;
		this.expDash = null;
	}

	public ExpressionDashLeftSquare(Expression exp, ExpressionDash expDash) {
		super();
		this.exp = exp;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "[" + exp.getValue() + "] " + expDash.getValue();
	}
}
