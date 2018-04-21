package SyntaxAnalyzer;

import java.util.ArrayList;

public class ExpressionDotDashIdentifier implements ExpressionDotDash{

	Identifier id;
	ManyExpressions exps;//(Expression ( "," Expression)*)? 
	ExpressionDash expDash;
	
	
	public ExpressionDotDashIdentifier() {
		super();
		this.id = null;
		this.exps =  null;
		this.expDash = null;
	}


	public ExpressionDotDashIdentifier(Identifier id,ManyExpressions exps,ExpressionDash expDash) {
		super();
		this.id = id;
		this.exps = exps;
		this.expDash = expDash;
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
