package SyntaxAnalyzer;

public class StatementIdentifierEqExp implements StatementIdentifier{

	String equal;
	Expression expression;
	String semicolon;
	
	public StatementIdentifierEqExp() {
		super();
		this.equal = "=";
		this.expression = null;
		this.semicolon = ";";
	}

	public StatementIdentifierEqExp(String equal, Expression expression, String semicolon) {
		super();
		this.equal = equal;
		this.expression = expression;
		this.semicolon = semicolon;
	}

	@Override
	public String getValue() {
		return equal + expression.getValue() + semicolon;
	}	
	
}
