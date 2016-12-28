package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.*;

public class SimpleAssignment implements Instruction{
	private String var_name;
	private Term rhs;
	
	final int NUMCOMPONENTES = 3;
	Instruction lexParse(String[] words, LexicalParser lexparser){
		char name = words[0].charAt(0);
		char op = words[1].charAt(0);
		if (words.length != NUMCOMPONENTES || name < 'a' || name > 'z'
				|| op != '=') return null;
		else{
			Term term = TermParser.parse(words[2]);
			lexparser.increaseProgramCounter();
		}
	}
	void compile(Compiler compiler) throws ...{
		
	}
}