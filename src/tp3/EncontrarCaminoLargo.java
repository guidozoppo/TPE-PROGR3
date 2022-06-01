package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCaminoLargo {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	
	public EncontrarCaminoLargo(Grafo<?> grafo) {
		this.grafo = grafo;
		colores = new HashMap<>();
	}
	
	public ArrayList<Integer> /*dfs*/ encontrarCaminos(int verticeOrigen, int verticeDestino) {
		ArrayList<Integer> camino = new ArrayList<>();
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while(it.hasNext()) { //pinta todo de blanco
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
		
		ArrayList<ArrayList<Integer>> caminos = dfs_visit(verticeOrigen, verticeDestino);
		for (ArrayList<Integer> c: caminos) {
			if(c.size() > camino.size()) {
				camino = c;
			}
		}
		return camino;
	}
	
	private ArrayList<ArrayList<Integer>> dfs_visit(int vertice, int verticeDestino) {
		
		ArrayList<ArrayList<Integer>> solucion = new ArrayList<>();
		
		if(vertice == verticeDestino) { //si soy yo (vertice) el verticeDestino me agrego
			ArrayList<Integer> out = new ArrayList<>();
			out.add(vertice);
			solucion.add(out);
		} else {
			colores.put(vertice, "amarillo"); //se pinta en amarillo para evitar entrar en ciclo 
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice); // it = 5 - 6
			
			while(it.hasNext()) { //este while no se corta como en otros ejercicios porque me pide TODOS los caminos, entonces dejo que recorra por todos los adyacentes
				int adyacente = it.next(); //adyacente = 5
				if(colores.get(adyacente).equals("blanco")) { // 5 es blanco? si, me meto al if
					// suponiendo que yo (vertice) soy el 4 y quiero llegar al 8
					// adyacente es 5
					ArrayList<ArrayList<Integer>> subCaminosDesdeAdy = dfs_visit(adyacente, verticeDestino); 
					//subCaminosDesdeAdy = son todos los subcaminos que devolvio mi adyacente 5 en este caso. 
					// {5 - 15 - 8} puede ser uno
					
					for (ArrayList<Integer> subCamino : subCaminosDesdeAdy) {	//entra al for si subCaminosDesdeAdy no contiene lista vacia					
						subCamino.add(0, vertice); //me agrego yo al principio --> {4 - 5 - 15 - 8}
						solucion.add(subCamino); //agrego el camino a la lista de soluciones
					}
					//solucion tiene {4-5-15-8} por ahora. 
					//Si subCaminosDesdeAdy me daban mas de una lista tendrá mas caminos. Lo mismo pasará si otro adyacente puede llegar al 8
				}
			}
			colores.put(vertice, "blanco"); //se pinta de blanco porque puede volver a visitar el vertice por otro camino (por otro arco)
		}									//se los pinta de blanco para dejarlos en el estado anterior al que entré, 
											//le estoy sacando el color amarillo  que fue puesto cuando ingresé al vertice para evitar ciclos
		return solucion;
	}
	
}
