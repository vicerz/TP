package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.Exception.ArrayException;
import tp.pr3.ProgramCompiler.LexicalParser;

public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexParser);
	void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException;
}
