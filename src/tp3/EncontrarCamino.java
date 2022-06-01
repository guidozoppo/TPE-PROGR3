package tp3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCamino {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int verticeOrigen, verticeDestino;
	
	public EncontrarCamino(Grafo<?> grafo, int vo, int vd) {
		this.grafo = grafo;
		colores = new HashMap<>();
		this.verticeDestino = vd;
		this.verticeOrigen = vo;
	}
	
	public ArrayList<Integer> /*dfs*/ encontrarUnCamino(int verticeOrigen, int verticeDestino) {
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while(it.hasNext()) { //pinta todo de blanco
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
		
		ArrayList<Integer> camino = dfs_visit(verticeOrigen, verticeDestino);
		return camino;
	}
	
	private ArrayList<Integer> dfs_visit(int vertice, int verticeDestino) {
		
		if(vertice == this.verticeDestino) {
			ArrayList<Integer> out = new ArrayList<>();
			out.add(vertice);
			return out;
		}
		
		colores.put(vertice, "amarillo");
		
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
		
		while(it.hasNext()) { 
			int adyacente = it.next();
		
			if(colores.get(adyacente).equals("blanco")) {
				ArrayList<Integer> camino = new ArrayList<>(); //por cada adyacente genero un potencial camino
				camino.add(vertice);  //agrego al vertice donde estoy parado
				ArrayList<Integer> asd = dfs_visit(adyacente, verticeDestino);
				camino.addAll(asd); //Agrego lo que me devuelve el dfs visit
				if(camino.get(camino.size()-1) == verticeDestino) { //si ese camino tiene como ultimo vertice el objetivo lo devuelvo
					return camino;										//y si no es sigo con el proximo adyacente, generando otro camino posible y asi hasta obtener.
				}
			}
		}
		colores.put(vertice, "negro");
		return new ArrayList<>();
	}
	
}
