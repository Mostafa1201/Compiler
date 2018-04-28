
package LexicalAnalyzer;
import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    static Map<Integer, Token> indexMap = new TreeMap<Integer, Token>();
    
    static Queue<Token> tokensQueue = new LinkedList<>();
    
    public Tokenizer(String fileName)
    {
    	read(fileName);
    }
   
    public static Queue<Token> getTokensQueue() {
		return tokensQueue;
	}

	public static void read(String filename) {
        try {
            String input = new Scanner(new File(filename)).useDelimiter("\\Z").next() + "\n";
            match(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        print();
    }

    public static void match(String x) {
        StringBuffer input = new StringBuffer(x);
        input = new StringBuffer(x);
        String reg = "(\"[^\"|\n]*\")|((\\/\\*)(((\\s*|(\\w|\\W)\\s*))*)(\\*\\/))|(//.*)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group().charAt(0) == '"')
                indexMap.put(matcher.start(), new Token("STRING_LITERAL", matcher.group()));
            else if (matcher.group().charAt(0) == '/' && matcher.group().charAt(1) == '/')
                indexMap.put(matcher.start(), new Token("S_COMMENTS", matcher.group()));
            else
                indexMap.put(matcher.start(), new Token("M_COMMENTS", matcher.group()));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);
            matcher = pattern.matcher(input);
        }

        reg = "(\\'((.)?\\'))";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("A_CHAR", matcher.group(0)));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\")(.*)(\n)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("ERROR", "\"" + matcher.group(2)));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(2); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(2), fill);
        }

        reg = "(\\<=)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("LESS_EQ", "<="));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);
        }

        reg = "(\\>=)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("GREATER_EQ", ">="));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);
        }

        reg = "(\\!=)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("NOT_EQUAL", "!="));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);
        }

        reg = "(\\==)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("EQUAL", "=="));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);
        }

        reg = "(\\;)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("SEMICOLON", ";"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\[)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("LEFT_SQUARE_B", "["));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }     
        
        reg = "(^\bint\b|\\bint\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("INT", "int"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^return|\\breturn\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("RETURN", "return"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^static|\\bstatic\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("STATIC", "static"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^new|\\bnew\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("NEW", "new"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\{)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("LEFT_CURLY_B", "{"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\})";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("RIGHT_CURLY_B", "}"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("RIGHT_SQUARE_B", "]"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }
        reg = "(\\/)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("DIV", "/"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);
        }



        reg = "(\\()";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("LEFT_ROUND_B", "("));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\))";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("RIGHT_ROUND_B", ")"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\+)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("PLUS", "+"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\,)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("COMMA", ","));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "((^(System\\.out\\.println)|\\bSystem\\.out\\.println\\b)($|[^a-zA-Z0-9]))";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("SYSTEM.OUT.PRINTLN", matcher.group(0)));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        
        reg = "(\\s+|[^a-zA-Z] |^)(\\d*\\.\\d+)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(2), new Token("FLOAT_LITERAL", matcher.group(2)));
            String fill = "";
            for (int i = matcher.start(2); i < matcher.end(2); i++)
                fill += " ";
            input.replace(matcher.start(2), matcher.end(2), fill);

        }

        reg = "(\\.)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("DOT", "."));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\!)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("NOT", "!"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\=)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("ASSIGNMENT", "="));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\|\\|)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("OR", "||"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\&&)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("AND", "&&"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\-)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("MINUS", "-"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\*)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("MULTIPLY", "*"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\%)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("MOD", "%"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\<)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("LESSTHAN", "<"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\>)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("GREATERTHAN", ">"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^if|\\bif\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("IF", "if"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^else|\\belse\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("ELSE", "else"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^main|\\bmain\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("MAIN", "main"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^this|\\bthis\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("THIS", "this"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^package|\\bpackage\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("PACKAGE", "package"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^true|\\btrue\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("TRUE", "true"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^void|\\bvoid\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("VOID", "void"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^class|\\bclass\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("CLASS", "class"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^false|\\bfalse\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("FALSE", "false"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^while|\\bwhile\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("WHILE", "while"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^length|\\blength\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("LENGTH", "length"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^public|\\bpublic\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("PUBLIC", "public"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^private|\\bprivate\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("PRIVATE", "private"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^protected|\\bprotected\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("PROTECTED", "protected"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }
        reg = "(^String|\\bString\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("STRING", "String"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^float|\\bfloat\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("FLOAT", "float"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^char|\\bchar\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("CHARACTER", "char"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^boolean|\\bboolean\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("BOOLEAN", "boolean"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^extends|\\bextends\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("EXTENDS", "extends"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^null|\\bnull\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("NULL", "null"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^abstract|\\babstract\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("ABSTRACT", "abstract"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^assert|\\bassert\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("ASSERT", "assert"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^break|\\bbreak\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("BREAK", "break"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^continue|\\bcontinue\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("CONTINUE", "continue"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^byte|\\bbyte\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("BYTE", "byte"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^case|\\bcase\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("CASE", "case"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^catch|\\bcatch\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("CATCH", "catch"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^const|\\bconst\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("CONST", "const"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^default|\\bdefault\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("DEFAULT", "default"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^do|\\bdo\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("DO", "do"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^double|\\bdouble\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("DOUBLE", "double"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^enum|\\benum\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("ENUM", "enum"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^final|\\bfinal\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("FINAL", "final"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^finally|\\bfinally\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("FINALLY", "finally"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^for|\\bfor\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("FOR", "for"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^goto|\\bgoto\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("GOTO", "goto"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^implements|\\bimplements\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("IMPLEMENTS", "implements"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^import|\\bimport\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("IMPORT", "import"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^instanceof|\\binstanceof\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("INSTANCEOF", "instanceof"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^interface|\\binterface\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("INTERFACE", "interface"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^short|\\bshort\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("SHORT", "short"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^super|\\bsuper\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("SUPER", "super"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^switch|\\bswitch\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("SWITCH", "switch"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(^throw|\\bthrow\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("THROW", "throw"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }
        reg = "(^try|\\btry\\b)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("TRY", "try"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }
        int $$ = 5;
        int __ = 5;

        reg = "(\\s+|^)(([a-zA-Z](\\w|\\$|\\_)*|\\$(\\w|\\$|\\_)+|\\_(\\w|\\$|\\_)+))";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(2), new Token("ID", matcher.group(2)));
            String fill = "";
            for (int i = matcher.start(2); i < matcher.end(2); i++)
                fill += " ";
            input.replace(matcher.start(2), matcher.end(2), fill);

        }

        reg = "(^|[^a-zA-Z0-9])(\\d+)($|[^a-zA-Z0-9])";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(2), new Token("INTEGER_LITERAL", matcher.group(2)));
            String fill = "";
            for (int i = matcher.start(2); i < matcher.end(2); i++)
                fill += " ";
            input.replace(matcher.start(2), matcher.end(2), fill);
            matcher = pattern.matcher(input);

        }

        reg = "((\\S)+)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("ERROR", matcher.group(0)));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);

        }

        reg = "(\\n)";
        pattern = Pattern.compile(reg);
        matcher = pattern.matcher(input);
        
        while (matcher.find()) {
            indexMap.put(matcher.start(), new Token("EOL", "End of line"));
            String fill = "";
            for (int i = matcher.start(); i < matcher.end(); i++)
                fill += " ";
            input.replace(matcher.start(), matcher.end(), fill);
        }
        for (int i : indexMap.keySet()) {
        	if(!indexMap.get(i).type.equals("EOL") && !indexMap.get(i).type.equals("S_COMMENTS") && !indexMap.get(i).type.equals("M_COMMENTS"))
        		tokensQueue.add(indexMap.get(i));
        }  
		tokensQueue.add(new Token("EOF" , "End Of File"));
    }

    public static void print() {
        System.out.println("*************************Lexical Analysis*************************");
        output("clear file content !" , true);
        for (int i : indexMap.keySet()) {
            if (indexMap.get(i).type.contains("ERROR")) {output("ERROR: \"" + indexMap.get(i).getValue() + "\" This token did not match any RE @ index " + i , false); }
            else if (indexMap.get(i).type.contains("LITERAL") || indexMap.get(i).type.contains("MINUS")) {output("<" + indexMap.get(i).type + "> : " + indexMap.get(i).value , false); }
            else {
                output(("<" + indexMap.get(i).type + "> : -" + indexMap.get(i).value + "-") , false); }
            if (indexMap.get(i).type.equals("EOL")) {
                output("---------------------------------------------" , false);
            }
        }             
        System.out.println("<EOF> : -End Of File-");
        System.out.println("*************************Syntax Analysis*************************");
    }

    public static void output(final String msg , boolean clear) {
        if(clear){
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("output.txt");
                writer.print("");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
            else{
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true));
                bw.write(msg + "\n");
                bw.close();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void check() {

        print();
    }
    

    public static void main(String args[]) {
        String filename="input.txt";
    	read(filename);
    }

}