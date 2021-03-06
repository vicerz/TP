package tp.pr3.command;

/**
 * Clase que gestiona el parseo de comandos.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 *
 */
public class CommandParser {
	/**
	 * commands es un array que contiene un  objeto de cada una de
	 * las clases que heredan de Command.
	 * 
	 * COMMAND_LONG_MAX es una constante entera que nos dice el n�mero m�ximo de
	 * palabras que puede tener un Comando.
	 */
	private final static Command[] commands = {
		new Help(), new Quit(), new ReplaceBC(), new Run(),
		new LoadFich(), new Compile(),
	};
	final static int COMMAND_LONG_MAX = 2;
	/**
	 * M�todo que parsea el comando introducido por el usuario.
	 * @param line string que se va a parsear.
	 * @return ByteCode que se corresponde con el string.
	 */
	public static Command parse(String line){
		//Divido el string en un string por cada paralabra separada de un espacio
		String[] subcadenas = line.split(" ");
		
		if (subcadenas.length > COMMAND_LONG_MAX) return null;
		
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
	 * M�todo que muestra por pantalla los distintos comandos que hay.
	 */
	public static void showHelp(){
		for (int i = 0; i < commands.length; ++i){
			System.out.print(commands[i].textHelp());
		}
	}
}
