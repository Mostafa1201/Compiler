package SyntaxAnalyzer;

public class ExpressionBoolean implements Expression{
	
	String bool;
	ExpressionDash expDash;

	public ExpressionBoolean() {
		super();
		this.expDash = null;
	}

	public ExpressionBoolean(String bool , ExpressionDash expDash) {
		super();
		this.bool = bool;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return bool + " " + expDash.getValue();
	}
}
 