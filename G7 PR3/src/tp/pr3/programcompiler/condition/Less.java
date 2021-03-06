package tp.pr3.programcompiler.condition;

import tp.pr3.bytecode.conditionaljumps.*;
import tp.pr3.programcompiler.LexicalParser;
import tp.pr3.programcompiler.term.*;
/**
 * Clase que implementa la condici�n menor.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 *
 */
public class Less extends Condition{
	/**
	 * Constructores de la clase.
	 */
	public Less(){
		super();
	}
	public Less(Term t1, Term t2){
		super(t1,t2);
	}
	/**
	 * M�todo encargado del parseo de esta condici�n.
	 * @param t1
	 * @param op
	 * @param t2
	 * @param parser
	 * @return Condition en funci�n de si coincide con esta condici�n.
	 */
	public Condition parseAux(Term t1, String op, Term t2,
			LexicalParser parser){
		if (op.equals("<")) return new Less(t1, t2);
		else return null;
	}
	/**
	 * M�todo que compila esta condici�n.
	 * @return ConditionalJumps en funci�n de esta condici�n.
	 */
	public ConditionalJumps compileAux(){
		return new IfLe();
	}
	/**
	 * M�todo que genera un String de la condici�n.
	 */
	public String toString(){
		String s = "<";
		return s;
	}
}
