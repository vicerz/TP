package tp.pr2.Arithmetics;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;

public abstract class Arithmetics extends ByteCode{
	final static int NUMARITH = 4;
	final static int NUMOPERANDOS = 2;
	private final static Arithmetics[] arth = {
		new Add(), new Sub(), new Mul(), new Div()
	};
	public boolean execute(CPU cpu){
		if (cpu.haynelempila(NUMOPERANDOS)){
			ByteCode bc = cpu.getInstr();
			int i = 0;
			boolean encontrado = false;
			
			while (i < NUMARITH && !encontrado){
				encontrado = bc.getClass() == arth[i].getClass();
				if (!encontrado) ++i;
			}
			if (encontrado){
				int op2 = cpu.pilapop();
				return arth[i].ejec(cpu, cpu.pilapop(), op2);
			}
			else return false;
		}
		else return false;
	}
	public ByteCode parse(String[] s){
		if (s.length == 1){
			ByteCode bc = null;
			int i = 0;
			boolean encontrado = false;
			
			while (i < NUMARITH && !encontrado){
				encontrado = s[0].equalsIgnoreCase(arth[i].toString());
				if (encontrado) bc = arth[i];
				++i;
			}
			return bc;
		}
		else return null;
	}
	abstract public boolean ejec(CPU cpu, int op1, int op2);
}
