package SyntaxAnalyzer;

public class ExpressionDotDashLength implements ExpressionDotDash{

	ExpressionDash expDash;

	public ExpressionDotDashLength() {
		super();
		this.expDash  = null;
	}

	public ExpressionDotDashLength(ExpressionDash expDash) {
		super();
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "length "+expDash.getValue();
	}
	
	
	
	
}
