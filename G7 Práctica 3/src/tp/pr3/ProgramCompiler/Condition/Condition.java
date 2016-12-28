package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ByteCode.ConditionalJumps.ConditionalJumps;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.Term;

public abstract class Condition {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition; //para la compilación
	
	abstract public Condition parse(String t1, String op, String t2,
			LexicalParser parser);
	abstract public void compile(Compiler compiler) throws ArrayException;
	//Otros métodos abstractos
}