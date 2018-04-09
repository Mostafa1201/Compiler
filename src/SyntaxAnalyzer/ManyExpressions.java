package SyntaxAnalyzer;

import java.util.ArrayList;

public class ManyExpressions implements Expression{

	Expression exp;
	ArrayList<AnotherExpression> anotherExps;
	
	
	public ManyExpressions() {
		super();
		this.exp = null;
		this.anotherExps = new ArrayList<AnotherExpression>(0);
	}
	
	
	public ManyExpressions(Expression exp, ArrayList<AnotherExpression> anotherExps) {
		super();
		this.exp = exp;
		this.anotherExps = anotherExps;
	}


	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String temp = "";
		for(int i = 0  ; i < anotherExps.size() ; i++)
		{
			temp += anotherExps.get(i)+" ";
		}
		return exp.getValue() + " " + temp;
	}	
}
