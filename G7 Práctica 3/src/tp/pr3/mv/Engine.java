package tp.pr3.mv;

import java.util.Scanner;
import tp.pr3.ByteCode.*;
import tp.pr3.CPU.CPU;
import tp.pr3.Command.*;
import tp.pr3.Exception.*;
import tp.pr3.ProgramCompiler.*;
/**
 * Clase que gestiona la ejecuci�n de la m�quina virtual
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 */
public class Engine {
	/**
	 * program es un objeto de tipo tp.pr2.ByteCode.ByteCodeProgram
	 * 
	 * end es un booleano que indica si se ha acabado la introducci�n 
	 * de instrucciones BC o no
	 */
	private SourceProgram sProgram;
	private ParsedProgram parsedProgram;
	private ByteCodeProgram bytecodeProgram;
	private boolean end;
	final static Scanner entrada = new Scanner(System.in);
	/**
	 * Constructor de la clase
	 */
	public Engine(){
		this.bytecodeProgram = new ByteCodeProgram();
		this.end = false;
	}
	
	/**
	 * M�todo que dirige todo el programa
	 */
	public void start(){
		String line;
		Command com;
		
		//Hasta que el usuario no ejecute "quit" no finalizar� el pograma
		while(!this.end){	
			System.out.print("> ");
			//Se lee el comando
			line = entrada.nextLine();
			//Se parsea
			com = CommandParser.parse(line);
			
			//Si no ha habido un error escribiendo el comando se ejecuta
			if (com != null){
				System.out.println("Comienza la ejecucion de " + com.toString()
						+ '\n');
				//Muestro mensaje de error si hubo un error en la ejecuci�n
				if (!com.execute(this))
					System.out.println("Error: Ejecucion incorrecta del comando");
			}
			//Muestro mensaje de error si hubo un error en la escritura
			else System.out.println("Error: Comando incorrecto");
			//Si el programa tiene instrucciones a�adidas se muestra al usuario
			if (this.bytecodeProgram.getTam() > 0) 
				System.out.println(this.bytecodeProgram.toString());
		}
		System.out.println("Fin de la ejecucion...");
	}
	/**
	 * M�todo que implementa el comando QUIT
	 * @return boolean dependiendo de si el comando se ejecut� con �xito
	 */
	public boolean quit(){ this.end = true; return true; }
	/**
	 * M�todo que implementa el comando RUN
	 * @return un booleano dependiendo de si la ejecuci�n del comando fue correcta
	 */
	public boolean run(){
		boolean error = false;
		//Inicializo una CPU
		CPU cpu = new CPU(this.bytecodeProgram);
		error = !cpu.run();
		//Si no hubo errores muestro el estado actual de la m�quina
		if (!error){
			System.out.println("El estado de la maquina tras ejecutar "
					+ "el programa es:");
			System.out.println(cpu.toString());
		}
		return !error;
	}
	/**
	 * M�todo que ejecuta el comando RESET
	 * @return un booleano dependiendo de si la ejecuci�n del comando fue correcta
	 */
	public boolean resetProgram(){ this.bytecodeProgram.reset(); return true; }
	/**
	 * M�todo que ejecuta el comando REPLACE
	 * @param rep instrucci�n a reemplazar
	 * @return un booleano dependiendo de 
	 * si @see {@link ByteCodeProgram#replace(int)}
	 */
	public boolean replace(int rep){ return this.bytecodeProgram.replace(rep); }
	
	public boolean compile() throws LexicalAnalysisException, ArrayException {
		try {
		this.lexicalAnalysis();
		this.generateByteCode();
		}
		catch{
			
		}
	}
	public boolean cargarInstrProg(String s){
		return this.sProgram.cargarInst(s);
	}
	private void lexicalAnalysis() throws LexicalAnalysisException {
		
	}
	private void generateByteCode() throws ArrayException{
		
	}
}
