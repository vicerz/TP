package tp.pr3.ProgramCompiler;

public class SourceProgram {
	final int TAM_INI = 100;
	
	private String[] sProgram;
	private int numInstruc;
	private int tam;
	
	public SourceProgram(){
		this.sProgram = new String[TAM_INI];
		this.numInstruc = 0;
		this.tam = TAM_INI;
	}
	public void cargarInst(String s){
		if (this.numInstruc == this.tam) this.resize();
		
		this.sProgram[this.numInstruc] = s;
		++this.numInstruc;
	}
	public void resize(){
		int newtam = 2*this.tam;
		String[] newsProgram = new String[newtam];
		
		for (int i = 0; i < this.tam; ++i){
			newsProgram[i] = this.sProgram[i];
		}
		this.sProgram = newsProgram;
		this.tam = newtam;
	}
	public int getNumeroInstrucciones(){
		return this.numInstruc;
	}
	public String getInstructionAt(int n){
		if (n >= 0 && n < this.numInstruc) return this.sProgram[n];
		else return null;
	}
}
