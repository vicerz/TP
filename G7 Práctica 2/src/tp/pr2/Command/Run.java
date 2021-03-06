package tp.pr2.Command;

import tp.pr2.mv.Engine;
/**
 * Clase que gestiona el comando Run
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class Run extends Command {
	/**
	 * M�todo que ejecuta el comando Run
	 * @param engine: @see {@link Engine}
	 * @return boolean dependiendo de si la ejecuci�n del comando tuvo
	 * �xito o no @see {@link Engine#run()}
	  */
	public boolean execute(Engine engine){
		return engine.run();
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario
	 * @param s cadena de caracteres introducida por el usuario
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con Run o no
	 */
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else return null;
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando RUN
	 */
	public String textHelp(){
		return " RUN: Ejecuta el programa " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve un string con el nombre del comando
	 */
	public String toString(){
		return "RUN";
	}
}
