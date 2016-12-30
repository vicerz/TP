package tp.pr3.ProgramCompiler.Term;

import tp.pr3.ByteCode.*;

public class Number implements Term{
	private int value;
	
	public Number(){
		this.value = 0;
	}
	public Number(int n){
		this.value = n;
	}
	public Term parse(String term){
		try{
			return StringToInt(term);
		}
		catch(NumberFormatException e){
			return null;
		}
	}
	private Term StringToInt(String term) throws NumberFormatException{
		return new Number(Integer.parseInt(term));
	}
	public ByteCode compile(tp.pr3.ProgramCompiler.Compiler compiler){
		return new Push(this.value);
	}
	public String toString(){
		return Integer.toString(this.value);
	}
}
