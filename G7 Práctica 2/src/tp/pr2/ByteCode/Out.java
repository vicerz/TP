package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;

public class Out extends ByteCode{
	public boolean execute(CPU cpu){
		if (cpu.out()){
			cpu.aumentarCont();
			return true;
		}
		else return false;
	}
	public ByteCode parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("OUT"))
			return new Out();
		else return null;
	}
	public String toString(){
		return "OUT";
	}
}
