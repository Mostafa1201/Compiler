package SyntaxAnalyzer;

import java.util.ArrayList;

public class ExpressionNewDashIdentifier implements ExpressionNewDash{

	Identifier id;
	ManyExpressions exps;//(Expression ( "," Expression)*)? 
	ExpressionDash expDash;

	
	public ExpressionNewDashIdentifier() {
		super();
		this.id = null;
		this.expDash = null;
		this.exps =  null;
	}


	public ExpressionNewDashIdentifier(Identifier id, ManyExpressions exps, ExpressionDash expDash) {
		super();
		this.id = id;
		this.expDash = expDash;
		this.exps = exps;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		if(exps!=null)
			return id.getValue() + "(" + exps.getValue()+ ")" + expDash.getValue(); 
		else
			return id.getValue() + "()" + expDash.getValue(); 

	}
	
}
