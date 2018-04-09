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
		return mainClass.getValue() + "ClassDeclaratios" +"EOF";
	}
	
}
