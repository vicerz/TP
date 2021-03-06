package tp.pr2.ByteCode.ConditionalJumps;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.CPU.CPU;
/**
 * Clase que gestiona el operador de salto condicional IfEq
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class IfEq extends ConditionalJumps{
	/**
	 * Constructores de la clase
	 * @param n: instrucci�n a la que se desea saltar
	 */
	public IfEq(int n){
		super(n);
	}
	public IfEq(){
		super();
	}
	/**
	 * M�todo que ejecuta el ByteCode
	 * @param cpu: @see {@link tp.pr2.CPU}
	 * @param op1 primer operando a comparar
	 * @param op2 segundo operando a comparar
	 * @return booleano dependiendo de si se ejecuta el ByteCode con �xito
	 */
	public boolean ejec(CPU cpu, int op1, int op2){
		if (op1 == op2){
			cpu.aumentarCont();
			return true;
		}
		else return cpu.goTo(this.pos);
	}
	/**
	 * M�todo que parsea el salto condicional IfEq
	 * @param s recibe la cadena de caracteres que representa el ByteCode introducido
	 * @return ByCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con IfEq o no
	 */
	public ByteCode parseCondJump(String[] s){
		if(s[0].equalsIgnoreCase("IFEQ")){
			int numinstr = Integer.parseInt(s[1]);
			return new IfEq(numinstr);
		}
		else return null;
	}
	
	/**
	 * @return la cadena de caracteres que corresponde al ByteCode introducida
	 */
	public String toString(){
		return "IFEQ " + this.pos;
	}
}
