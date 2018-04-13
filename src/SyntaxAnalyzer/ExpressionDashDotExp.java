package SyntaxAnalyzer;

public class ExpressionDashDotExp implements ExpressionDash{

	ExpressionDotDash expDotDash;

	public ExpressionDashDotExp() {
		super();
		this.expDotDash = null;
	}

	public ExpressionDashDotExp(ExpressionDotDash expDotDash) {
		super();
		this.expDotDash = expDotDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "." + expDotDash.getValue();
	}
	

}
