package SyntaxAnalyzer;

public class ExpressionDashOne implements ExpressionDash{

	String operator;
	Expression exp;
	ExpressionDash expDash;
	
	
	public ExpressionDashOne() {
		super();
		this.operator = "";
		this.exp = null;
		this.expDash = null;
	}


	public ExpressionDashOne(String operator, Expression exp, ExpressionDash expDash) {
		super();
		this.operator = operator;
		this.exp = exp;
		this.expDash = expDash;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return operator + " " + exp.getValue() + " " + expDash.getValue();
	}
	
	
}
