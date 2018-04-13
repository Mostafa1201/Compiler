package SyntaxAnalyzer;

public class StatementIdentifierDashEqExp implements StatementIdentifierDash{

	String equal;
	Expression expression;
	String semicolon;
	
	public StatementIdentifierDashEqExp() {
		super();
		this.expression = null;
	}

	public StatementIdentifierDashEqExp(Expression expression){
		super();
		this.equal = "=";
		this.expression = expression;
		this.semicolon = ";";
	}

	@Override
	public String getValue() {
		return equal + " " + expression.getValue() + " " + semicolon;
	}	
	
}
