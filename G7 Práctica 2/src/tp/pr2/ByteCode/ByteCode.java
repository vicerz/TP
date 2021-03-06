package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;
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
public abstract class ByteCode {
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] s);
}
