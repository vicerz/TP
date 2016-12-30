package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.Halt;
import tp.pr3.Exception.ArrayException;
import tp.pr3.ProgramCompiler.LexicalParser;

public class Return implements Instruction{
	final int LENGTH_INSTRUCTION = 1;
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if(words.length != LENGTH_INSTRUCTION 
				|| !words[0].equalsIgnoreCase("RETURN")) return null;
		else return new Return();
	}
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException{
		try{
			compiler.addByteCode(new Halt());
		}
		catch (ArrayException e){
			
		}
	}
}
