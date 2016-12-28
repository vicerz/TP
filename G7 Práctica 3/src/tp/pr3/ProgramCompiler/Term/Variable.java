package tp.pr3.ProgramCompiler.Term;

public class Variable implements Term {
	private String varName;
	@Override
	public Term parse(String term) {
		if (term.length() != 1) return null;
		else {
			char name = term.charAt(0);
			if ('a' <= name && name <= 'z') return new Variable(term);
			else return null;
		}
		
	}	
	@Override
	public ByteCode compile(Compiler compiler){
			
	}
	public String toString(){
		return this.varName;
	}
}
