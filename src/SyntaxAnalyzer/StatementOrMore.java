package SyntaxAnalyzer;

import java.util.ArrayList;

public class StatementOrMore implements Statement{
	
	String leftCurly;
	ArrayList<Statement> statments;
	String rightCurly;
	
	public StatementOrMore() {
		super();
		this.leftCurly = "{";
		this.statments =  new ArrayList<Statement>(0);
		this.rightCurly = "}";
	}

	public StatementOrMore(String leftCurly, ArrayList<Statement> statments, String rightCurly) {
		super();
		this.leftCurly = leftCurly;
		this.statments = statments;
		this.rightCurly = rightCurly;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String str = "";
		for(int i = 0  ; i < statments.size() ; i++)
		{
			str += statments.get(i).getValue()+" ";
		}
		return leftCurly + str + rightCurly;
	}
	
}
