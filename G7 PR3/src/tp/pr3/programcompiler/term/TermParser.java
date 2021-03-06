package tp.pr3.programcompiler.term;

/**
 * Clase que se encarga del parseo de t�rminos.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 */
public class TermParser {
	private final static Term[] terms = {
		new Variable(), new Number(),
	};
	/**
	 * M�todo que parsea el t�rmino dado.
	 * @param s: t�rmino dado por el usuario.
	 * @return Term
	 */
	public static Term parse(String s){
		Term t =  null;
		int i = 0;
		boolean encontrado = false;
		
		while (i < terms.length && !encontrado){
			t = terms[i].parse(s);
			if (t != null) encontrado = true;
			++i;
		}
		return t;
	}
}
