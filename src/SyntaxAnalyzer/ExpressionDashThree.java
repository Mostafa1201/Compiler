package SyntaxAnalyzer;

public class ExpressionDashThree implements ExpressionDotDash{

	ExpressionDotDash expDotDash;

	public ExpressionDashThree() {
		super();
		this.expDotDash = null;
	}

	public ExpressionDashThree(ExpressionDotDash expDotDash) {
		super();
		this.expDotDash = expDotDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return ". " + expDotDash.getValue();
	}
	

}
