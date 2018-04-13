package SyntaxAnalyzer;

public class StatementDashElseStatement implements StatementDash{

	String Else;
	Statement statement;
	
	public StatementDashElseStatement() {
		super();
		this.statement = null;
	}

	public StatementDashElseStatement(Statement statement) {
		super();
		this.Else = "else";
		this.statement = statement;
	}
	
	@Override
	public String getValue() {
		return "\n \t \t" + Else + " \n \t \t \t" + statement.getValue()+ " \n";
	}

}
