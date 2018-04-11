package SyntaxAnalyzer;

public class StatementIfStatmentDash implements Statement{

	String IF;
	String leftParenthesis;
	Expression expression;
	String rightParenthesis;
	Statement statment;
	StatementDash statementdash;
	
	public StatementIfStatmentDash() {
		this.IF = "if";
		this.leftParenthesis = "(";
		this.expression = null;
		this.rightParenthesis = ")";
		this.statment = null;
		this.statementdash = null;
	}

	public StatementIfStatmentDash(String iF, String leftParenthesis, Expression expression, String rightParenthesis,
			Statement statment, StatementDash statementdash) {
		super();
		IF = iF;
		this.leftParenthesis = leftParenthesis;
		this.expression = expression;
		this.rightParenthesis = rightParenthesis;
		this.statment = statment;
		this.statementdash = statementdash;
	}
	
	@Override
	public String getValue() {
		return IF + leftParenthesis + expression.getValue() + rightParenthesis +
				statment.getValue() + statementdash.getValue();
	}
	

}
