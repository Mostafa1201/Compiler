package SyntaxAnalyzer;

public class ExpressionNewDashOne implements ExpressionNewDash{

	String type;
	Expression exp;
	ExpressionDash expDash;
	
	
	public ExpressionNewDashOne() {
		super();
		this.type = "";
		this.exp = null;
		this.expDash = null;
	}

	public ExpressionNewDashOne(String type, Expression exp, ExpressionDash expDash) {
		super();
		this.type = type;
		this.exp = exp;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return type + " " + exp.getValue()+ " "+ expDash.getValue();
	}

}
