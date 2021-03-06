package SyntaxAnalyzer;

import java.util.ArrayList;

public class ManyExpressions implements Expression{

	Expression exp;
	ArrayList<Expression> anotherExps;
	
	
	public ManyExpressions() {
		super();
		this.exp = null;
		this.anotherExps = new ArrayList<Expression>(0);
	}
	
	
	public ManyExpressions(Expression exp, ArrayList<Expression> anotherExps) {
		super();
		this.exp = exp;
		this.anotherExps = anotherExps;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String temp = "";
		if(anotherExps.size() == 0)
		{
			if(exp == null) return "";
		}
		else if(anotherExps.size() == 1)temp += ","+anotherExps.get(0).getValue();
		else
		{
			for(int i = 0  ; i < anotherExps.size() ; i++)
			{
				temp += "," + anotherExps.get(i).getValue();
			}
		}
		return exp.getValue() + temp;
	}	
}
