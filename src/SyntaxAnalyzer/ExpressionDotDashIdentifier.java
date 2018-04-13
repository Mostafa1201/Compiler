package SyntaxAnalyzer;

import java.util.ArrayList;

public class ExpressionDotDashIdentifier implements ExpressionDotDash{

	Identifier id;
	ArrayList<ManyExpressions> exps;//(Expression ( "," Expression)*)? 
	ExpressionDash expDash;
	
	
	public ExpressionDotDashIdentifier() {
		super();
		this.id = null;
		this.exps =  new ArrayList<ManyExpressions>(0);
		this.expDash = null;
	}


	public ExpressionDotDashIdentifier(Identifier id,ArrayList<ManyExpressions> exps,ExpressionDash expDash) {
		super();
		this.id = id;
		this.exps = exps;
		this.expDash = expDash;
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
			if(exps.size() == 1)temp += exps.get(i).getValue();
			else temp += exps.get(i).getValue()+",";
		}
		return id.getValue() + "(" + temp+ ")" + expDash.getValue(); 
	}

}
