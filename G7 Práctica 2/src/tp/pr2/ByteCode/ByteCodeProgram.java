package tp.pr2.ByteCode;

import java.util.Scanner;

/**
 * Clase que gestiona el programa de bytecodes introducido
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 *
 */
public class ByteCodeProgram {
	final int TAM_MAX = 100;
	/**
	 * program es un array que guarda todas las instrucciones del programa
	 * newinst guarda el n�mero de instrucciones de las que consta el array
	 */
	private ByteCode[] program;
	int newinst;
	
	/**
	 * Constructor de la clase que inicializa el vector por defecto a 100
	 */
	public ByteCodeProgram(){
		this.program = new ByteCode[TAM_MAX];
		this.newinst = 0;
	}
	/**
	 * M�todo que muestra el programa almacenado
	 * @return cadena que es la representaci�n por escrito de todas
	 * las instrucciones almacenadas en el programa
	 */
	public String toString(){
		String cadena = "\nPrograma almacenado:\n";
		
		//Recorre todo el array
		for (int i = 0; i < this.newinst; ++i){
			cadena += Integer.toString(i);
			cadena += ": " + this.program[i].toString() + '\n';
		}
		return cadena;
	}
	/**
	 * M�todo que inserta una nueva instrucci�n en el programa
	 * @param bc instrucci�n a insertar
	 * @return un booleano dependiendo de si el parseo de la
	 * instrucci�n fue correcto y de si caben m�s elementos en
	 * el array del programa
	 */
	public boolean pushbc(ByteCode bc){
		if (bc != null && this.newinst < TAM_MAX){
			this.program[this.newinst] = bc;
			++this.newinst;
			return true;
		}
		else return false;
	}
	/**
	 * M�todo que resetea, poniendo el n�mero de elementos del vector a 0
	 */
	public void reset(){ this.newinst = 0; }
	/**
	 * M�todo que reemplaza la instrucci�n n-�sima del programa por otra dada
	 * @param n el n�mero de la instrucci�n que hay que cambiar
	 * @return un booleano dependiendo si el bytecode es correcto o no y de
	 * si existe la instrucci�n n-�sima en el programa
	 */
	public boolean replace(int n){
		if (n >= 0 && n < this.newinst){
			System.out.print("Nueva instruccion: ");
			
			//Pido la nueva instrucci�n
			Scanner entrada = new Scanner(System.in);
			String strbc = entrada.nextLine();
			
			ByteCode bc = ByteCodeParser.parse(strbc);
			
			if (bc != null){
				this.program[n] = bc;
				return true;
			}
			else return false;
		}
		else return false;
	}
	/**
	 * M�todo que devuelve el tama�o del programa
	 * @return el n�mero de instrucciones del array del programa
	 */
	public int getTam(){
		return this.newinst;
	}
	/**
	 * M�todo con el que se obtiene la instrucci�n n-�sima del programa
	 * @param n el n�mero de la instrucci�n que se quiere obtener
	 *
	 * @return el ByteCode correspondiente ubicado en la posici�n 
	 * n-�sima en caso de que �sta 
	 * sea menor que @see {@link ByteCodeProgram#newinst}
	 */
	public ByteCode getBcAtn(int n){
		if (n >= 0 && n < this.newinst){
			return this.program[n];
		}
		else return null;
	}
	/**
	 * M�todo que comprueba si hay que cerrar el programa por haber llegado
	 * al final
	 * @param programCounter: el contador de programa incorporado en esta
	 * versi�n de la pr�ctica
	 * @return un booleano dependiendo de si el programCounter apunta al final
	 * del programa
	 */
	public boolean cerrarPrograma(int programCounter){
		return programCounter == this.newinst;
	}
}
