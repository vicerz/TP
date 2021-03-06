package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;
/**
 * Clase que gestiona el ByteCode Halt
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 *
 */
public class Halt extends ByteCode{
	/**
	 * M�todo que ejecuta el ByteCode (para el programa)
	 * @param cpu: @see {@link tp.pr2.CPU.CPU}
	 * @return boolean dependiendo de si la ejecuci�n del comando tuvo
	 * �xito o no @see {@link CPU#halt()}
	 */
	public boolean execute(CPU cpu){
		return cpu.halt();
	}
	/**
	 * M�todo que parsea la instrucci�n Halt 
	 * @param s recibe la cadena de caracteres que representa el 
	 * ByteCode introducido
	 * 
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Halt o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("HALT"))
			return new Halt();
		else return null;
	}
	/**
	 * @return String con el nombre del BC 
	 */
	public String toString(){
		return "HALT";
	}
}
