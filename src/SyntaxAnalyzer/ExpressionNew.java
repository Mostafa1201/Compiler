package SyntaxAnalyzer;

public class ExpressionNew implements Expression{

	ExpressionNewDash expNewDash;
	
	
	public ExpressionNew() {
		super();
		this.expNewDash = null;
	}


	public ExpressionNew(ExpressionNewDash expNewDash) {
		super();
		this.expNewDash = expNewDash;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "new " + expNewDash.getValue();
	}
	
	
}
