package SyntaxAnalyzer;

public class TypeofData implements Type{

	String dataType;
	TypeDash typeDash;
	
	
	public TypeofData() {
		super();
		this.dataType = "";
		this.typeDash = null;
	}
	
	public TypeofData(String dataType, TypeDash typeDash) {
		super();
		this.dataType = dataType;
		this.typeDash = typeDash;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return dataType + " " + typeDash.getValue(); 
	}

	
}

