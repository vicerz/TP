package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ProgramCompiler.*;
import tp.pr3.ProgramCompiler.Condition.*;
/**
 * Clase que implementa la instrucci�n IfThen.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 *
 */
public class IfThen implements Instruction{
	Condition condition;
	ParsedProgram ifThenBody;
	
	final int NUMCOMPONENTES = 4;
	
	public IfThen(){ }
	public IfThen(Condition cnd, ParsedProgram iBody){
		this.condition = cnd;
		this.ifThenBody = iBody;
	}
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if (words.length != NUMCOMPONENTES || 
				!words[0].equalsIgnoreCase("IF")) return null;
		else {
			Condition cnd = ConditionParser.parse(words[1], words[2], 
					words[3], lexParser);
			
			if (cnd == null) return null;
			else{
				ParsedProgram iBody = new ParsedProgram();
				lexParser.lexicalParser(iBody, "ENDIF");
				lexParser.increaseProgramCounter();
				return new IfThen(cnd, iBody);
			}
		}
	}
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler){
		this.condition.compile(compiler);
		compiler.compile(this.ifThenBody);
		this.condition.setJump(compiler.getProgramCounter());
	}
}
