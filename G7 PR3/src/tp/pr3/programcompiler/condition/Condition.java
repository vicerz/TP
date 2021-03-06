package tp.pr3.programcompiler.condition;

import tp.pr3.bytecode.conditionaljumps.ConditionalJumps;
import tp.pr3.exception.*;
import tp.pr3.programcompiler.LexicalParser;
import tp.pr3.programcompiler.term.*;
/**
 * Clase abstracta que implementa las condiciones de las instrucciones IfThen y While.
 * 
 * De ella heradan las clases Equal, Less, LessEq y NotEqual.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public abstract class Condition {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition;
	
	final int TAM_MAX_CONDITION = 2;
	/**
	 * Constructores de la clase.
	 */
	public Condition(){	}
	public Condition(Term term1, Term term2){
		this.t1 = term1;
		this.t2 = term2;
	}
	/**
	 * M�todo que parsea la condici�n.
	 * @param t1: primer t�rmino a parsear.
	 * @param op: operador booleano a parsear.
	 * @param t2: segundo t�rmino a parsear.
	 * @param parser
	 * @return Condition en funci�n de la condici�n introducida por el usuario.
	 */
	public Condition parse(String t1, String op, String t2,
			LexicalParser parser){
		if (op.length() > TAM_MAX_CONDITION) return null;
		
		Term term1 = TermParser.parse(t1);
		Term term2 = TermParser.parse(t2);
		
		if (term1 == null || term2 == null) return null;

		return parseAux(term1, op, term2, parser);
	}
	/**
	 * M�todo abstracto que parsea la condici�n concreta.
	 * @param t1
	 * @param op
	 * @param t2
	 * @param parser
	 * @return Condition en funci�n de la condici�n introducida por el usuario.
	 */
	abstract public Condition parseAux(Term t1, String op, Term t2,
			LexicalParser parser);
	/**
	 * M�todo que compila la condici�n.
	 * @param compiler
	 * @throws ArrayException
	 * @throws NonexistentVariable 
	 */
	public void compile(tp.pr3.programcompiler.Compiler compiler)
			throws ArrayException, NonexistentVariable{
		
		compiler.addByteCode(this.t1.compile(compiler));
		compiler.addByteCode(this.t2.compile(compiler));
		this.condition = compileAux();
		compiler.addByteCode(this.condition);
	}
	/**
	 * M�todo que fija la instrucci�n a la que se va a saltar en caso de que
	 * no se cumpla la condici�n.
	 * @param n: instrucci�n a saltar.
	 */
	public void setJump(int n){
		this.condition.setPos(n);
	}
	/**
	 * M�todo que genera un String de la condici�n.
	 */
	public String toString(){
		String s = this.t1.toString() + ' ' + toString() + ' ' + this.t2.toString();
		return s;
	}
	/**
	 * M�todo abstracto que compila la condici�n concreta.
	 * @return ConditionalJumps en funci�n de la condici�n dada.
	 */
	abstract public ConditionalJumps compileAux();
}