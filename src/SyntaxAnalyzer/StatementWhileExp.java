package SyntaxAnalyzer;

public class StatementWhileExp implements Statement{

	String While;
	String leftParenthesis;
	Expression expression;
	String rightParenthesis;
	Statement statment;
	
	public StatementWhileExp() {
		this.expression = null;
		this.statment = null;
	}
	
	public StatementWhileExp(Expression expression,Statement statment) {
		super();
		this.While = "while";
		this.leftParenthesis = "(";
		this.expression = expression;
		this.rightParenthesis = ")";
		this.statment = statment;
	}



	@Override
	public String getValue() {
		return "\t" + While + leftParenthesis + expression.getValue() + rightParenthesis +
				"\n \t" + statment.getValue();
	}
	

}
