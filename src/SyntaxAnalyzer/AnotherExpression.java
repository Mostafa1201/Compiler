package SyntaxAnalyzer;

public class AnotherExpression implements Expression{

	Expression exp;
	
	
	public AnotherExpression(Expression exp) {
		super();
		this.exp = exp;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "," + exp.getValue();
	}
	
	
}
