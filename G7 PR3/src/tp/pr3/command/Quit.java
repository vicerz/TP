package tp.pr3.command;

import tp.pr3.mv.Engine;
/**
 * Clase que gestiona el comando Quit.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class Quit implements Command {
	/**
	 * M�todo que ejecuta el comando Quit.
	 * @param engine: @see {@link Engine}.
	  */
	public void execute(Engine engine){
		engine.quit();
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario.
	 * @param s cadena de caracteres introducida por el usuario.
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Quit o no.
	 */
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else return null;
	}
	/**
	 * M�todo que devuelve un string con informaci�n sobre el comando QUIT.
	 */
	public String textHelp(){
		return " QUIT: Cierra la aplicacion " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando.
	 */
	public String toString(){
		return "QUIT";
	}
}
