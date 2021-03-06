package tp.pr3.programcompiler;

import tp.pr3.exception.ArrayException;
/**
 * Clase en la que se almacen el c�digo introducido por el usuario.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class SourceProgram {
	final int TAM_MAX = 100;
	
	private String[] sProgram;
	private int numInstruc;
	/**
	 * Constructor de la clase.	
	 */
	public SourceProgram(){
		this.sProgram = new String[TAM_MAX];
		this.numInstruc = 0;
	}
	/**
	 * M�todo que carga una l�nea de c�digo.
	 * @param s
	 * @throws ArrayException
	 */
	public void cargarInst(String s)throws ArrayException{
		if (this.numInstruc == TAM_MAX) throw new ArrayException("Superado el "
				+ "tama�o m�ximo permitido para un c�digo fuente.");
		
		this.sProgram[this.numInstruc] = s;
		++this.numInstruc;
	}
	/**
	 * M�todo con el que se obtiene el n�mero de l�neas del programa.
	 * @return n�mero de instrucciones.
	 */
	public int getNumeroInstrucciones(){
		return this.numInstruc;
	}
	/**
	 * M�todo que devuelve la instrucci�n n-�sima de un programa.
	 * @param n
	 * @return String que representa una l�nea del c�digo dado.
	 * @throws ArrayException
	 */
	public String getInstructionAt(int n)throws ArrayException{
		if (n < 0 && n >= this.numInstruc) throw new ArrayException("Acceso a posici�n "
				+ "del c�digo fuente inexistente.");

		return this.sProgram[n];
	}
	/**
	 * M�todo que transforma a String el programa almacenado.
	 */
	public String toString(){
		String strProgram = "Programa fuente almacenado:\n";
		for (int i = 0; i < this.numInstruc; ++i){
			strProgram += i + ": " + this.sProgram[i] + "\n";
		}
		return strProgram;
	}
	/**
	 * M�todo que resetea el programa.
	 */
	public void reset(){
		this.numInstruc = 0;
	}
}
