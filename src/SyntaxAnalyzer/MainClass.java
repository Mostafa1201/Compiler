package SyntaxAnalyzer;

public class MainClass implements Node{

	String Class = "Class";
	Identifier id1 = null;
	String leftCurly1 = "{";
	String Public = "public";
	String Static = "static";
	String Void = "void";
	String Main = "main";
	String leftParanthesis = "(";
	String Str = "String";
	String leftSquare = "[";
	String rightSquare = "]";
	Identifier id2= null;
	String rightParanthesis = ")";
	String leftCurly2 = "{";
	Statement stmt = null;
	String rightCurly1 = "}";
	String rightCurly2 = "}";
	
	public MainClass(String class1, Identifier id1, String leftCurly1, String public1, String static1, String void1,
			String main, String leftParanthesis, String str, String leftSquare, String rightSquare, Identifier id2,
			String rightParanthesis, String leftCurly2, Statement stmt, String rightCurly1, String rightCurly2) {
		super();
		Class = class1;
		this.id1 = id1;
		this.leftCurly1 = leftCurly1;
		Public = public1;
		Static = static1;
		Void = void1;
		Main = main;
		this.leftParanthesis = leftParanthesis;
		Str = str;
		this.leftSquare = leftSquare;
		this.rightSquare = rightSquare;
		this.id2 = id2;
		this.rightParanthesis = rightParanthesis;
		this.leftCurly2 = leftCurly2;
		this.stmt = stmt;
		this.rightCurly1 = rightCurly1;
		this.rightCurly2 = rightCurly2;
	}
	
	public String getOurClass() {
		return Class;
	}
	public void setClass(String class1) {
		Class = class1;
	}
	public Identifier getId1() {
		return id1;
	}
	public void setId1(Identifier id1) {
		this.id1 = id1;
	}
	public String getLeftCurly1() {
		return leftCurly1;
	}
	public void setLeftCurly1(String leftCurly1) {
		this.leftCurly1 = leftCurly1;
	}
	public String getPublic() {
		return Public;
	}
	public void setPublic(String public1) {
		Public = public1;
	}
	public String getStatic() {
		return Static;
	}
	public void setStatic(String static1) {
		Static = static1;
	}
	public String getVoid() {
		return Void;
	}
	public void setVoid(String void1) {
		Void = void1;
	}
	public String getMain() {
		return Main;
	}
	public void setMain(String main) {
		Main = main;
	}
	public String getLeftParanthesis() {
		return leftParanthesis;
	}
	public void setLeftParanthesis(String leftParanthesis) {
		this.leftParanthesis = leftParanthesis;
	}
	public String getStr() {
		return Str;
	}
	public void setStr(String str) {
		Str = str;
	}
	public String getLeftSquare() {
		return leftSquare;
	}
	public void setLeftSquare(String leftSquare) {
		this.leftSquare = leftSquare;
	}
	public String getRightSquare() {
		return rightSquare;
	}
	public void setRightSquare(String rightSquare) {
		this.rightSquare = rightSquare;
	}
	public Identifier getId2() {
		return id2;
	}
	public void setId2(Identifier id2) {
		this.id2 = id2;
	}
	public String getRightParanthesis() {
		return rightParanthesis;
	}
	public void setRightParanthesis(String rightParanthesis) {
		this.rightParanthesis = rightParanthesis;
	}
	public String getLeftCurly2() {
		return leftCurly2;
	}
	public void setLeftCurly2(String leftCurly2) {
		this.leftCurly2 = leftCurly2;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	public String getRightCurly1() {
		return rightCurly1;
	}
	public void setRightCurly1(String rightCurly1) {
		this.rightCurly1 = rightCurly1;
	}
	public String getRightCurly2() {
		return rightCurly2;
	}
	public void setRightCurly2(String rightCurly2) {
		this.rightCurly2 = rightCurly2;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return Class + "identifier1" + " " + leftCurly1 + " " + Public + " " + Static + " " + Void + " " + Main + " " + leftParanthesis + " " + Str + 
				" " + leftSquare + " "+ rightSquare + " " + "Identifier2" + rightParanthesis + " " + leftCurly2 + " " + "Statement" + " "  + rightCurly1 +
				" " + rightCurly2;
	}
}
