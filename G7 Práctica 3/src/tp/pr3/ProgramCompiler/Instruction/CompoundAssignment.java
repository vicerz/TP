package tp.pr3.ProgramCompiler.Instruction;

import tp.pr3.ProgramCompiler.LexicalParser;
import tp.pr3.ProgramCompiler.Term.Term;
import tp.pr3.ProgramCompiler.Term.TermParser;

public class CompoundAssignment implements Instruction{
	private String var_name;
	private String operator;
	private Term term1;
	private Term term2;
	
	final int NUMCOMPONENTES = 5;
	
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
	private boolean IsAnOperator(String op){
		if (op.length() != 1) return false;
		else return (op.equals("+") || op.equals("-") || op.equals("*")
				|| op.equals("/"));
	}
}