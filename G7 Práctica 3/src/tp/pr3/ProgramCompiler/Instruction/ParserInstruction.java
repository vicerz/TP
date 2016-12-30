package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ProgramCompiler.LexicalParser;

public class ParserInstruction {
	final static int LONG_MAX_INSTRUCTION = 5;
	private final static Instruction[] instructions = {
		new SimpleAssignment(), new CompoundAssignment(), new IfThen(),
		new While(), new Return(), new Write(),
	};
	
	public static Instruction parse(String line, LexicalParser parser){
		String[] s = line.split(" ");
		if (s.length > LONG_MAX_INSTRUCTION) return null;
		else{
			Instruction instr = null;
			int i = 0;
			boolean encontrado = false;
			
			while (i < instructions.length && !encontrado){
				instr = instructions[i].lexParse(s, parser);
				if (instr != null) encontrado = true;
				++i;
			}
			return instr;
		}
	}
}
