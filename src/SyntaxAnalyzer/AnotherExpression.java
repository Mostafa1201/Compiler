package SyntaxAnalyzer;

public class AnotherExpression implements Expression{

	String dot = ",";
	Expression exp;
	
	
	public AnotherExpression(String dot, Expression exp) {
		super();
		this.dot = dot;
		this.exp = exp;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return dot + " " + exp.getValue();
	}
	
	
}
