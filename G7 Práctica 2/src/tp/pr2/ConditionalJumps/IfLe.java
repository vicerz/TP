package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfLe extends ConditionalJumps{
	public IfLe(int n){
		this.pos = n;
	}
	public IfLe(){
		this.pos = 0;
	}
	public boolean execute(CPU cpu){
		int op1 = cpu.pilapop();
		
		if (cpu.pilapop() < op1) return true;
		else return cpu.goTo(this.pos);
	}
	public ByteCode parse(String[] s){
		if (s[0].equalsIgnoreCase("IFLE")) return new IfLe(Integer.parseInt(s[1]));
		else return null;
	}
}
