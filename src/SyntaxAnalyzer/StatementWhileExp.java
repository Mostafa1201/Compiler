package SyntaxAnalyzer;

public class StatementWhileExp implements Statement{

	String While;
	String leftParenthesis;
	Expression expression;
	String rightParenthesis;
	Statement statment;
	
	public StatementWhileExp() {
		this.While = "while";
		this.leftParenthesis = "(";
		this.expression = null;
		this.rightParenthesis = ")";
		this.statment = null;
	}
	
	public StatementWhileExp(String While, String leftParenthesis, Expression expression, String rightParenthesis,
			Statement statment) {
		super();
		this.While = While;
		this.leftParenthesis = leftParenthesis;
		this.expression = expression;
		this.rightParenthesis = rightParenthesis;
		this.statment = statment;
	}



	@Override
	public String getValue() {
		return While + leftParenthesis + expression.getValue() + rightParenthesis +
				statment.getValue();
	}
	

}
