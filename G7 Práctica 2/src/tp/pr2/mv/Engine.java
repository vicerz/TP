package tp.pr2.mv;

import java.util.Scanner;

import tp.pr2.ByteCode.ByteCode;
import tp.pr2.ByteCode.ByteCodeProgram;
import tp.pr2.CPU.CPU;
import tp.pr2.Command.*;
/**
 * Clase que gestiona la ejecuci�n de la m�quina virtual
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 17/11/2016
 *
 */
public class Engine {
	private ByteCodeProgram program;
	private boolean end;
	
	/**
	 * Constructor de la clase
	 */
	public Engine(){
		this.program = new ByteCodeProgram();
		this.end = false;
	}
	
	/**
	 * M�todo que dirige todo el programa
	 */
	public void start(){
		Scanner entrada = new Scanner(System.in);
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
				//Muestro mensaje de error si hubo un error en la ejecuci�n
				if (!com.execute(this)) 
					System.out.println("Error: Ejecucion incorrecta del comando");
			}
			//Muestro mensaje de error si hubo un error en la escritura
			else System.out.println("Error: Comando incorrecto");
			//Si el programa tiene instrucciones a�adidas se saca muestra al usuario
			if (this.program.getTam() > 0) 
				System.out.println(this.program.toString());
		}
		System.out.println("Fin de la ejecucion...");
	}
	/**
	 * M�todo que implementa el comando QUIT
	 */
	public boolean quit(){ this.end = true; return true; }
	/**
	 * M�todo que implementa el comando RUN
	 * @return un booleano dependiendo de si la ejecuci�n fue correcta
	 */
	public boolean run(){
		//Inicializo una CPU
		CPU cpu = new CPU(this.program);
		return cpu.run();
	}
	/**
	 * M�todo que ejecuta el comando RESET
	 */
	public boolean resetProgram(){ this.program.reset(); return true; }
	/**
	 * M�todo que ejecuta el comando REPLACE
	 * @param rep
	 * @return un booleano dependiendo de 
	 * si @see {@link ByteCodeProgram#replace(int)}
	 */
	public boolean replace(int rep){ return this.program.replace(rep); }
	
	public boolean readByteCodeProgram(){
		Scanner entrada = new Scanner(System.in);
		
		String instruccion = entrada.nextLine();
		while (!instruccion.equalsIgnoreCase("END")){
			
			
			instruccion = entrada.nextLine();
		}
	}
}
