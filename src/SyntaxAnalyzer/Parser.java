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
		return null;
	}
	
}
	
