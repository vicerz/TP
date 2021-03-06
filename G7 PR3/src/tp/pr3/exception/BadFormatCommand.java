package tp.pr3.exception;
/**
 * Excepci�n que se produce cuando se introduce un comando incorrecto.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class BadFormatCommand extends Exception{
	private String ExceptionMessage;
	
	public BadFormatCommand(String ExceptionMessage){
		this.ExceptionMessage = ExceptionMessage;
	}
	public String toString(){
		return this.ExceptionMessage;
	}
}
