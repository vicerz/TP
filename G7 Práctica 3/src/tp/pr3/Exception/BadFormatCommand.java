package tp.pr3.Exception;

public class BadFormatCommand extends Exception{
	public BadFormatCommand(){
		super("Error en la sintaxis de un Comando");
	}
}
