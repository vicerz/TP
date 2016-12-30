package tp.pr3.ProgramCompiler;

import tp.pr3.ByteCode.*;

public class Compiler {
	private ByteCodeProgram bytecode;
	private String[] varTable;
	private int numVars;
	
	public void compile(ParsedProgram pProgram) throws � {
		int i = 0;
		try {
			while (i < pProgram.getNumeroInstrucciones()){
				Instruction inst = pProgram.getInstruction(i);
				instr.compile(this);
				++i;
			}
		}
		catch (...){
			
		}
	}
	public void addByteCode(ByteCode b) throws � {
		
	}
	public int getIndex(String varName) {
		int i = 0;
		boolean encontrado = false;
		
		while (i < this.numVars && !encontrado){
			if (this.varTable[i].equals(varName)) encontrado = true;
			else ++i;
		}
		return i;
	}
}
