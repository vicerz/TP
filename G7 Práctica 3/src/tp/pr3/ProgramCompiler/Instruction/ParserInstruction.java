package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.Exception.LexicalAnalysisException;
import tp.pr3.ProgramCompiler.LexicalParser;
/**
 * Clase que se encarga del parseo de las instrucciones del c�digo.
 * @author Carlos Moreno Morera
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class ParserInstruction {
	final static int LONG_MAX_INSTRUCTION = 5;
	
	private final static Instruction[] instructions = {
		new SimpleAssignment(), new CompoundAssignment(), new IfThen(),
		new While(), new Return(), new Write(),
	};
	/**
	 * M�todo encargado del parseo de las instrucciones.
	 * @param line: l�nea de c�digo introducida.
	 * @param parser
	 * @return Instruction dependiendo de la instrucci�n de la que se trate.
	 * @throws LexicalAnalysisException si no coincide con ninguna instrucci�n conocida.
	 */
	public static Instruction parse(String line, LexicalParser parser)
				throws LexicalAnalysisException{
		String[] s = line.split(" ");
		if (s.length > LONG_MAX_INSTRUCTION) throw new LexicalAnalysisException();
		else{
			Instruction instr = null;
			int i = 0;
			boolean encontrado = false;
			
			while (i < instructions.length && !encontrado){
				instr = instructions[i].lexParse(s, parser);
				if (instr != null) encontrado = true;
				++i;
			}
			if (!encontrado) throw new LexicalAnalysisException();
			return instr;
		}
	}
}
