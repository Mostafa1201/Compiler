package SyntaxAnalyzer;

public class StatementIfStatmentDash implements Statement{

	String IF;
	String leftParenthesis;
	Expression expression;
	String rightParenthesis;
	Statement statment;
	StatementDash statementdash;
	
	public StatementIfStatmentDash() {
		this.expression = null;
		this.statment = null;
		this.statementdash = null;
	}

	public StatementIfStatmentDash(Expression expression,Statement statment, StatementDash statementdash) {
		super();
		IF = "if";
		this.leftParenthesis = "(";
		this.expression = expression;
		this.rightParenthesis = ")";
		this.statment = statment;
		this.statementdash = statementdash;
	}
	
	@Override
	public String getValue() {
		return "\t" + IF + leftParenthesis + expression.getValue() + rightParenthesis +
				" \n \t \t \t" + statment.getValue() + statementdash.getValue();
	}
	

}
