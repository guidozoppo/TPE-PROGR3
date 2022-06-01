package tp3;

import java.util.HashMap;
import java.util.Iterator;

public class DFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private HashMap<Integer, Integer> descubrimiento;
	private HashMap<Integer, Integer> finalizacion;
	private int tiempo;
	
	
	public DFS(Grafo<?> grafo) {
		this.grafo = grafo;
		colores = new HashMap<>();
		descubrimiento = new HashMap<>();
		finalizacion = new HashMap<>();
		tiempo = 0;
		
	}
	
	public void dfs() {
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while(it.hasNext()) { //pinta todo de blanco
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
		this.tiempo = 0;
		
		it = this.grafo.obtenerVertices(); //se vuelve a hacer it = obtenerVertices porque el next del while anterior lo va eliminando
		while(it.hasNext()) { 
			int verticeId = it.next();
			if (colores.get(verticeId).equals("blanco")) { //por cada vertice blanco disparamos al dfs_visit y volverá con ese vertice que mandamos
				dfs_visit(verticeId);						//y los que llego a visitar pintados de negro. Si quedaba alguno blanco repetia la accion
			}
		}
	}
	
	public void dfs_visit(Integer vertice) {
		colores.put(vertice, "amarillo");
		tiempo++;
		descubrimiento.put(vertice, tiempo);
		
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
		while(it.hasNext()) { //recorro los adyacentes del vertice que vino por parametro
			int adyacente = it.next();
			if(colores.get(adyacente).equals("blanco")) {
				dfs_visit(adyacente);
			}
		}
		colores.put(vertice, "negro");
		tiempo++;
		finalizacion.put(vertice, tiempo);
	}
	
}
