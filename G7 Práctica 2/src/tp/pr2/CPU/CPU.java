package tp.pr2.CPU;

import tp.pr2.ByteCode.*;

/**
 * Clase que gestiona la ejecuci�n de las instrucciones bytecode
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class CPU {
	/**
	 * Memoria es un objeto de la clase @see TP.PR1.MV.Memory
	 * pila es un objeto de la clase @see TP.PR1.MV.OperandStack
	 * end es un booleano que indica cuando acaba la ejecuci�n 
	 * de las intrucciones bytecode
	 * programCounter es un entero que representa al contador de programa
	 * bcProgram es un objeto de la clase @see tp.pr2.ByteCode.ByteCodeProgram
	 */
	private Memory memoria;
	private OperandStack pila;
	private boolean end;
	private int programCounter;
	private ByteCodeProgram bcProgram;
	
	/**
	 * Constructor de la clase
	 * @param prog es el programa con el que se inicializa la CPU
	 */
	public CPU(ByteCodeProgram prog){
		this.memoria = new Memory();
		this.pila = new OperandStack();
		this.end = false;
		this.programCounter = 0;
		this.bcProgram = prog;
	}
	/**
	 * M�todo que ejecuta el programa dado
	 * @return un booleano dependiendo de si la ejecuci�n fue correcta 
	 */
	public boolean run(){
		boolean error = false;
		ByteCode bc = null;
		
		while (!acabar() && !error){
			bc = getInstr();
			error = !bc.execute(this);
		}
		return !error;
	}
	/**
	 * M�todo que comprueba el n�mero de elementos que hay en pila
	 * @param n: n�mero de elementos que queremos comprobar
	 * @return boolean dependiendo de si hay n elementos en la pila
	 */
	public boolean haynelempila(int n){
		return n <= this.pila.getNumOperand();
	}
	/**
	 * M�todo que implementa la instrucci�n LOAD
	 * @param pos posici�n de memoria
	 * @return booleano dependiendo de si la carga fue correcta
	 */
	public boolean load(int pos){
		//Leo el elemento de memoria
		int elem = this.memoria.read(pos);
		return this.pila.push(elem);
	}
	/**
	 * M�todo que muestra el estado de la CPU, mostrando el de la pila y memoria
	 */
	public String toString(){
		String cadena = "Estado de la CPU:\n";
		cadena += this.memoria.toString();
		cadena += this.pila.toString();
		return cadena;
	}
	/**
	 * M�todo que devuelve el BC que se debe ejecutar
	 * @return ByteCode de la instrucci�n que se va
	 * ejecutar @see {@link ByteCodeProgram#getBcAtn(int)}
	 */
	public ByteCode getInstr(){
		return this.bcProgram.getBcAtn(this.programCounter);
	}
	/**
	 * M�todo que extrae un elemento de la cima de la pila
	 * @return int que ser� el elemento en la cima de la
	 * pila @see {@link OperandStack#pop()}
	 */
	public int pilapop(){
		return pila.pop();
	}
	/**
	 * M�todo que introduce un elemento en la pila
	 * @param n elemento a introducir
	 * @return int que ser� el elemento que introduciremos
	 * en la pila @see {@link OperandStack#push(int)}
	 */
	public boolean push(int n){
		return pila.push(n);
	}
	/**
	 * M�todo que salta a la n-�sima instrucci�n del programa
	 * @param n n�mero de instrucci�n a la que se desea saltar
	 * @return booleano dependiendo de si la ejecuci�n de la instrucci�n
	 * ha tenido �xito
	 */
	public boolean goTo(int n){
		if (n >= 0 && n < this.bcProgram.getTam()){
			this.programCounter = n;
			return true;
		}
		else return false;
	}
	/**
	 * M�todo que ejecuta el ByteCode store
	 * @param n posici�n de memoria
	 * @return booleano dependiendo de si la ejecuci�n de la instrucci�n
	 * ha tenido �xito
	 */
	public boolean store(int n){
		if (!pila.vacia()) 
			return this.memoria.write(n, pila.pop());
		else return false; 
	}
	/**
	 * M�todo que ejecuta el ByteCode Halt
	 * @return booleano dependiendo de si la ejecuci�n de la instrucci�n
	 * ha tenido �xito
	 */
	public boolean halt(){
		this.end = true;
		return true;
	}
	/**
	 * M�todo que ejecuta el ByteCode Out
	 * @return booleano dependiendo de si la ejecuci�n de la instrucci�n
	 * ha tenido �xito
	 */
	public boolean out(){
		if (!pila.vacia()) {
			System.out.println(Integer.toString(pila.pop()));
			return true;
		}
		else return false;
	}
	/**
	 * M�todo que comprueba si el programa debe acabar o no
	 * @return booleano dependiendo de si el programa debe acabar
	 */
	public boolean acabar(){
		return (this.end || this.bcProgram.cerrarPrograma(this.programCounter));
	}
	/**
	 * M�todo que aumenta en uno el valor del contador de programa
	 */
	public void aumentarCont(){
		++this.programCounter;
	}
}
