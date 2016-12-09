package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class Push extends ByteCode{
	private int n;
	public Push(){
		this.n = 0;
	}
	public Push(int a){
		this.n = a;
	}
	public boolean execute(CPU cpu){
		if (cpu.push(this.n)){
			cpu.aumentarCont();
			return true;
		}
		else return false;
	}
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("PUSH"))
			return new Push(Integer.parseInt(s[1]));
		else return null;
	}
	public String toString(){
		return "PUSH " + this.n;
	}
}
