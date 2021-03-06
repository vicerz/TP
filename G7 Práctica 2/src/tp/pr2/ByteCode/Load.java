package tp.pr2.ByteCode;

import tp.pr2.CPU.CPU;
/**
 * Clase que gestiona el ByteCode Load
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class Load extends ByteCode{
	private int n;
	/**
	 * Constructores de la clase
	 */
	public Load(){
		this.n = 0;
	}
	public Load(int a){
		this.n = a;
	}
	/**
	 * M�todo que ejecuta el ByteCode Load
	 * @param cpu: @see {@link tp.pr2.CPU.CPU}
	 * @return un booleano que devuelve cierto si se pudo realizar la operaci�n 
	 * con �xito y falso si no es as�
	 */
	public boolean execute(CPU cpu){
		if (cpu.load(this.n)){
			cpu.aumentarCont();
			return true;
		}
		else return false;
	}
	/**
	 * M�todo que parsea la instruccion Load
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByteCode dependiendo si la cadena introducida por el
	 * usuario se corresponde con Load o no
	 */
	public ByteCode parse(String[] s){
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
			return new Load(Integer.parseInt(s[1]));
		else return null;
	}
	/**
	 * @return String con el nombre del BC
	 */
	public String toString(){
		return "LOAD " + this.n;
	}
}
