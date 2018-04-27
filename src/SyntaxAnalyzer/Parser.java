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
	
	public Goal parse()
	{
		return getGoal();
	}
	
	public Goal getGoal()
	{
		MainClass mainClass = getMainClass();
		if(mainClass != null)
		{
			if(!tokens.peek().getType().equals("EOF")){
				ArrayList<ClassDeclaration> classDeclarations = getClassDeclarations();
				return new Goal(mainClass,classDeclarations);}
			else return new Goal(mainClass,null);
		}
		return null;
	}
	
	public MainClass getMainClass()
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
					System.out.println("Syntax Error on Identifier " + id1.getValue() + " in Main Class");
					return null;
				}
				if(!tokens.peek().getType().equals("LEFT_CURLY_B"))
				{
					System.out.println("Syntax Error on Left Curly Bracket '{' in Main Class");
					return null;
				}
				else if(tokens.peek().getType().equals("LEFT_CURLY_B"))
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
															System.out.println("Syntax Error on Identifier" + id2.getValue() + "In Main Class");
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
																	System.out.println("Syntax Error on MainClassStatement");
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
																	else{
																		System.out.println("Syntax Error on right curly bracket '}' in Main Class");
																	}
																}
																else{
																	System.out.println("Syntax Error on right curly bracket '}' in Main Class");
																}
															}
															else{
																System.out.println("Syntax Error on left curly bracket '{' in Main Class");
															}
														}
														else{
															System.out.println("Syntax Error on right round bracket ')' in Main Class");
														}
												}
												else{
													System.out.println("Syntax Error on right square bracket ']' in Main Class");
												}
											}
											else{
												System.out.println("Syntax Error on left square bracket '[' in Main Class");
											}
										}
										else{
											System.out.println("Syntax Error on 'String' keyword in Main Class");
										}
									}
									else{
										System.out.println("Syntax Error on left round bracket '(' in Main Class");
									}
								}
								else{
									System.out.println("cannot find 'main' keyword in Main Class");
								}
							}
							else{
								System.out.println("main must be 'void' in Main Class");
							}
						}
						else{
							System.out.println("main must be 'static' in Main Class");
						}
					}
					else{
						System.out.println("main must be 'public' in Main Class");
					}
				}
			}
		}
		else
		{
			System.out.println("Cannot find 'class' Keyword in Class Declaration");
			return null;
		}
		return null;
	}
	
	public ArrayList<ClassDeclaration> getClassDeclarations()
	{
 		ArrayList<ClassDeclaration> var=new ArrayList<ClassDeclaration>(0);
 		ClassDeclaration cd=getClassDeclaration();
		while(cd!=null){
			var.add(cd);
			cd=getClassDeclaration();
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
				System.out.println("Syntax Error on Identifier "+id1.getValue()+ " in Class Declaration");
				return null;
			}
			ed = getExtendsId();
			if(ed==null){
				return null;
			}
		 	if(tokens.peek().getType().equals("LEFT_CURLY_B"))
			{
				tokens.poll();
				vd=getVarDeclarations();
				
				cd=getConstructorDeclarations();
					
				md=getMethodDeclarations();
				if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
				{
						tokens.poll();
						return new ClassDeclaration(id1,ed,vd,cd,md);
				}
				else
				{
						System.out.println("Syntax Error on right curly bracket '}' in Class Declaration");
				}	
			}
			else{
				System.out.println("Syntax Error on left curly bracket '{' in Class Declaration");
			}
		}
		return null;
 	}
 	 	
	public ArrayList<MethodDeclaration> getMethodDeclarations() {
 		ArrayList<MethodDeclaration> var=new ArrayList<MethodDeclaration>(0);
 		MethodDeclaration md=getMethodDeclaration();
		while(md!=null){
			var.add(md);
			md=getMethodDeclaration();
		}
		return var;
	}

	public MethodDeclaration getMethodDeclaration(){
 		String ct;
 		TypeIdentifier typeID=new TypeIdentifier();
 		MethodTypeIDs mt=new MethodTypeIDs();
 		ArrayList<VarDeclaration> vd = new ArrayList<VarDeclaration>(0);
 		ArrayList<Statement> s = new ArrayList<Statement>(0);
 		Expression ex;
		ct=tokens.peek().getType();
 		if(ct.equals("PUBLIC")||ct.equals("PROTECTED")||ct.equals("PRIVATE")){
 			ct=tokens.peek().getValue();
 	 		tokens.poll();
 			typeID=getTypeIdentifier();
			if(typeID==null){
				System.out.println("Syntax Error on Type Identifier in Method Declaration");
				return null;
			}
			if(tokens.peek().getType().equals("LEFT_ROUND_B"))
			{
				tokens.poll();
				mt=getMethodTypeIds();
				if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
				{
					tokens.poll();
					if(tokens.peek().getType().equals("LEFT_CURLY_B"))
					{
						tokens.poll();
						vd=getVarDeclarations();
						if(vd == null)
						{
							System.out.println("Syntax Error on VarDeclaration in Method Declaration");
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
								System.out.println("Syntax Error on ExpressionofMethodDeclaration in Method Declaration");
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

	public MethodTypeIDs getMethodTypeIds() {
 		TypeIdentifier tid=new TypeIdentifier();
 		ArrayList<TypeIdentifier> var=new ArrayList<TypeIdentifier>(0);
 		tid=getTypeIdentifier();
		if(tid == null)
		{
			//System.out.println("Syntax Error on TypeIdentifier");
			return null;
		}
		var=getTypeIdentifiers();
		return new MethodTypeIDs(tid,var);
	}
	
 	public ArrayList<ConstructorDeclaration> getConstructorDeclarations() {
		ArrayList<ConstructorDeclaration> var=new ArrayList<ConstructorDeclaration>(0);
		ConstructorDeclaration cd=getConstructorDeclaration();
		while(cd!=null){
			var.add(cd);
			cd=getConstructorDeclaration();
		}
		return var;
	}
 
 	public ConstructorDeclaration getConstructorDeclaration(){
 		Identifier id=new Identifier();
 		MethodTypeIDs mt=new MethodTypeIDs();
 		ArrayList<VarDeclaration> vd = new ArrayList<VarDeclaration>(0);
 		ArrayList<Statement> s = new ArrayList<Statement>(0);
 		id = getIdentifier();
		if(id == null)
		{
			//System.out.println("Syntax Error on Identifier");
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
					/*if(vd.size() == 0)
					{
						System.out.println("Syntax Error on VarDeclaration");
						return null;
					}*/
					s=getStatements();
					/*if(s == null)
					{
						System.out.println("Syntax Error on statements");
						return null;
					}*/
					if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
					{
						tokens.poll();
						return new ConstructorDeclaration(id,mt,vd,s);
					}
				}
				
			}
			
		}
		return null;
 	}

	public ArrayList<VarDeclaration> getVarDeclarations() {
		ArrayList<VarDeclaration> var=new ArrayList<VarDeclaration>(0);
		VarDeclaration vd=getVarDeclaration();
		while(vd!=null){
			var.add(vd);
			vd=getVarDeclaration();
		}
		return var;
	}
	
	public VarDeclaration getVarDeclaration(){
 		Type t;
 		Identifier id=new Identifier();
 		t = getType();
 		boolean check = false;
		if(t == null)
		{
			//System.out.println("Syntax Error on TypeVarDeclaration");
			return null;
		}
		id = getIdentifier();
		if(id == null)
		{
			System.out.println("Syntax Error on IdentifierVarDeclaration " + id + " in Var Declaration");
			return null;
		}
		if(tokens.peek().getType().equals("SEMICOLON")){
			tokens.poll();
			return new VarDeclaration(t,id);
		}
		else check=true;

		if(check){System.out.println("Syntax Error on VarDeclaration");}
		return null;
 	}
	
	public ArrayList<Statement> getStatements() {
		ArrayList<Statement> var=new ArrayList<Statement>(0);
		Statement s=getStatement();
		while(s!=null){
			var.add(s);
			s=getStatement();
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
				System.out.println("Syntax Error on Identifier" + id.getValue() + "in ExtendsID");
				return null;
			}
			return new ExtendsID(id);
		}
		id.id="false";
		return new ExtendsID(id);
	}
	
	public ArrayList<TypeIdentifier> getTypeIdentifiers() {
		ArrayList<TypeIdentifier> var=new ArrayList<TypeIdentifier>(0);
		if(tokens.peek().getType().equals("COMMA")){
			tokens.poll();
		TypeIdentifier td=getTypeIdentifier();
		if(td==null){
			System.out.println("Syntax 	Error in Type Identifier After Comma ");
		}
		while(td!=null){
			
			var.add(td);
			if(tokens.peek().getType().equals("COMMA")){
				tokens.poll();
			 td=getTypeIdentifier();
			 if(td==null){
					System.out.println("Syntax 	Error in Type Identifier After Comma ");
				}
			}
			else break;
		}
		}
		return var;
	}

	public TypeIdentifier getTypeIdentifier() {
		Type t;
		Identifier id=new Identifier();
		t=getType();
		if(t==null){
			//System.out.println("Syntax Error on identifier in type");
			return null;
		}
		id=getIdentifier();
		if(id==null){
			System.out.println("Syntax Error on identifier "+ id.getValue() +" in getTypeIdentifier");
			return null;
		}
		return new TypeIdentifier(t,id);
	}
			
	public Statement getStatement()
	{	
		ArrayList<Statement> statements=new <Statement> ArrayList(0);
		Expression exp;
		Statement stm;
		StatementDash stmdash;
		Identifier id;
		StatementIdentifierDash stmid;
		if(tokens.peek().getType().equals("LEFT_CURLY_B"))
		{
			tokens.poll();							
			statements = getStatements();
			if(statements == null)
			{
				System.out.println("Syntax Error on OneOrMoreStatement");
				return null;
			}
			if(tokens.peek().getType().equals("RIGHT_CURLY_B"))
			{
				tokens.poll();
				return new StatementOrMore(statements);
			}
			else
			{
				System.out.println("Syntax Error on Right Curly Bracket '}' in getStatements");
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
					System.out.println("Syntax Error on IfExpressionOfStatement");
					return null;
				}
				if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
				{
					tokens.poll();
					stm = getStatement();
					if(stm == null)
					{
						System.out.println("Syntax Error on IfStatement");
						return null;
					}
					stmdash = getStatementDash();
					if(stmdash == null)
					{
						System.out.println("Syntax Error on IfStatementDash");
						return null;
					}
					return new StatementIfStatmentDash(exp,stm,stmdash);
				}
				else
				{
					System.out.println("Syntax Error on Right Round Bracket ')' in getStatements");

				}
			}
			else
			{
				System.out.println("Syntax Error on Left Round Bracket '(' in getStatements");
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
					System.out.println("Syntax Error on WhileExpressionOfStatement");
					return null;
				}
				if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
				{
					tokens.poll();
					stm = getStatement();
					if(stm == null)
					{
						System.out.println("Syntax Error on WhileStatement");
						return null;
					}
					return new StatementWhileExp(exp,stm);
				}
				else
				{
					System.out.println("Syntax Error on Right Round Bracket ')' in getStatements");
				}
			}
			else
			{
				System.out.println("Syntax Error on Left Round Bracket '(' in getStatements");
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
					System.out.println("Syntax Error on SysoExpressionOfStatement");
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
				else
				{
					System.out.println("Syntax Error on Right Round Bracket ')' in getStatements");
				}
			}
			else
			{
				System.out.println("Syntax Error on Left Round Bracket '(' in getStatements");
			}
		}
		else if(tokens.peek().getType().equals("ID"))
		{
			id = getIdentifier();
			if(id == null)
			{
				System.out.println("Syntax Error on IdentifierOfStatement");
				return null;
			}
			stmid = getStatementIdentifierDash();
			if(stmid == null)
			{
				System.out.println("Syntax Error on StatementDashIdentifier");
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
				System.out.println("Syntax Error on StatementElseStatement");
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
		if(tokens.peek().getType().equals("ASSIGNMENT"))
		{
			tokens.poll();
			exp1 = getExpression();
			if(exp1 == null)
			{
				System.out.println("Syntax Error on EqualExpressionofStatementIdentifier");
				return null;
			}
			if(tokens.peek().getType().equals("SEMICOLON"))
			{
				tokens.poll();
				return new StatementIdentifierDashEqExp(exp1);
			}
			else
			{
				System.out.println("Syntax Error onSemicolon ';' in getStatementIdentifierDash");
			}
		}
		else if(tokens.peek().getType().equals("LEFT_SQUARE_B"))
		{
			tokens.poll();
			exp1 = getExpression();
			if(exp1 == null)
			{
				System.out.println("Syntax Error on LeftSquareExpressionofStatementIdentifierDash");
				return null;
			}
			if(tokens.peek().getType().equals("RIGHT_SQUARE_B"))
			{
				tokens.poll();
				if(tokens.peek().getType().equals("ASSIGNMENT"))
				{
					tokens.poll();
					exp2 = getExpression();
					if(exp2 == null)
					{
						System.out.println("Syntax Error on ExpressionofStatementIdentifierDash");
						return null;
					}
					if(tokens.peek().getType().equals("SEMICOLON"))
					{
						tokens.poll();
						return new StatementIdentifierDashSquareBracket(exp1,exp2);
					}
					else
					{
						System.out.println("Syntax Error on Semicolon ';' in getStatementIdentifierDash");
					}
				}
				else
				{
					System.out.println("Syntax Error on Assignment Operator '=' in getStatementIdentifierDash");
				}
			}
			else
			{
				System.out.println("Syntax Error on Right Square Bracket '[' in getStatementIdentifierDash");
			}
		}
		return null;
	}
	
	public Expression getExpression()
	{
		ExpressionDash expDash;
		if(tokens.peek().getType().equals("INTEGER_LITERAL"))
		{
			String intLiteral = tokens.poll().getValue();
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on IntegerLiteralExpressionDash");
				return null;
			}
			return new ExpressionLiterals(intLiteral,expDash);
		}
		else if(tokens.peek().getType().equals("FLOAT_LITERAL"))
		{
			String floatLiteral = tokens.poll().getValue();
		
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on FloatLiteralExpressionDash");
				return null;
			}
			return new ExpressionLiterals(floatLiteral,expDash);
		}
		else if(tokens.peek().getType().equals("STRING_LITERAL"))
		{
			String stringLiteral = tokens.poll().getValue();
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on StringLiteralExpressionDash");
				return null;
			}
			return new ExpressionLiterals(stringLiteral,expDash);
		}
		else if(tokens.peek().getType().equals("TRUE") || tokens.peek().getType().equals("FALSE"))
		{
			String bool = tokens.poll().getValue();
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on BooleanExpressionDash");
				return null;
			}
			return new ExpressionBoolean(bool,expDash);
		}
		else if(tokens.peek().getType().equals("ID"))
		{
			Identifier expID = getIdentifier();
			if(expID == null)
			{
				System.out.println("Syntax Error on ExpressionIdentifier");
				return null;
			}
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on ExpresisonDashIdentifier");
				return null;
			}
			return new ExpressionIdentifier(expID,expDash);
		}
		else if(tokens.peek().getType().equals("THIS"))
		{
			tokens.poll();
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on ThisExpresisonDash");
				return null;
			}
			return new ExpressionThis(expDash);
		}
		else if(tokens.peek().getType().equals("NEW"))
		{
			tokens.poll();
			ExpressionNewDash expNewDash = getExpressionNewDash();
			if(expNewDash == null)
			{
				System.out.println("Syntax Error on NewExpression");
				return null;
			}
			return new ExpressionNew(expNewDash);
		}
		else if(tokens.peek().getType().equals("NOT"))
		{
			tokens.poll();
			Expression notExp = getExpression();
			if(notExp == null)
			{
				System.out.println("Syntax Error on NotExpresison");
				return null;
			}
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on NotExpresisonDash");
				return null;
			}
			return new ExpressionNot(notExp,expDash);
		}
		else if(tokens.peek().getType().equals("LEFT_ROUND_B"))
		{
			tokens.poll();
			Expression leftBracketExp = getExpression();
			if(leftBracketExp == null)
			{
				System.out.println("Syntax Error on LeftBracketExpresison");
				return null;
			}
			if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
			{
				tokens.poll();
				expDash = getExpressionDash();
				if(expDash == null)
				{
					System.out.println("Syntax Error on LeftBracketExpresisonDash");
					return null;
				}
				return new ExpressionLeftBracket(leftBracketExp,expDash);
			}
			else
			{
				System.out.println("Syntax Error on Right Round Bracket ')' in getExpression");
			}
		}
		//System.out.println("Syntax Error on Major Expression");
		return null;
	}
	
	public ExpressionDash getExpressionDash()
	{
		ExpressionDash expDash;
		if(tokens.peek().getType().equals("AND") ||
		   tokens.peek().getType().equals("OR")||
		   tokens.peek().getType().equals("EQUAL")||
		   tokens.peek().getType().equals("NOT_EQUAL")||
		   tokens.peek().getType().equals("GREATERTHAN")||
		   tokens.peek().getType().equals("LESSTHAN")||
		   tokens.peek().getType().equals("GREATER_EQ")||
		   tokens.peek().getType().equals("LESS_EQ")||
		   tokens.peek().getType().equals("PLUS")||
		   tokens.peek().getType().equals("MINUS")||
		   tokens.peek().getType().equals("MULTIPLY")||
		   tokens.peek().getType().equals("DIV"))
		{
			String operator = tokens.poll().getValue();
			Expression opExp = getExpression();
			if(opExp == null)
			{
				System.out.println("Syntax Error on OperatorExpression");
				return null;
			}
			expDash =  getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on OperatorExpressionDash");
				return null;
			}
			return new ExpressionDashOperators(operator, opExp, expDash);			
		}
		else if(tokens.peek().getType().equals("LEFT_SQUARE_B"))
		{
			tokens.poll();
			Expression leftSqExp = getExpression();
			if(leftSqExp == null)
			{
				System.out.println("Syntax Error on LeftSquareBExpression");
				return null;
			}
			if(tokens.peek().getType().equals("RIGHT_SQUARE_B"))
			{
				tokens.poll();
				expDash =  getExpressionDash();
				if(expDash == null)
				{
					System.out.println("Syntax Error on LeftSquareBExpressionDash");
					return null;
				}
				return new ExpressionDashLeftSquare(leftSqExp, expDash);
			}
			else
			{
				System.out.println("Syntax Error on Right Square Bracket ']' in getExpressionDash");
			}
		}
		else if(tokens.peek().getType().equals("DOT"))
		{
			tokens.poll();
			ExpressionDotDash expDotDash = getExpressionDotDash();
			if(expDotDash == null)
			{
				System.out.println("Syntax Error on DotExpressionDash");
				return null;
			}
			return new ExpressionDashDotExp(expDotDash);
		}
		else
		{
			//Lamda
			return new ExpressionDashLamda();
		}
		System.out.println("Syntax Error on ExpressionDash");
		return null;
	}
	
	public 	ExpressionNewDash getExpressionNewDash()
	{
		ExpressionDash expDash;
		if(tokens.peek().getType().equals("INT") ||
		   tokens.peek().getType().equals("FLOAT")||
		   tokens.peek().getType().equals("STRING")||
		   tokens.peek().getType().equals("CHARACTER")||
		   tokens.peek().getType().equals("BOOLEAN"))
		{
			String dataType = tokens.poll().getValue();
			if(tokens.peek().getType().equals("LEFT_SQUARE_B"))
			{	
				tokens.poll();
				Expression dataTypeExp = getExpression();
				if(dataTypeExp == null)
				{
					System.out.println("Syntax Error on DataTypeExpressionNewDash");
					return null;
				}
				if(tokens.peek().getType().equals("RIGHT_SQUARE_B"))
				{
					tokens.poll();
					expDash = getExpressionDash();
					if(expDash == null)
					{
						System.out.println("Syntax Error on DataTypeExpressionDash");
						return null;
					}
					return new ExpressionNewDashDataType(dataType,dataTypeExp,expDash);
				}
				else
				{
					System.out.println("Syntax Error on Right Square Bracket ']' in getExpressionNewDash");
				}
			}
		}
		else if(tokens.peek().getType().equals("ID"))
		{
			Identifier expNewID = getIdentifier();
			if(tokens.peek().getType().equals("LEFT_ROUND_B"))
			{
				tokens.poll();
				ManyExpressions exps = getManyExpressions();
			/*	if(exps == null)
				{
					System.out.println("Syntax Error on ManyExpressionsNewDashIdentifier");
					return null;
				}*/
					if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
					{
						tokens.poll();
						expDash = getExpressionDash();
						if(expDash == null)
						{
							System.out.println("Syntax Error on IdentifierExpressionNewDash");
							return null;
						}
						return new ExpressionNewDashIdentifier(expNewID,exps,expDash);
					}
					else
					{
						System.out.println("Syntax Error on Right Round Bracket ')' in getExpression");
					}
				}
			else
			{
				System.out.println("Syntax Error on Left Round Bracket '(' in getExpressionNewDash");
			}
			}
		System.out.println("Syntax Error on ExpressionNewDash");
		return null;
	}
	
	public ManyExpressions getManyExpressions()
	{
		Expression exp = getExpression();
		if(exp == null)
		{
			//System.out.println("check manyexps");
			return null;
		}
		ArrayList<Expression> exps = getExpressions();
		return new ManyExpressions(exp,exps);
	}
		
	public ArrayList<Expression> getExpressions()
	{
		ArrayList<Expression> expArray = new ArrayList<Expression>();
		if(tokens.peek().getType().equals("COMMA"))
		{
			tokens.poll();
			Expression exp = getExpression();
			while(exp != null)
			{
				expArray.add(exp);
				if(tokens.peek().getType().equals("COMMA"))
				{
					tokens.poll();
					exp=getExpression();
				}
				else
				{
						System.out.println("Syntax Error on Comma ',' in getExpressions");
						return expArray;
				}
			}
		}
		else
		{
			System.out.println("Syntax Error on Comma ',' in getExpressions");
		}
		return expArray;
	}
	
	public ExpressionDotDash getExpressionDotDash()
	{
		ExpressionDash expDash;
		if(tokens.peek().getType().equals("LENGTH"))
		{
			
			tokens.poll();
			expDash = getExpressionDash();
			if(expDash == null)
			{
				System.out.println("Syntax Error on LengthExpressionDotDash");
				return null;
			}
			return new ExpressionDotDashLength(expDash);
		}
		else if(tokens.peek().getType().equals("ID"))
		{
			Identifier expDotID = getIdentifier();
			if(tokens.peek().getType().equals("LEFT_ROUND_B"))
			{
				tokens.poll();
				ManyExpressions exps = getManyExpressions();
				/*if(exps == null)
				{
					System.out.println("Syntax Error on ManyExpressionsDotDashIdentifier");
					return null;
				}*/
					if(tokens.peek().getType().equals("RIGHT_ROUND_B"))
					{
						tokens.poll();
						expDash = getExpressionDash();
						if(expDash == null)
						{
							System.out.println("Syntax Error on IdentifierExpressionDotDash");
							return null;
						}
						return new ExpressionDotDashIdentifier(expDotID,exps,expDash);
					}
			}
		}
		System.out.println("Syntax Error on ExpressionDotDash");
		return null;
	}
	
	public Type getType()
	{
		if(tokens.peek().getType().equals("INT") ||
		   tokens.peek().getType().equals("FLOAT")||
		   tokens.peek().getType().equals("STRING")||
		   tokens.peek().getType().equals("CHARACTER")||
		   tokens.peek().getType().equals("BOOLEAN"))
		{
		   String dataType = tokens.poll().getValue();
		   TypeDash typeDash = getTypeDash();
		   if(typeDash == null)
		   {
				System.out.println("Syntax Error on TypeDashDataType");
				return null;
		   }
		   return new TypeDataType(dataType,typeDash);
		}
		//System.out.println("Syntax Error on Type");
		return null;
	}
	
	public TypeDash getTypeDash()
	{
		if(tokens.peek().getType().equals("LEFT_SQUARE_B"))
		{
			tokens.poll();
			if(tokens.peek().getType().equals("RIGHT_SQUARE_B"))
			{
				tokens.poll();
				return new TypeDashBrackets();
			}
			else
			{
				System.out.println("Syntax Error on Right Sqaure Bracker '}' in getTypeDash");
			}
		}
		else
		{
			//Lamda
			return new TypeDashLamda();
		}
		System.out.println("Syntax Error on TypeDash");
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
	
	public static void main(String[] args) 
	{
		Parser p = new Parser("input.txt");
		Goal root = p.parse();
		if(root!=null)System.out.println(root.getValue());
	}

}