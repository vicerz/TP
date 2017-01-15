package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ByteCode.ConditionalJumps.*;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.Term;
/**
 * M�todo que implementa la condici�n menor o igual.
 * @author Carlos Moreno
 * @version 15/01/2017
 */
public class LessEq extends Condition{
	/**
	 * Constructores de la clase.
	 */
	public LessEq(){
		super();
	}
	public LessEq(Term t1, Term t2){
		super(t1,t2);
	}
	/**
	 * M�todo encargado de parsear esta condici�n.
	 * @param t1
	 * @param op
	 * @param t2
	 * @param parser
	 * @return Condition en funci�n de si coincide con esta condici�n.
	 */
	public Condition parseAux(Term t1, String op, Term t2,
			LexicalParser parser){
		if (op.equals("<=")) return new LessEq(t1, t2);
		else return null;
	}
	/**
	 * M�todo que compila esta condici�n.
	 * @return ConditionalJumps de acuerdo con esta condici�n.
	 */
	public ConditionalJumps compileAux(){
		return new IfLeq();
	}
	/**
	 * M�todo que genera un String de la condici�n.
	 */
	public String toString(){
		String s = "<=";
		return s;
	}
}
