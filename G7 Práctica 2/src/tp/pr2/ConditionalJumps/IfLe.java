package tp.pr2.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public class IfLe extends ConditionalJumps{
	public IfLe(int n){
		super(n);
	}
	public IfLe(){
		super();
	}
	public boolean ejec(CPU cpu, int op1, int op2){
		if (op1 < op2){
			cpu.aumentarCont();
			return true;
		}
		else return cpu.goTo(this.pos);
	}
	public String toString(){
		return "IFLE " + this.pos;
	}
	public ByteCode create(int n){
		return new IfLe(n);
	}
}
