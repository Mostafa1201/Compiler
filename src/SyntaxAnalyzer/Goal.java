package SyntaxAnalyzer;

import java.util.ArrayList;

public class Goal implements Root{
	MainClass mainClass;
	ArrayList<ClassDeclaration> classDeclaration;
	String EOF = "<EOF>";//
	
	public Goal() {
		super();
		this.mainClass = null;
		this.classDeclaration =  new ArrayList<ClassDeclaration>(0);
	}
	
	public Goal(MainClass mainClass, ArrayList<ClassDeclaration> classDeclaration) {
		super();
		this.mainClass = mainClass;
		this.classDeclaration = classDeclaration;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String str = "";
		if(classDeclaration!=null && classDeclaration.size() == 1) str += classDeclaration.get(0).getValue();
		else if(classDeclaration!=null)
		{
			for(int i = 0 ; i < classDeclaration.size() ; i++)
			{
				str += classDeclaration.get(i).getValue() + ",";
			}
		}
		return mainClass.getValue() + str + "\n";
	}
}
