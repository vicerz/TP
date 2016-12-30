package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.Term;

public class Equal extends Condition{
	public Equal(){
		super();
	}
	public Equal(Term t1, Term t2){
		super(t1,t2);
	}
	public Condition parseAux(Term t1, String op, Term t2,
			LexicalParser parser){
		if (op.equals("==")) return new Equal(t1, t2);
		else return null;
	}
}
