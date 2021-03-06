package tp.pr3.programcompiler.term;

import tp.pr3.bytecode.*;
/**
 * Clase que implementa los t�rminos num�ricos que aparecen en el c�digo.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Number implements Term{
	private int value;
	/**
	 * Constructores de la clase.
	 */
	public Number(){
		this.value = 0;
	}
	public Number(int n){
		this.value = n;
	}
	/**
	 * M�todo que parsea el t�rmino dado.
	 * @param term: t�rmino dado a parsear.
	 * @return Term dependiendo si el t�rmino introducido en 
	 * el programa es n�merico.
	 */
	public Term parse(String term){
		try{
			return new Number(Integer.parseInt(term));
		}
		catch(NumberFormatException e){
			return null;
		}
	}
	/**
	 * M�todo que compila el t�rmino num�rico.
	 * @param compiler
	 * @return Bytecode en el que se traduce el t�rmino.
	 */
	public ByteCode compile(tp.pr3.programcompiler.Compiler compiler){
		return new Push(this.value);
	}
	/**
	 * M�todo que pasa a un String esta clase.
	 */
	public String toString(){
		return Integer.toString(this.value);
	}
}
