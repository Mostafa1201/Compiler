package SyntaxAnalyzer;

public class StatementDashElseStatement implements StatementDash{

	String Else;
	Statement statement;
	
	public StatementDashElseStatement() {
		super();
		this.Else = "else";
		this.statement = null;
	}

	public StatementDashElseStatement(String Else, Statement statement) {
		super();
		this.Else = Else;
		this.statement = statement;
	}
	
	@Override
	public String getValue() {
		return Else + statement.getValue();
	}

}
