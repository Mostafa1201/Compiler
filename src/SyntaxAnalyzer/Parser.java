package SyntaxAnalyzer;

import java.util.ArrayList;
import java.util.Queue;

import LexicalAnalyzer.Token;
import LexicalAnalyzer.Tokenizer;

public class Parser {

	Queue<Token> tokens;
	
	public Parser(String filename) {
		Tokenizer tokenizer = new Tokenizer(filename);
		tokens = tokenizer.getTokensQueue();
	}

	public Goal getGoal()
	{
		MainClass mainClass = getMain();
		if(mainClass != null)
		{
			ArrayList<ClassDeclaration> classDeclarations = getClassDeclarations();
			return new Goal(mainClass,classDeclarations);
		}
		return null;
	}
	
	public MainClass getMain()
	{
		Identifier id1 = new Identifier();
		Identifier id2 = new Identifier();
		Statement stm;
		if(tokens.peek().getType().equals("CLASS"))
		{
			tokens.poll();
			if(tokens.peek().getType().equals("ID"))
			{
				id1 = getIdentifier();
				if(id1 == null)
				{
					System.out.println("Syntax Error on Identifier");
					return null;
				}
				if(tokens.peek().getType().equals("LEFT_CURLY_B"))
				{
					tokens.poll();
					if(tokens.peek().getType().equals("PUBLIC"))
					{
						tokens.poll();
						if(tokens.peek().getType().equals("STATIC"))
						{
							tokens.poll();
							if(tokens.peek().getType().equals("VOID"))
							{
								tokens.poll();
								if(tokens.peek().getType().equals("MAIN"))
								{
									tokens.poll();
									if(tokens.peek().getType().equals("LEFT_ROUND_B"))
									{
										tokens.poll();
										if(tokens.peek().getType().equals("STRING"))
										{
											tokens.poll();
											if(tokens.peek().getType().equals("LEFT_SQUARE_B"))
											{
												tokens.poll();
												if(tokens.peek().getType().equals("RIGHT_SQUARE_B"))
												{
													tokens.poll();
														id2 = getIdentifier();
														if(id2 == null)
														{
															System.out.println("Syntax Error on Identifier");
															return null;
														}
														if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
														{
															tokens.poll();
															if(tokens.peek().getType().equals("LEFT_CURLY_B"))
															{
																tokens.poll();							
																stm = getStatement();
																if(stm == null)
																{
																	System.out.println("Syntax Error on Statement");
																	return null;
																}
																
																if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
																{
																	tokens.poll();
																	if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
																	{
																		tokens.poll();
																		return new MainClass(id1,id2,stm);
																	}
																}
															}
														}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return null;
	}
	
	public Identifier getIdentifier()
	{
		if(tokens.peek().getType().equals("ID"))
		{
			return new Identifier(tokens.poll().getValue());
		}
		return null;
	}
	
	public Statement getStatement()
	{	
		ArrayList<Statement> statements=new <Statement> ArrayList(0);
		Expression exp;
		Statement stm;
		StatementDash stmdash;
		Identifier id;
		StatementIdentifierDash stmid;
		if(tokens.peek().getType().equals("LEFT_CURLY_B")){
			tokens.poll();							
			statements = getStatements();
			if(statements == null)
			{
				System.out.println("Syntax Error on Statements");
				return null;
			}
			if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
			{
				tokens.poll();
				return new StatementOrMore(statements);
			}
		}
		else if(tokens.peek().getType().equals("IF"))
		{
			tokens.poll();
			if(tokens.peek().getType().equals("LEFT_ROUND_B"))
			{
				tokens.poll();
				exp = getExpression();
				if(exp == null)
				{
					System.out.println("Syntax Error on Expression");
					return null;
				}
				if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
				{
					tokens.poll();
					stm = getStatement();
					if(stm == null)
					{
						System.out.println("Syntax Error on Statement");
						return null;
					}
					stmdash = getStatementDash();
					if(stmdash == null)
					{
						System.out.println("Syntax Error on StatementDash");
						return null;
					}
					return new StatementIfStatmentDash(exp,stm,stmdash);
				}
			}
			
		}
		else if(tokens.peek().getType().equals("WHILE"))
		{
			tokens.poll();
			if(tokens.peek().getType().equals("LEFT_ROUND_B"))
			{
				tokens.poll();
				exp = getExpression();
				if(exp == null)
				{
					System.out.println("Syntax Error on Expression");
					return null;
				}
				if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
				{
					tokens.poll();
					stm = getStatement();
					if(stm == null)
					{
						System.out.println("Syntax Error on Statement");
						return null;
					}
					return new StatementWhileExp(exp,stm);
				}
			}
		}
		else if(tokens.peek().getType().equals("SYSTEM.OUT.PRINTLN"))
		{
			tokens.poll();
			if(tokens.peek().getType().equals("LEFT_ROUND_B"))
			{
				tokens.poll();
				exp = getExpression();
				if(exp == null)
				{
					System.out.println("Syntax Error on Expression");
					return null;
				}
				if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
				{
					tokens.poll();
					if(tokens.peek().getType().equals("SEMICOLON"))
					{
						tokens.poll();
						return new StatementSysoExp(exp);
					}
				}
			}
		}
		else if(tokens.peek().getType().equals("ID"))
		{
			id = getIdentifier();
			if(id == null)
			{
				System.out.println("Syntax Error on Identifier");
				return null;
			}
			stmid = getStatementIdentifierDash();
			if(stmid == null)
			{
				System.out.println("Syntax Error on StatementIdentifier");
				return null;
			}
			return new StatementIdentifier(id,stmid);
		}
		return null;
	}
	
	public StatementDash getStatementDash()
	{
		Statement stm;
		if(tokens.peek().getType().equals("ELSE"))
		{
			tokens.poll();
			stm = getStatement();
			if(stm == null)
			{
				System.out.println("Syntax Error on Statement");
				return null;
			}
			return new StatementDashElseStatement(stm);
		}
		else
		{
			return new StatementDashLamda();
		}
	}
	
	public StatementIdentifierDash getStatementIdentifierDash()
	{
		Expression exp1;
		Expression exp2;
		if(tokens.peek().getType().equals("EQUAL"))
		{
			tokens.poll();
			exp1 = getExpression();
			if(exp1 == null)
			{
				System.out.println("Syntax Error on Expression");
				return null;
			}
			if(tokens.peek().getType().equals("SEMICOLON"))
			{
				tokens.poll();
				return new StatementIdentifierDashEqExp(exp1);
			}
		}
		else if(tokens.peek().getType().equals("LEFT_SQUARE_B"))
		{
			tokens.poll();
			exp1 = getExpression();
			if(exp1 == null)
			{
				System.out.println("Syntax Error on Expression");
				return null;
			}
			if(tokens.peek().getType().equals("RIGHT_SQUARE_B"))
			{
				tokens.poll();
				if(tokens.peek().getType().equals("EQUAL"))
				{
					tokens.poll();
					exp2 = getExpression();
					if(exp2 == null)
					{
						System.out.println("Syntax Error on Expression");
						return null;
					}
					if(tokens.peek().getType().equals("SEMICOLON"))
					{
						tokens.poll();
						return new StatementIdentifierDashSquareBracket(exp1,exp2);
					}
				}
			}
			
		}
		return null;
	}
	
	public Expression getExpression()
	{
		if(tokens.peek().getType().equals("INTEGER_LITERAL"))
		{
			
		}
		else if(tokens.peek().getType().equals("FLOAT_LITERAL"))
		{
			
		}
		else if(tokens.peek().getType().equals("TRUE"))
		{
			
		}
		else if(tokens.peek().getType().equals("FALSE"))
		{
			
		}
		else if(tokens.peek().getType().equals("ID"))
		{
			
		}
		else if(tokens.peek().getType().equals("THIS"))
		{
			
		}
		else if(tokens.peek().getType().equals("NOT"))
		{
			
		}
		else if(tokens.peek().getType().equals("LEFT_ROUND_B"))
		{
			
		}
		return null;
	}
	
 	public ArrayList<ClassDeclaration> getClassDeclarations()
	{
 		ArrayList<ClassDeclaration> var=new ArrayList<ClassDeclaration>(0);
 		ClassDeclaration cd=getClassDeclaration();
		while(cd!=null){
			var.add(cd);
		}
		return var;
	}
 	public ClassDeclaration getClassDeclaration(){
 		Identifier id1 = new Identifier();
 		ExtendsID ed=new ExtendsID();
		Identifier id2 = new Identifier();
		ArrayList<VarDeclaration> vd=new <VarDeclaration> ArrayList(0);
		ArrayList<ConstructorDeclaration> cd=new <ConstructorDeclaration> ArrayList(0);
		ArrayList<MethodDeclaration> md=new <MethodDeclaration> ArrayList(0);
		if(tokens.peek().getType().equals("CLASS"))
		{
			tokens.poll();
			id1 = getIdentifier();
			if(id1 == null)
			{
				System.out.println("Syntax Error on Identifier"+id1.getValue());
				return null;
			}
			ed = getExtendsId();
			if(tokens.peek().getType().equals("LEFT_CURLY_B"))
			{
				tokens.poll();
				vd=getVarDeclarations();
				if(vd == null)
				{
					System.out.println("Syntax Error on VarDeclaration");
					return null;
				}
				if(tokens.peek().getType().equals("LEFT_CURLY_B"))
				{
					tokens.poll();
					cd=getConstructorDeclarations();
					if(cd == null)
					{
						System.out.println("Syntax Error on ConstructorDeclaration");
						return null;
					}
					md=getMethodDeclarations();
					if(md == null)
					{
						System.out.println("Syntax Error on MethodDeclaration");
						return null;
					}
					if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
					{
						tokens.poll();
						return new ClassDeclaration(id1,ed,vd,cd,md);
					}
					
				}
			}
		}
		return null;
 	}
 	public MethodTypeIDs getMethodTypeIds() {
 		TypeIdentifier tid=new TypeIdentifier();
 		ArrayList<TypeIdentifier> var=new ArrayList<TypeIdentifier>(0);
 		tid=getTypeIdentifier();
		if(tid == null)
		{
			System.out.println("Syntax Error on TypeIdentifier");
			return null;
		}
		var=getTypeIdentifiers();
		return new MethodTypeIDs(tid,var);
	}
 	public ArrayList<MethodDeclaration> getMethodDeclarations() {
 		ArrayList<MethodDeclaration> var=new ArrayList<MethodDeclaration>(0);
 		MethodDeclaration md=getMethodDeclaration();
		while(md!=null){
			var.add(md);
		}
		return var;
	}

 	public ArrayList<ConstructorDeclaration> getConstructorDeclarations() {
		ArrayList<ConstructorDeclaration> var=new ArrayList<ConstructorDeclaration>(0);
		ConstructorDeclaration cd=getConstructorDeclaration();
		while(cd!=null){
			var.add(cd);
		}
		return var;
	}

	public ArrayList<VarDeclaration> getVarDeclarations() {
		ArrayList<VarDeclaration> var=new ArrayList<VarDeclaration>(0);
		VarDeclaration vd=getVarDeclaration();
		while(vd!=null){
			var.add(vd);
		}
		return var;
	}
	public ArrayList<Statement> getStatements() {
		ArrayList<Statement> var=new ArrayList<Statement>(0);
		Statement s=getStatement();
		while(s!=null){
			var.add(s);
		}
		return var;
	}

	public ExtendsID getExtendsId() {
		Identifier id=new Identifier();
		if(tokens.peek().getType().equals("EXTENDS"))
		{
			tokens.poll();
			id=getIdentifier();
			if(id==null){
				System.out.println("Syntax Error on identifier in extendid");
				return null;
			}
			return new ExtendsID(id);
		}
		return null;
	}
	public TypeIdentifier getTypeIdentifier() {
		Type t;
		Identifier id=new Identifier();
		t=getType();
		if(t==null){
			System.out.println("Syntax Error on identifier in type");
			return null;
		}
		id=getIdentifier();
		if(id==null){
			System.out.println("Syntax Error on identifier in identifier");
			return null;
		}
		return new TypeIdentifier(t,id);
	}
	public ArrayList<TypeIdentifier> getTypeIdentifiers() {
		ArrayList<TypeIdentifier> var=new ArrayList<TypeIdentifier>(0);
		TypeIdentifier td=getTypeIdentifier();
		while(td!=null){
			var.add(td);
		}
		return var;
	}
	public VarDeclaration getVarDeclaration(){
 		Type t;
 		Identifier id=new Identifier();
 		t = getType();
		if(t == null)
		{
			System.out.println("Syntax Error on Type");
			return null;
		}
		id = getIdentifier();
		if(id == null)
		{
			System.out.println("Syntax Error on Identifier");
			return null;
		}
		if(tokens.peek().getType().equals("SEMICOLON")){
			tokens.poll();
			return new VarDeclaration(t,id);
		}
		return null;
 	}
 	public ConstructorDeclaration getConstructorDeclaration(){
 		Identifier id=new Identifier();
 		MethodTypeIDs mt=new MethodTypeIDs();
 		ArrayList<VarDeclaration> vd = new ArrayList<VarDeclaration>(0);
 		ArrayList<Statement> s = new ArrayList<Statement>(0);
 		id = getIdentifier();
		if(id == null)
		{
			System.out.println("Syntax Error on Identifier");
			return null;
		}
		if(tokens.peek().getType().equals("LEFT_ROUND_B"))
		{
			tokens.poll();
			mt=getMethodTypeIds();	//No need to check as it could be no typeid
			if(tokens.peek().getType().equals("RIGHT_ROUND_B")){
				tokens.poll();
				if(tokens.peek().getType().equals("LEFT_CURLY_B"))
				{
					tokens.poll();
					vd=getVarDeclarations();
					if(vd == null)
					{
						System.out.println("Syntax Error on VarDeclaration");
						return null;
					}
					s=getStatements();
					if(s == null)
					{
						System.out.println("Syntax Error on statements");
						return null;
					}
					if(tokens.peek().getType().equals("Right_CURLY_B"))
					{
						tokens.poll();
						return new ConstructorDeclaration(id,mt,vd,s);
					}
				}
				
			}
			
		}
		return null;
 	}
 	public MethodDeclaration getMethodDeclaration(){
 		String ct;
 		TypeIdentifier typeID=new TypeIdentifier();
 		MethodTypeIDs mt=new MethodTypeIDs();
 		ArrayList<VarDeclaration> vd = new ArrayList<VarDeclaration>(0);
 		ArrayList<Statement> s = new ArrayList<Statement>(0);
 		Expression ex;
 		ct=tokens.peek().getType();
 		tokens.poll();
 		if(ct.equals("public")||ct.equals("protected")||ct.equals("private")){
			typeID=getTypeIdentifier();
			if(typeID==null){
				System.out.println("Syntax Error on type identifier");
				return null;
			}
			if(tokens.peek().getType().equals("LEFT_CURLY_B"))
			{
				tokens.poll();
				mt=getMethodTypeIds();
				if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
				{
					tokens.poll();
					if(tokens.peek().getType().equals("LEFT_CURLY_B"))
					{
						tokens.poll();
						vd=getVarDeclarations();
						if(vd == null)
						{
							System.out.println("Syntax Error on VarDeclaration");
							return null;
						}
						s=getStatements();
						if(s == null)
						{
							System.out.println("Syntax Error on statements");
							return null;
						}
						if(tokens.peek().getType().equals("RETURN"))
						{
							tokens.poll();
							ex = getExpression();
							if(ex == null)
							{
								System.out.println("Syntax Error on Expression");
								return null;
							}
							if(tokens.peek().getType().equals("SEMICOLON"))
							{
								tokens.poll();
								if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
								{
									tokens.poll();
									return new MethodDeclaration(ct,typeID,mt,vd,s,ex);
								}
							}
						}
					}
				}
				
			}
 		}
 		return null;
 	}
 	
 	
 	
}
	
