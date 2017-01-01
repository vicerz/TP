package tp.pr3.ByteCode;

import tp.pr3.CPU.CPU;
import tp.pr3.Exception.ArrayException;
import tp.pr3.Exception.DivisionByZero;
import tp.pr3.Exception.StackException;
import tp.pr3.Exception.StackTooSmall;
/**
 * Clase abstracta que gestiona todos los ByteCode.
 * 
 * De ella heredan: GoTo, Halt, Load, Out, Push, Store, Arithmetics 
 * y ConditionalJumps.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 *
 */
public interface ByteCode {
	void execute(CPU cpu) throws DivisionByZero, ArrayException, 
		StackException, StackTooSmall;
	ByteCode parse(String[] s);
}
