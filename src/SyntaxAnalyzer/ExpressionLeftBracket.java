package SyntaxAnalyzer;

public class ExpressionLeftBracket implements Expression{
	
	Expression exp;
	ExpressionDash expDash;
	
	public ExpressionLeftBracket() {
		super();
		this.exp = null;
		this.expDash = null;
	}

	public ExpressionLeftBracket(Expression exp, ExpressionDash expDash) {
		super();
		this.exp = exp;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "(" + exp.getValue() + ")" + expDash.getValue();
	}
	
}
