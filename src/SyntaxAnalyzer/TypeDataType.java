package SyntaxAnalyzer;

public class TypeDataType implements Type{

	String dataType;
	TypeDash typeDash;
	
	
	public TypeDataType() {
		super();
		this.dataType = "";
		this.typeDash = null;
	}
	
	public TypeDataType(String dataType, TypeDash typeDash) {
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

