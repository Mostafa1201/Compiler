package SyntaxAnalyzer;

public class ExpressionDotDashOne implements ExpressionDotDash{

	String length;
	ExpressionDash expDash;

	public ExpressionDotDashOne() {
		super();
		this.length = "length";
		this.expDash  = null;
	}

	public ExpressionDotDashOne(String length, ExpressionDash expDash) {
		super();
		this.length = length;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return length + " " + expDash.getValue();
	}
	
	
	
	
}
