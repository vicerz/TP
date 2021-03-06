package tp.pr2.CPU;

/**
 * Clase que gestiona la pila
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class OperandStack {
	final int TAM = 100;
	/**
	 * stack Es un vector con el que implementamos la pila
	 * 
	 * numoperand Establece cu�ntos operandos hay en la pila
	 */
	private int[] stack;
	private int numoperand;
	
	/**
	 * Constructor de la clase
	 */
	public OperandStack(){
		this.stack = new int[TAM];
		this.numoperand = 0;
	}
	/**
	 * M�todo que introduce un operando en la pila
	 * @param op operando a introducir
	 * @return un booleano dependiendo de si se ejecut� la instrucci�n con �xito
	 */
	public boolean push(int op){
		if (!this.pilallena()){
			//lo introduce en la cima
			this.stack[this.numoperand] = op;
			//Aumenta el n�mero de operandos
			++this.numoperand;
			
			return true;
		}
		else return false;
	}
	/**
	 * M�todo que comprueba si la pila est� vac�a
	 * @return booleano dependiendo de si la pila esta vacia o no
	 */
	public boolean vacia(){
		return numoperand == 0;
	}
	/**
	 * M�todo que extrae el elemento de la cima de la pila
	 * @return elemento extraido de la pila
	 */
	public int pop(){
		int valor = this.stack[numoperand - 1];
		--numoperand;
		return valor;
	}
	/**
	 * M�todo que muestra el estado de la pila
	 */
	public String toString(){
		String cadena = "Pila: ";
		if (this.numoperand > 0){
			for (int i = 0; i < numoperand - 1; ++i){
				cadena += Integer.toString(this.stack[i]) + " ";
			}
			cadena += Integer.toString(this.stack[numoperand - 1]) + '\n';
		}
		else cadena += "<vacia>\n";
		
		return cadena;
	}
	/**
	 * M�todo que comprueba si la pila est� llena
	 * @return booleano dependiendo de si la pila est� llena
	 */
	public boolean pilallena(){
		return this.numoperand == TAM;
	}
	/**
	 * M�todo que devuelve el numero de operandos que hay
	 * @return el numero de operandos que hay 
	 */
	public int getNumOperand(){
		return this.numoperand;
	}
}