package SyntaxAnalyzer;

public class StatementIdentifierSquareBracket implements StatementIdentifier{

	String leftSquare;
	Expression expression;
	String rightSquare;
	String equal;
	Expression expression2;
	String semicolon;
	
	public StatementIdentifierSquareBracket() {
		super();
		this.leftSquare = "[";
		this.expression = null;
		this.rightSquare = "]";
		this.equal = "=";
		this.expression2 = null;
		this.semicolon = ";";
	}

	public StatementIdentifierSquareBracket(String leftSquare, Expression expression, String rightSquare, String equal,
			Expression expression2, String semicolon) {
		super();
		this.leftSquare = leftSquare;
		this.expression = expression;
		this.rightSquare = rightSquare;
		this.equal = equal;
		this.expression2 = expression2;
		this.semicolon = semicolon;
	}

	@Override
	public String getValue() {
		return leftSquare + expression.getValue() + rightSquare + equal + expression2.getValue() + semicolon;
	}	
	
}
