package tp.pr3.ByteCode;

import tp.pr3.ByteCode.Arithmetics.*;
import tp.pr3.ByteCode.ConditionalJumps.*;
import tp.pr3.Exception.BadFormatByteCode;
/**
 * Clase que gestiona el parseo del ByteCode que se ha introducido.
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 30/12/2016
 *
 */
public class ByteCodeParser {
	/**
	 * bytecodes es un array que contiene un objeto de cada uno de los 
	 * posibles bytecodes.
	 * 
	 * BC_LONG_MAX es una constante entera que nos dice el n�mero m�ximo de
	 * palabras que puede tener un ByteCode.
	 */
	private final static ByteCode[] bytecodes = {
		new Add(), new Sub(), new Mul(), new Div(), new IfEq(), new IfLeq(), 
		new IfNeq(), new IfLe(), new GoTo(), new Halt(), new Load(), 
		new Out(), new Push(), new Store()
	};
	final static int BC_LONG_MAX = 2;
	/**
	 * M�todo que se encarga del parseo del ByteCode escrito por el usuario.
	 * @param line un string que representa el ByteCode introducido.
	 * @return el ByteCode introducido con su tipo adecuado.
	 * @throws BadFormatByteCode: producida al introducir un ByteCode incorrecto.
	 */
	public static ByteCode parse(String line) throws BadFormatByteCode{
		//Divido el string en un string por cada paralabra separada de un espacio
		String[] subcadenas = line.split(" ");
		
		if (subcadenas.length > BC_LONG_MAX) throw new BadFormatByteCode();
		
		ByteCode bc = null;
		int i = 0;
		boolean encontrado = false;
		
		while (i < bytecodes.length && !encontrado){
			bc = bytecodes[i].parse(subcadenas);
			if (bc != null) encontrado = true;
			++i;
		}
		if (!encontrado) throw new BadFormatByteCode();
		return bc;
	}
}
