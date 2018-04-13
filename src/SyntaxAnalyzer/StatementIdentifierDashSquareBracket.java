package SyntaxAnalyzer;

public class StatementIdentifierDashSquareBracket implements StatementIdentifierDash{

	String leftSquare;
	Expression expression;
	String rightSquare;
	String equal;
	Expression expression2;
	String semicolon;
	
	public StatementIdentifierDashSquareBracket() {
		super();
		this.expression = null;
		this.expression2 = null;
	}

	public StatementIdentifierDashSquareBracket(Expression expression,
			Expression expression2) {
		super();
		this.leftSquare = "[";
		this.expression = expression;
		this.rightSquare = "]";
		this.equal = "=";
		this.expression2 = expression2;
		this.semicolon = ";";
	}

	@Override
	public String getValue() {
		return leftSquare + expression.getValue() + rightSquare + " " + equal + " " + expression2.getValue() + " " + semicolon;
	}	
	
}
