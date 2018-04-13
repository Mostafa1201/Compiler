package SyntaxAnalyzer;

import java.util.ArrayList;

public class ExpressionNewDashIdentifier implements ExpressionNewDash{

	Identifier id;
	ArrayList<ManyExpressions> exps;//(Expression ( "," Expression)*)? 
	ExpressionDash expDash;

	
	public ExpressionNewDashIdentifier() {
		super();
		this.id = null;
		this.expDash = null;
		this.exps =  new ArrayList<ManyExpressions>(0);
	}


	public ExpressionNewDashIdentifier(Identifier id, ArrayList<ManyExpressions> exps, ExpressionDash expDash) {
		super();
		this.id = id;
		this.expDash = expDash;
		this.exps = exps;
		if(exps.size() > 1)
		{
			System.out.println("Syntax Error on MultipleExpressions");
			exps = new ArrayList<ManyExpressions>(0);
		}
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String temp = "";
		for(int i = 0  ; i < exps.size() ; i++)
		{
			temp += exps.get(i).getValue()+" ";
		}
		return id.getValue() + "(" + temp	+ ")" + expDash.getValue(); 
	}

}
