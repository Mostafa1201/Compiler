package SyntaxAnalyzer;

public class ExpressionLiterals implements Expression{
	
	String Literal;
	ExpressionDash expDash;
	
	public ExpressionLiterals() {
		super();
		this.Literal = "";
		this.expDash = null;
	}
	
	public ExpressionLiterals(String Literal, ExpressionDash expDash) {
		super();
		this.Literal = Literal;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Literal + expDash.getValue();
	}
}
