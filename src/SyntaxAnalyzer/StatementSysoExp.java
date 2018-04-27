package SyntaxAnalyzer;

public class StatementSysoExp implements Statement{

	Expression expression;

	public StatementSysoExp(Expression expression) {
		super();
		this.expression = expression;
	}
	
	public StatementSysoExp() {
		this.expression = null;
	}

	@Override
	public String getValue() {
		return "\t System.out.println(" + expression.getValue() + ") ;";
	}
}
