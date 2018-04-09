package Tokenizer;

public class Token {
String value , type;

public Token(String type, String value) {
	super();
	this.value = value;
	this.type = type;
}

public Token() {
	super();
	this.value = "";
	this.type = "";
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

}
