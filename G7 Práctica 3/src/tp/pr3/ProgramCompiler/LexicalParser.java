package tp.pr3.ProgramCompiler;

public class LexicalParser {
	private SourceProgram sProgam;
	private int programCounter;
	
	public void lexicalParser(ParsedProgram pProgram, String stopKey)
			throws LexicalAnalysisException{
		//algo antes
		
		while (this.programCounter < sProgram.getNumeroInstrucciones()&&...){
			String instr = sProgram.getInstruction(this.programCounter);
			if (instr.equalsIgnoreCase(stopKey)){
				stop = true;
			}
			else {
				Instruction instruction = ParserInstruction.parse(instr,this);
			//A�adir instruccion a pProgram
			}
		}
		//algo despu�s
	}
	public void increaseProgramCounter(){
		this.programCounter++;
	}
}
