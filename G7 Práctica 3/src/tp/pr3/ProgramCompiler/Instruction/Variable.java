package tp.pr3.ProgramCompiler.Instruction;

public class Variable implements Term{
	@Override
	public Term parse(String term) {
	if (term.length()!=1) return null;
	else{
	char name = term.charAt(0);
	if ('a' <= name && name <= 'z') return new Variable(term);
	else return null;
	}
	}
}
