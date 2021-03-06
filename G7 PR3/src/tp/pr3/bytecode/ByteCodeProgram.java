package tp.pr3.bytecode;

import java.util.Scanner;

import tp.pr3.exception.*;
/**
 * Clase que gestiona el programa de bytecodes introducido.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 *
 */
public class ByteCodeProgram {
	final int TAM_MAX = 100;
	/**
	 * program es un array que guarda todas las instrucciones del programa.
	 * newinst guarda el n�mero de instrucciones de las que consta el array.
	 */
	private ByteCode[] program;
	int newinst;
	
	final static Scanner entrada = new Scanner(System.in);
	
	/**
	 * Constructor de la clase que inicializa el vector por defecto a 100.
	 */
	public ByteCodeProgram(){
		this.program = new ByteCode[TAM_MAX];
		this.newinst = 0;
	}
	/**
	 * M�todo que muestra el programa almacenado.
	 * @return cadena que es la representaci�n por escrito de todas
	 * las instrucciones almacenadas en el programa.
	 */
	public String toString(){
		String cadena = "Programa bytecode almacenado:\n";
		
		//Recorre todo el array
		for (int i = 0; i < this.newinst; ++i){
			cadena += Integer.toString(i);
			cadena += ": " + this.program[i].toString() + '\n';
		}
		return cadena;
	}
	/**
	 * M�todo que inserta una nueva instrucci�n en el programa.
	 * @param bc instrucci�n a insertar.
	 * @throws ArrayException
	 */
	public void pushbc(ByteCode bc)throws ArrayException{
		if (this.newinst == TAM_MAX) throw new ArrayException("Superado el tama�o "
				+ "m�ximo permitido de un programa bytecode.");
		
		this.program[this.newinst] = bc;
		++this.newinst;
	}
	/**
	 * M�todo que reemplaza la instrucci�n n-�sima del programa por otra dada.
	 * @param n el n�mero de la instrucci�n que hay que cambiar.
	 * @throws BadFormatByteCode producida al introducir un ByteCode incorrecto.
	 * @throws ArrayException
	 */
	public void replace(int n) throws BadFormatByteCode, ArrayException{
		AccesoPosicionInexistente(n);
		
		System.out.print("Nueva instruccion: ");
		
		//Pido la nueva instrucci�n
		String strbc = entrada.nextLine();
		
		ByteCode bc = ByteCodeParser.parse(strbc);
		
		if (bc == null) throw new BadFormatByteCode("Error en la sint�xis del ByteCode "
				+ "introducido.\nEl ByteCode '" + strbc + "' no existe");
		this.program[n] = bc;
	}
	/**
	 * M�todo que devuelve el tama�o del programa.
	 * @return el n�mero de instrucciones del array del programa.
	 */
	public int getTam(){
		return this.newinst;
	}
	/**
	 * M�todo con el que se obtiene la instrucci�n n-�sima del programa.
	 * @param n el n�mero de la instrucci�n que se quiere obtener.
	 *
	 * @return el ByteCode correspondiente ubicado en la posici�n n-�sima.
	 * 
	 * @throws ArrayException
	 */
	public ByteCode getBcAtn(int n) throws ArrayException{
		AccesoPosicionInexistente(n);
		
		return this.program[n];
	}
	/**
	 * M�todo que comprueba si hay que cerrar el programa por haber llegado
	 * al final.
	 * @param programCounter: el contador de programa.
	 * @return un booleano dependiendo de si el programCounter apunta al final
	 * del programa.
	 */
	public boolean cerrarPrograma(int programCounter){
		return programCounter == this.newinst;
	}
	/**
	 * M�todo que comprueba si se quiere acceder a una posici�n inexistente del programa.
	 * @param pos: posici�n a la que se quiere acceder.
	 * @throws ArrayException.
	 */
	private void AccesoPosicionInexistente(int pos) throws ArrayException{
		if (pos < 0 || pos >= this.newinst) throw new ArrayException("Acceso a"
				+ "posici�n del programa bytecode inexistente.");
	}
	/**
	 * M�todo que resetea el ByteCodeProgram.
	 */
	public void reset(){
		this.newinst = 0;
	}
}
