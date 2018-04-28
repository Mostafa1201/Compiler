package SyntaxAnalyzer;

import java.util.ArrayList;

public class MainClass implements Root{
	Identifier id1;
	Identifier id2;
	ArrayList<Statement> stmt = new ArrayList<Statement>();
	
	public MainClass() {
		super();
		this.id1 = null;
		this.id2 = null;
		this.stmt = null;
	}
	
	
	public MainClass(Identifier id1,Identifier id2,ArrayList<Statement> stmt) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.stmt = stmt;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String stemp = "";
		if(stmt.size() == 1)stemp += stmt.get(0).getValue();
		else
		{	
			for(int i = 0 ; i < stmt.size() ; i++)
			{
				stemp += stmt.get(i).getValue() + "\n";
			}
		}
		return "class " + id1.getValue() + " {  \n  \t public static void main ("+"String"+"[] "
				+id2.getValue()+ ") { \n \t \t " + stemp +" \n \t \t  } \n \t } \n";
	}
}
