package SyntaxAnalyzer;

import java.util.ArrayList;

public class ExpressionNewDashTwo implements ExpressionNewDash{

	Identifier id;
	ExpressionDash expDash;
	ArrayList<ManyExpressions> exps;//(Expression ( "," Expression)*)? 
	
	
	public ExpressionNewDashTwo() {
		super();
		this.id = null;
		this.expDash = null;
		this.exps =  new ArrayList<ManyExpressions>(0);
	}


	public ExpressionNewDashTwo(Identifier id, ExpressionDash expDash, ArrayList<ManyExpressions> exps) {
		super();
		this.id = id;
		this.expDash = expDash;
		this.exps = exps;
		if(exps.size() > 1)
		{
			System.out.println("Syntax Error on MultipleExpressions");
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
		return id.getValue() + " ( " + temp	+ " ) " + expDash.getValue(); 
	}

}
