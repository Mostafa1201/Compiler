package SyntaxAnalyzer;

import java.util.ArrayList;

public class StatementOrMore implements Statement{
	
	ArrayList<Statement> statments;
	
	public StatementOrMore() {
		super();
		this.statments =  new ArrayList<Statement>(0);
	}

	public StatementOrMore(ArrayList<Statement> statments) {
		super();
		this.statments = statments;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String str = "";
		for(int i = 0  ; i < statments.size() ; i++)
		{
			str += statments.get(i).getValue()+"\n";
		}
		return "{ \n" + str + "\t}";
	}
	
}
