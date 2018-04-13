package SyntaxAnalyzer;

public class StatementIdentifier implements Statement{

	Identifier id;
	StatementIdentifierDash stmtID;
	
	
	public StatementIdentifier() {
		super();
		this.id = null;
		this.stmtID = null;
	}


	public StatementIdentifier(Identifier id, StatementIdentifierDash stmtID) {
		super();
		this.id = id;
		this.stmtID = stmtID;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return id.getValue() + " " + stmtID.getValue();
	}
}

