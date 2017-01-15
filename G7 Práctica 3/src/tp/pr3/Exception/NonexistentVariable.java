package tp.pr3.Exception;
/**
 * Excepci�n que se produce cuando se intenta acceder a una variable inexistente.
 * @author Carlos Moreno
 *	@version 30/12/2016
 */
@SuppressWarnings("serial")
public class NonexistentVariable extends Exception{
	public NonexistentVariable(String ExceptionMessage){
		super(ExceptionMessage);
	}
}
