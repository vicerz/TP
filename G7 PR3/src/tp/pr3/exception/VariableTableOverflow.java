package tp.pr3.exception;
/**
 * Excepci�n que se produce cuando se intenta introducir una nueva variable y la tabla
 * de variables est� llena.
 * @author Carlos Moreno
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class VariableTableOverflow extends Exception{
	private String ExceptionMessage;
	
	public VariableTableOverflow(String ExceptionMessage){
		this.ExceptionMessage = ExceptionMessage;
	}
	public String toString(){
		return this.ExceptionMessage;
	}
}
