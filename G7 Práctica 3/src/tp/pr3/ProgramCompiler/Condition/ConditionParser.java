package tp.pr3.ProgramCompiler.Condition;

import tp.pr3.ProgramCompiler.LexicalParser;

public class ConditionParser {
	private final static Condition[] conditions = {
		new Equal(), new Less(), new LessEq(), new NotEqual()
	};
	public static Condition parse(String t1, String op, String t2, LexicalParser lexical){
		
	}
}
