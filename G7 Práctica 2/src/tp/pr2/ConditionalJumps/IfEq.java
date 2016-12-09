package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfEq extends ConditionalJumps{
	public IfEq(int n){
		super(n);
	}
	public IfEq(){
		super();
	}
	public boolean ejec(CPU cpu, int op1, int op2){
		if (op1 == op2){
			cpu.aumentarCont();
			return true;
		}
		else return cpu.goTo(this.pos);
	}
	public String toString(){
		return "IFEQ " + this.pos;
	}
	public ByteCode create(int n){
		return new IfEq(n);
	}
}
