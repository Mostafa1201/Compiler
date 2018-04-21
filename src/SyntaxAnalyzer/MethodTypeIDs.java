package SyntaxAnalyzer;

import java.util.ArrayList;

public class MethodTypeIDs implements Root{

	TypeIdentifier typeID;
	ArrayList<TypeIdentifier> typeIDs;
	
	public MethodTypeIDs() {
		super();
		this.typeID = null;
		this.typeIDs = null;
	}
	public MethodTypeIDs(TypeIdentifier typeID, ArrayList<TypeIdentifier> typeIDs) {
		super();
		this.typeID = typeID;
		this.typeIDs = typeIDs;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		String str = "";
		for(int i = 0 ; i < typeIDs.size() ; i++)
		{
			str += "," + typeIDs.get(i).getValue();
		}
		return typeID.getValue() + " " + str;
	}
	
	
	
	
}
