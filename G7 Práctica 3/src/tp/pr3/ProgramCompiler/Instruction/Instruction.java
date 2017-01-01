package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.LexicalParser;
/**
 * Interfaz con la que representamos las instrucciones del c�digo.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @verison 30/12/2016
 */
public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexParser);
	void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException;
}
