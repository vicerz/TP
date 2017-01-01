package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ByteCode.*;
import tp.pr3.ByteCode.Arithmetics.*;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.*;
/**
 * Clase que gestiona la instrucci�n CompoundAssignment.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class CompoundAssignment implements Instruction{
	private String var_name;
	private String operator;
	private Term term1;
	private Term term2;
	
	final int NUMCOMPONENTES = 5;
	/**
	 * Constructores de la clase.
	 */
	public CompoundAssignment(){
		this.var_name = "";
		this.operator = "";
	}
	public CompoundAssignment(String varName, String op, Term t1, Term t2){
		this.var_name = varName;
		this.operator = op;
		this.term1 = t1;
		this.term2 = t2;
	}
	/**
	 * M�todo que parsea la instrucci�n.
	 * @param words: instrucci�n introducida en el programa.
	 * @param lexparser encargada del an�lisis l�xico.
	 * @return Instruction dependiendo de si coincide con la instrucci�n de esta clase.
	 */
	public Instruction lexParse(String[] words, LexicalParser lexparser){
		if (words.length != NUMCOMPONENTES || words[1].length() != 1) return null;
		else {
			if (!words[1].equals("=") || !IsAnOperator(words[3])) return null;
			else{
				Term t1 = TermParser.parse(words[2]);
				Term t2 = TermParser.parse(words[4]);
				
				if (t1 == null || t2 == null) return null;
				else{
					lexparser.increaseProgramCounter();
					return new CompoundAssignment(words[0], words[3], t1, t2);
				}
			}
		}
	}
	/**
	 * M�todo que comprueba si el String es un operador v�lido.
	 * @param op: String introducido.
	 * @return boolean dependiendo de si el operador coincide con alguno de 
	 * los operadores aritm�ticos existentes.
	 */
	private boolean IsAnOperator(String op){
		if (op.length() != 1) return false;
		else return (op.equals("+") || op.equals("-") || op.equals("*")
				|| op.equals("/"));
	}
	/**
	 * M�todo que compila la instrucci�n.
	 * @param @see {@link tp.pr3.ProgramCompiler.Compiler}.
	 * @throws ArrayException
	 */
	public void compile(tp.pr3.ProgramCompiler.Compiler compiler)throws ArrayException {
		compiler.addByteCode(this.term1.compile(compiler));
		compiler.addByteCode(this.term2.compile(compiler));
		compiler.addByteCode(this.generateBCArithmeticOper());
		ByteCode bc = new Store(compiler.getIndex(this.var_name));
		compiler.addByteCode(bc);
	}
	/**
	 * M�todo que genera el ByteCode correspondiente al operador de la Instrucci�n.
	 * @return ByteCode que se corresponde con el operador aritm�tico
	 */
	private ByteCode generateBCArithmeticOper(){
		if (this.operator.equals("+")) return new Add();
		else if (this.operator.equals("-")) return new Sub();
		else if (this.operator.equals("*")) return new Mul();
		else if (this.operator.equals("/")) return new Div();
		else return null;
	}
}