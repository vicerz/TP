package tp.pr2.CPU;

/**
 * Clase que gestiona la memoria
 * @author Carlos Moreno
 * @author Manuel Su�rez
 * @version 12/12/2016
 *
 */
public class Memory {
	final int TAM_INI = 100;
	/**
	 * memory array que usamos como memoria
	 * 
	 * tam nos indica el tama�o de la memoria
	 * 
	 * posiciones es un array que guarda las posiciones
	 * en que est�n guardados elementos de la memoria y as� se evita
	 * tener que recorrer la memoria entera cada vez que queramos mostrarla
	 * 
	 * tampos nos indica el tama�o de posiciones
	 * 
	 * numelem nos indica cu�ntos elementos tenemos guardados en memoria
	 */
	private Integer[] memory;
	private int tam;
	private int[] posiciones;
	private int tampos;
	private int numelem;
	/**
	 * Constructor de la clase que inicializa la memoria a 100 por defecto
	 */
	
 	public Memory(){
 		this.memory = new Integer[TAM_INI];
		this.posiciones = new int[TAM_INI];
		this.tampos = 100;
		this.tam = 100;
		for (Integer x : memory) x = null;
		this.numelem = 0;
	}
 	/**
 	 * M�todo que escribe en memoria
 	 * @param pos posici�n de la memoria en la que hay que escribir
 	 * @param value valor que hay que escribir en la memoria
 	 * @return booleano dependiendo de si la ejecuci�n ha sido correcta
 	 */
	public boolean write(int pos, int value){
		//compruebo que la posici�n sea correcta
		if (pos >= 0){
		//Redimensiono el vector para que exista la posici�n pedida
			if (pos >= this.tam) this.resize(pos);
			//Escribo el elemento en su posici�n
			this.memory[pos] = value;
					
			//A�ado la posici�n del elemento reci�n guardado al vector posiciones
			this.insertarpos(pos);
			return true;
		}
		else return false;
	}
	/**
	 * M�todo que lee de memoria
	 * @param pos posici�n de la memoria que tenemos que leer
	 * @return un entero que se corresponde con el numero 
	 * que hay en esa posici�n de la memoria
	 */
	public int read(int pos){
		//Redimensiono la memoria tanto como haga falta
		if (pos >= this.tam) this.resize(pos);
		
		if (this.memory[pos] == null) write(pos, 0);
		
		return this.memory[pos];
	}
	/**
	 * M�todo que redimensiona la memoria
	 * @param pos es la posici�n a la que queremos acceder y por la que
	 * necesitamos acceder a la memori
	 */
	public void resize(int pos){
		Integer newmemory[] = new Integer[2*pos];
		//Copio todos los elementos en el nuevo vector
		for (int i = 0; i < tam; ++i)
			newmemory[i] = this.memory[i];
		//inicializo el vector a todo null
		for (int i = tam; i < 2*pos; ++i){
			newmemory[i] = null;
		}
		//Actualizo los atributos
		this.tam = 2*pos;
		this.memory = newmemory;
	}
	/**
	 * M�todo que redimensiona el vector de posiciones
	 */
	public void resizepos(){
		//Creo un vector del doble de su tama�o actual
		int newposiciones[] = new int[2*tampos];
		//Copio los elementos del vector antiguo en el nuevo
		for (int i = 0; i < tampos; ++i)
			newposiciones[i] = this.posiciones[i];
		//Actualizo los atributos
		this.tampos = 2*tampos;
		this.posiciones = newposiciones;
	}
	/**
	 * M�todo que muestra el estado de la memoria
	 * @return string que muestra el estado de la memoria
	 */
	public String toString(){
		String cadena = "Memoria: ";
		
		//Si la memoria no est� vac�a debo mostrar sus elementos
		if (this.numelem > 0){
			/* Recorro el vector posiciones para ir directamente a las 
			 * posiciones de la memoria en las que haya alg�n elemento*/
			for (int i = 0; i < numelem - 1; ++i){
				int pos = this.posiciones[i];
				cadena += "[" + Integer.toString(pos) + 
						"]: " + Integer.toString(this.memory[pos]) + " ";
			}
			int pos = this.posiciones[numelem - 1];
			cadena += "[" + Integer.toString(pos) + 
					"]: " + Integer.toString(this.memory[pos]) + '\n';
		}
		//si est� vac�a lo indico
		else cadena += "<vacia>\n";
		
		return cadena;
	}
	/**
	 * M�todo que a�ade la posici�n del elemento guardado al vector posiciones
	 * @param pos posici�n que se guarda
	 */
	public void insertarpos(int pos){
		if(numelem == 0) {
			posiciones[0]= pos;
			++numelem;
		}
		else{
			int ini = 0, fin = numelem, mitad = 0;
			boolean encontrado = false;
			
			while(ini < fin && !encontrado){
				mitad = (ini+fin)/2;
				if(posiciones[mitad] < pos) ini = mitad+1;
				else if (posiciones[mitad] > pos) fin = mitad;
				else encontrado = true;
			}
			if(!encontrado){
				int posic;
				posic = fin;
				
				//Redimensiono el vector posiciones si hiciera falta
				if (numelem == tampos) this.resizepos();
				for (int i = numelem; i > posic; --i){
					posiciones[i] = posiciones[i - 1];
				}
				posiciones[posic] = pos;
				
				++numelem;
			}
		}
	}
}
