package SyntaxAnalyzer;

public class ExpressionNewDashDataType implements ExpressionNewDash{

	String type;
	Expression exp;
	ExpressionDash expDash;
	
	
	public ExpressionNewDashDataType() {
		super();
		this.type = "";
		this.exp = null;
		this.expDash = null;
	}

	public ExpressionNewDashDataType(String type, Expression exp, ExpressionDash expDash) {
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
