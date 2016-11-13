package TP.PR1.MV;

//Clase que gestiona los comandos
public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;
	
	//He creado tres constructoras dependiendo de los par�metros
	public Command(ENUM_COMMAND com){
		this.command=com;
		this.instruction = new ByteCode();
	}
	public Command(ByteCode inst){
		this.command=ENUM_COMMAND.NEWINST;
		this.instruction=inst;
	}
	public Command(int rep){
		this.command=ENUM_COMMAND.REPLACE;
		this.replace=rep;
	}
	//M�todo que ejecuta el comando
	public boolean execute(Engine engine){
		System.out.println("Comienza la ejecucion de " + toString());
		
		switch (this.command){
		case QUIT: engine.quit(); return true;
		case HELP: engine.help(); return true;
		case RUN: return engine.run();
		case NEWINST: return engine.newinst(this.instruction);
		case RESET: engine.reset(); return true;
		case REPLACE: return engine.replace(this.replace);
		default: return false;
		}
	}
	//M�todo que transforma los comandos en cadenas de caracteres
	public String toString(){
		String cadena;
		
		switch(this.command){
		case QUIT: cadena = "QUIT"; break;
		case HELP: cadena="HELP"; break;
		case RUN: cadena="RUN"; break;
		case NEWINST: cadena="NEWINST "; cadena+=this.instruction.toString(); break;
		case RESET: cadena="RESET"; break;
		case REPLACE: cadena="REPLACE"; break;
		default: cadena="";
		}
		return cadena;
	}
}
