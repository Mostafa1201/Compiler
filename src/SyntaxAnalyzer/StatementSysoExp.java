package SyntaxAnalyzer;

public class StatementSysoExp implements Statement{

	String Syso;
	String leftParenthesis;
	Expression expression;
	String rightParenthesis;
	String semicolon;
	
	public StatementSysoExp() {
		this.Syso = "System.out.println";
		this.leftParenthesis = "(";
		this.expression = null;
		this.rightParenthesis = ")";
		this.semicolon = ";";
	}
	
	public StatementSysoExp(String Syso, String leftParenthesis, Expression expression, String rightParenthesis,
			String semicolon) {
		super();
		this.Syso = Syso;
		this.leftParenthesis = leftParenthesis;
		this.expression = expression;
		this.rightParenthesis = rightParenthesis;
		this.semicolon = semicolon;
	}

	@Override
	public String getValue() {
		return Syso + leftParenthesis + expression.getValue() + rightParenthesis +
				semicolon;
	}
	
}
