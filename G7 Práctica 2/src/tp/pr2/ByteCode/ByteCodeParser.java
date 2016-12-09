package tp.pr2.ByteCode;

import tp.pr2.Arithmetics.*;
import tp.pr2.ConditionalJumps.*;

public class ByteCodeParser {
	/*Solo a�ado add e IfEq al array de bytecodes, porque a la hora de parsearlos
	 * tambi�n parsearemos el resto de Arithmetics y Conditional Jumps. De esta forma
	 * evitamos entrar en el parseo de Arithmetics y Conditional Jumps varias veces
	 * repetidas, cuando ya sabemos que no coincide.*/
	private final static ByteCode[] bytecodes = {
		new Add(), new IfEq(), new GoTo(), new Halt(), new Load(),
		new Out(), new Push(), new Store()
	};
	final static int NUMBC = 8;
	public static ByteCode parse(String line){
		//Divido el string en un string por cada paralabra separada de un espacio
		String[] subcadenas = line.split(" ");
		ByteCode bc = null;
		int i=0;
		boolean encontrado = false;
				
		while (i < NUMBC && !encontrado){
			bc = bytecodes[i].parse(subcadenas);
			encontrado = bc != null;
			++i;
		}
		return bc;
	}
}
