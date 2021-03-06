package tp.pr2.ByteCode.Arithmetics;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;
/**
 * Clase abstracta que gestiona los ByteCode aritm�ticos
 * 
 * De ella heredan: Add, Div, Mul y Sub
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 *
 */
public abstract class Arithmetics extends ByteCode{
	final static int NUMOPERANDOS = 2;
	
	/**
	 * M�todo que ejecuta la operaci�n aritm�tica deseada si es posible 
	 * @param cpu elemento de la clase @see {@link tp.pr2.CPU}
	 * @return booleano dependiendo de si la operaci�n se ha llevado con �xito o no
	 */
	public boolean execute(CPU cpu){
		if (cpu.haynelempila(NUMOPERANDOS)){
			int op2 = cpu.pilapop();
			if (this.ejec(cpu, cpu.pilapop(), op2)){
				cpu.aumentarCont();
				return true;
			}
			else return false;
		}
		else return false;
	}
	/**
	 * M�todo que parsea la instrucci�n aritm�tica
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con alg�n operador aritm�tico o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 1)return parseArith(s);
		else return null;
	}
	abstract public boolean ejec(CPU cpu, int op1, int op2);
	abstract public ByteCode parseArith(String[] s);
}
