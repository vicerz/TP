package tp.pr2.Command;

/**
 * Clase que gestiona el parseo de comandos
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 *
 */
public class CommandParser {
	/**
	 * commands es un array que contiene un  objeto de cada una de
	 * las clases que heredan de Command
	 */
	private final static Command[] commands = {
		new Help(), new Quit(), new Reset(),
		new Replace(), new Run(), new AddByteCodeProgram() 
	};
	/**
	 * M�todo que parsea el comando introducido por el usuario
	 * @param line string que se va a parsear
	 * @return ByteCode que se corresponde con el string
	 */
	public static Command parse(String line){
		//Divido el string en un string por cada paralabra separada de un espacio
		String[] subcadenas = line.split(" ");
		Command comando = null;
		int i = 0;
		boolean encontrado = false;
		
		while (i < commands.length && !encontrado){
			comando = commands[i].parse(subcadenas);
			if (comando != null) encontrado = true;
			++i;
		}
		return comando;
	}
	/**
	 * M�todo que muestra por pantalla los distintos comandos que hay
	 */
	public static void showHelp(){
		for (int i = 0; i < commands.length; ++i){
			System.out.print(commands[i].textHelp());
		}
	}
}
