package tp.pr2.Arithmetics;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class Add extends Arithmetics{
	public boolean execute(CPU cpu){
		int op2 = cpu.pilapop();
		return cpu.push(op2 + cpu.pilapop());
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}
}
