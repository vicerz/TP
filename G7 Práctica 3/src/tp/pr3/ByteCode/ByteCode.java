package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
/**
 * Clase abstracta que gestiona todos los ByteCode
 * 
 * De ella heredan: GoTo, Halt, Load, Out, Push, Store, Arithmetics 
 * y ConditionalJumps
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 *
 */
public interface ByteCode {
	public boolean execute(CPU cpu);
	public ByteCode parse(String[] s);
}
