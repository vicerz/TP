package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.*;

public class Variable implements Term {
	private String varName;
	
	public Variable(){
		this.varName = "";
	}
	public Variable(String s){
		this.varName = s;
	}
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
		return new Load(compiler.getIndex(this.varName));
	}
	public String toString(){
		return this.varName;
	}
}
