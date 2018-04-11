package SyntaxAnalyzer;

public class StatementID implements Statement{

	Identifier identifier;
	StatementIdentifier statementidentifier;
	
	public StatementID() {
		super();
		this.identifier = null;
		this.statementidentifier = null;
	}

	public StatementID(Identifier identifier, StatementIdentifier statementidentifier) {
		super();
		this.identifier = identifier;
		this.statementidentifier = statementidentifier;
	}
	
	@Override
	public String getValue() {
		return identifier.getValue() + statementidentifier.getValue();
	}

}
