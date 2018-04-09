package SyntaxAnalyzer;

public class ExpressionThis implements Expression{

	String This;
	ExpressionDash expDash;
	
	public ExpressionThis() {
		super();
		this.This = "this";
		this.expDash = null;
	}

	public ExpressionThis(String This,ExpressionDash expDash) {
		super();
		this.This = This;
		this.expDash = expDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return This + " " + expDash.getValue();
	}
	
}
