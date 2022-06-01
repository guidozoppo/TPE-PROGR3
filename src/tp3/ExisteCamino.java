package tp3;

import java.util.HashMap;
import java.util.Iterator;

public class ExisteCamino {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int verticeOrigen, verticeDestino;
	
	public ExisteCamino(Grafo<?> grafo, int vo, int vd) {
		this.grafo = grafo;
		colores = new HashMap<>();
		this.verticeDestino = vd;
		this.verticeOrigen = vo;
	}
	
	public boolean dfs() {
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while(it.hasNext()) { //pinta todo de blanco
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
		
		boolean existeCamino = dfs_visit(this.verticeOrigen);
		return existeCamino;
	}
	
	private boolean dfs_visit(Integer vertice) {
		if(vertice == this.verticeDestino) {
			return true;
		}
		
		boolean encontreCamino = false;
		colores.put(vertice, "amarillo");
		
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
		while(it.hasNext() && !encontreCamino) { 
			int adyacente = it.next();
			if(colores.get(adyacente).equals("blanco")) {
				encontreCamino = dfs_visit(adyacente);
			}
		}
		colores.put(vertice, "negro");
		return false;
	}
	
}
