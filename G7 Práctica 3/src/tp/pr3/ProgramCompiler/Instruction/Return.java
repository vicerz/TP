package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.Halt;
import tp.pr3.Exception.ArrayException;
import tp.pr3.ProgramCompiler.LexicalParser;
/**
 * Clase que implementa la instrucci�n Return.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public class Return implements Instruction{
	final int LENGTH_INSTRUCTION = 1;
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexParser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n de esta clase.
	 */
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if(words.length != LENGTH_INSTRUCTION 
				|| !words[0].equalsIgnoreCase("RETURN")) return null;

		lexParser.increaseProgramCounter();
		return new Return();
	}
	/**
	 * M�todo que compila la instrucci�n.
	 * @param compiler
	 * @throws ArrayException
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException{
		compiler.addByteCode(new Halt());
	}
	/**
	 * M�todo que genera un String de la instrucci�n.
	 */
	public String toString(){
		String s = "return";
		return s;
	}
}
