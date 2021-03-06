package tp.pr2.Command;

import tp.pr2.mv.Engine;
/**
 * Clase que gestiona el comando de a�adir nuevo ByteCode al programa
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class AddByteCodeProgram extends Command {
	/**
	 * M�todo que ejecuta el comando ByteCode
	 * @param engine: @see {@link Engine}
	 * @return boolean dependiendo de si la ejecuci�n del comando tuvo
	 * �xito o no @see {@link Engine#readByteCodeProgram()}
	  */
	public boolean execute(Engine engine){
		return engine.readByteCodeProgram();
	}
	/**
	 * M�todo que parsea el comando introducido por el usuario
	 * @param s cadena de caracteres introducida por el usuario
	 * @return ByteCode dependiendo de si la cadena introducida por el
	 * usuario se corresponde con ByteCode o no
	 */
	public Command parse(String[] s){
		if (s.length == 1 && s[0].equalsIgnoreCase("BYTECODE"))
			return new AddByteCodeProgram();
		else return null;
	}
	/**
	 * M�todo que devuele un string con informaci�n sobre el comando ADDBYTECODE
	 */
	public String textHelp(){
		return " BYTECODE: Permite introducir todo un programa " +
				System.getProperty("line.separator");
	}
	/**
	 * M�todo que devuelve una string con el nombre del comando
	 */
	public String toString(){
		return "BYTECODE";
	}
}
