
package SyntaxAnalyzer;

public class ExpressionDashOperators implements ExpressionDash{

	String operator;
	Expression exp;
	ExpressionDash expDash;
	
	
	public ExpressionDashOperators() {
		super();
		this.operator = "";
		this.exp = null;
		this.expDash = null;
	}


	public ExpressionDashOperators(String operator, Expression exp, ExpressionDash expDash) {
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
