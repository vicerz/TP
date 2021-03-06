package tp.pr3.programcompiler.instruction;

import tp.pr3.bytecode.*;
import tp.pr3.exception.*;
import tp.pr3.programcompiler.LexicalParser;
import tp.pr3.programcompiler.term.*;
/**
 * Clase que implementa la instrucci�n SimpleAssignment.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 15/01/2017
 */
public class SimpleAssignment implements Instruction{
	private String var_name;
	private Term rhs;
	
	final int NUMCOMPONENTES = 3;
	/**
	 * Constructores de la clase.
	 */
	public SimpleAssignment(){
		this.var_name = "";
	}
	public SimpleAssignment(String varName, Term term){
		this.var_name = varName;
		this.rhs = term;
	}
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexparser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n de esta clase.
	 */
	public Instruction lexParse(String[] words, LexicalParser lexparser){
		if (words.length != NUMCOMPONENTES || !words[1].equals("=") || 
				words[0].length() != 1) return null;
		
		char var = words[0].charAt(0);
		if (var < 'a' || var > 'z') return null;
		
		Term term = TermParser.parse(words[2]);
		if (term == null) return null;

		lexparser.increaseProgramCounter();
		return new SimpleAssignment(words[0], term);
	}
	/**
	 * M�todo que compila la instrucci�n.
	 * @param compiler
	 * @throws ArrayException
	 * @throws VariableTableOverflow
	 * @throws NonexistentVariable 
	 */
	public void compile(tp.pr3.programcompiler.Compiler compiler) 
			throws ArrayException, VariableTableOverflow, NonexistentVariable{
		
		compiler.addByteCode(this.rhs.compile(compiler));
		int index = 0;
		try{
			index = compiler.getIndex(this.var_name);
		}
		catch(NonexistentVariable e){
			index = compiler.addVar(this.var_name);
		}
		finally{
			ByteCode bc = new Store(index);
			compiler.addByteCode(bc);
		}	
	}
	/**
	 * M�todo que genera un String de la instrucci�n.
	 */
	public String toString(){
		String s = this.var_name + " = " + this.rhs.toString();
		return s;
	}
}