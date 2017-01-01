package tp.pr3.Command;

import tp.pr3.Exception.*;
import tp.pr3.mv.Engine;
/**
 * Clase que gestiona el comando Replace.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Replace implements Command {
	private int pos;
	/**
	 * Constructores de la clase.
	 */
	public Replace(){
		this.pos = 0;
	}
	public Replace(int p){
		this.pos = p;
	}
	/**
	 * M�todo que ejecuta el comando Replace.
	 * @param engine: @see {@link Engine}.
	  */
	public void execute(Engine engine)throws BadFormatByteCode, ArrayException{
		engine.replace(this.pos);
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario.
	 * @param s cadena de caracteres introducida por el usuario.
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Replace o no.
	 */
	public Command parse(String[] s){
		try{
			if (s.length == 2 && s[0].equalsIgnoreCase("REPLACE")){
				return new Replace(Integer.parseInt(s[1]));
			}
			else return null;
		}
		catch(NumberFormatException e){
			System.out.println("Error al introducir el Comando REPLACE");
			System.out.println("A 'REPLACE' debe precederle un caracter num�rico");
			return null;
		}
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando REPLACE.
	 */
	public String textHelp(){
		return " REPLACE N: Reemplaza la instruccion N por la solicitada"
				+ " al usuario " + System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "REPLACE " + this.pos;
	}
}
