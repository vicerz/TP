package TP.PR1.MV;

import java.util.Scanner;
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
			line=entrada.nextLine();
			//Se parsea
			com=CommandParser.parse(line);
			
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
	 * M�todo que implementa el comando HELP
	 */
	public void help(){
		System.out.println("HELP: Muestra esta ayuda");
		System.out.println("QUIT: Cierra la aplicacion");
		System.out.println("RUN: Ejecuta el programa");
		System.out.println("NEWINST BYTECODE: Introduce una nueva instruccion al programa");
		System.out.println("RESET: Vacia el programa actual");
		System.out.println("REPLACE N: Reemplaza la instruccion N por la solicitada al usuario");
	}
	/**
	 * M�todo que implementa el comando QUIT
	 */
	public void quit(){ this.end=true; }
	/**
	 * M�todo que implementa el comando RUN
	 * @return un booleano dependiendo de si la ejecuci�n fue correcta
	 */
	public boolean run(){
		/*Utilizar� el boolean error para parar la ejecuci�n
		 * si se produjera un error en medio*/
		boolean error=false;
		//Inicializo una CPU
		CPU cpu = new CPU();
		/*Utilizo el �ndice para realizar todas las instrucciones
		 * El m�todo getTam() devuelve la cantidad de instrucciones que
		 * posee el programa*/
		int indice=0, max = this.program.getTam();
		ByteCode instr;
		
		/*Hasta que no se produzca un error en mitad de la ejecuci�n, se
		 * ejecute el bytecode HALT o hayamos ejecutado todas las instrucciones
		 * ejecutaremos lo siguiente*/
		while (!error && !cpu.getEnd() && indice < max){
			//Tomo instr como la instrucci�n n-�sima
			instr = this.program.instn(indice);
			//compruebo si se produce un error en la ejecuci�n
			error = !cpu.execute(instr);
			//Aumento el �ndice para pasar a la siguiente instrucci�n
			++indice;
			if (!error) {
				//Si no hubo errores muestro el estado actual de la m�quina
				System.out.println("El estado de la maquina tras ejecutar el bytecode "
						+ instr.toString() + " es:");
				System.out.println(cpu.toString());
			}
		}
		return !error;
	}
	/**
	 * M�todo que ejecuta el comando NEWINST
	 * @param instruction
	 * @return un booleano dependiendo de si @see {@link TP.PR1.MV.ByteCodeProgram#pushbc(ByteCode)}
	 */
	public boolean newinst(ByteCode instruction){
		//A�ade la instrucci�n al programa
		return this.program.pushbc(instruction);
	}
	/**
	 * M�todo que ejecuta el comando RESET
	 */
	public void reset(){ this.program.reset(); }
	/**
	 * M�todo que ejecuta el comando REPLACE
	 * @param rep
	 * @return un booleano dependiendo de si @see {@link TP.PR1.MV.ByteCodeProgram#replace(int)}
	 */
	public boolean replace(int rep){ return this.program.replace(rep); }
}
