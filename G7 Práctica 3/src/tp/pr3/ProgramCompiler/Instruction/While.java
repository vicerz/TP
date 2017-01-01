package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.GoTo;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.*;
import tp.pr3.ProgramCompiler.Condition.*;

public class While implements Instruction{
	Condition condition;
	ParsedProgram whileBody;
	
	final int NUMCOMPONENTES = 4;
	
	public While(){ }
	public While(Condition cnd, ParsedProgram wBody){
		this.condition = cnd;
		this.whileBody = wBody;
	}
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if (words.length != NUMCOMPONENTES || 
				!words[0].equalsIgnoreCase("WHILE")) return null;
		else {
			Condition cnd = ConditionParser.parse(words[1], words[2], 
					words[3], lexParser);
			
			if (cnd == null) return null;
			else{
				ParsedProgram wBody = new ParsedProgram();
				try{
					lexParser.lexicalParser(wBody, "ENDWHILE");
					lexParser.increaseProgramCounter();
					return new While(cnd, wBody);
				}
				catch(LexicalAnalysisException e){
					System.out.println(e + "Error en la l�nea: " + 
							lexParser.getProgramCounter());
					System.out.println("No se ha podido compilar el programa");
					
					return null;
				}
			}
		}
	}
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException{
		try{
			int pc1 = compiler.getProgramCounter();
			this.condition.compile(compiler);
			compiler.compile(this.whileBody);
			this.condition.setJump(compiler.getProgramCounter());
			compiler.addByteCode(new GoTo(pc1));
		}
		catch (ArrayException e){
			
		}
	}
}
