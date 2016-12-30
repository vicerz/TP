package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.*;
import tp.pr3.Exception.ArrayException;
import tp.pr3.ProgramCompiler.LexicalParser;

public class Write implements Instruction{
	private String varName;
	
	final int LENGTH_INSTRUCTION = 2;
	public Write(){
		this.varName = "";
	}
	public Write(String var_name){
		this.varName = var_name;
	}
	public Instruction lexParse(String[] words, LexicalParser lexParser){
		if (words.length != LENGTH_INSTRUCTION 
				|| !words[0].equalsIgnoreCase("WRITE")) return null;
		else return new Write(words[1]);
	}
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler) throws ArrayException{
		try{
			ByteCode bc = new Load(compiler.getIndex(this.varName));
			compiler.addByteCode(bc);
			compiler.addByteCode(new Out());
		}
		catch (ArrayException e){
			
		}
	}
}
