package SyntaxAnalyzer;

public class MainClass implements Root{
	String ClasS;
	Identifier id1;
	String leftCurly;
	String PubliC;
	String StatiC;
	String VoiD;
	String MaiN;
	String leftParanthesis;
	String StrinG;
	String leftSquare;
	String rightSquare;
	Identifier id2;
	String rightParanthesis;
	String leftCurly2;
	Statement stmt;
	String rightCurly;
	String rightCurly2;
	
	public MainClass(String clasS, Identifier id1, String leftCurly, String publiC, String statiC, String voiD,
			String maiN, String leftParanthesis, String strinG, String leftSquare, String rightSquare, Identifier id2,
			String rightParanthesis, String leftCurly2, Statement stmt, String rightCurly, String rightCurly2) {
		super();
		ClasS = clasS;
		this.id1 = id1;
		this.leftCurly = leftCurly;
		PubliC = publiC;
		StatiC = statiC;
		VoiD = voiD;
		MaiN = maiN;
		this.leftParanthesis = leftParanthesis;
		StrinG = strinG;
		this.leftSquare = leftSquare;
		this.rightSquare = rightSquare;
		this.id2 = id2;
		this.rightParanthesis = rightParanthesis;
		this.leftCurly2 = leftCurly2;
		this.stmt = stmt;
		this.rightCurly = rightCurly;
		this.rightCurly2 = rightCurly2;
	}

	public MainClass() {
		super();
		this.ClasS = "class";
		this.id1 = null;
		this.leftCurly = "{";
		this.PubliC = "public";
		this.StatiC = "static";
		this.VoiD = "void";
		this.MaiN = "main";
		this.leftParanthesis = "(";
		this.StrinG = "String";
		this.leftSquare = "[";
		this.rightSquare = "]";
		this.id2 = null;
		this.rightParanthesis = ")";
		this.leftCurly2 = "{";
		this.stmt = null;
		this.rightCurly = "}";
		this.rightCurly2 = "}";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return ClasS + id1.getValue() + leftCurly+PubliC+" "+StatiC+" "+VoiD+" "+MaiN+" "+leftParanthesis+" "+StrinG+leftSquare+rightSquare
				+id2.getValue()+rightParanthesis+leftCurly2+stmt.getValue()+rightCurly+rightCurly2;
	}
}
