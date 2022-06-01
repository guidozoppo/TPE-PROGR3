package tp3;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Integer>> vertices;
	private ArrayList<Arco<T>> arcos;
	private ArrayList<Integer> visitados;
	private ArrayList<Integer> fila;
	private Integer tiempo;
	
	public GrafoDirigido() {
		this.vertices = new HashMap<>();
		this.arcos = new ArrayList<>();
		this.visitados = new ArrayList<>();
		this.fila = new ArrayList<>();
	}
	
	@Override
	public void agregarVertice(int verticeId) {
		ArrayList<Integer> adyacentes = new ArrayList<>();
		vertices.put(verticeId, adyacentes);
	}
	
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
		arcos.add(arco);
		vertices.get(verticeId1).add(verticeId2);
	}
	
	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId);
		this.borrarArcos(verticeId);
		
	}

	private void borrarArcos(int verticeOrigen) {
		ArrayList<Arco<T>> aux = new ArrayList<>();
		for (Arco<T> arco: arcos) {
			if(arco.getVerticeOrigen() == verticeOrigen) {
				aux.add(arco);
			}
		}
		for (Arco<T> a: aux) {
			arcos.remove(a);
		}
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> a = null;
		for (Arco<T> arco: arcos) {
			if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
				a = arco;
			}
		}
		arcos.remove(a);
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		for (Arco<T> arco : arcos) {
			if(arco.getVerticeDestino() == verticeId2 && arco.getVerticeOrigen() == verticeId1) 
				return true;
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> a = null;
		for (Arco<T> arco: arcos) {
			if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
				a = arco;
			}
		}
		return a;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		return arcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Iterator<Integer> it = vertices.keySet().iterator();
		return it;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Iterator<Integer> it = vertices.get(verticeId).iterator();
		return it;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Iterator<Arco<T>> it = arcos.iterator();
		return it;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> aux = new ArrayList<>();
		for (Arco<T> a : arcos) {
			if(a.getVerticeOrigen() == verticeId) {
				aux.add(a);
			}
		}
		Iterator<Arco<T>> it = aux.iterator();
		return it;
	}

	public void dfs() {
		visitados.clear();
		this.tiempo = 0;
		for (Integer v: vertices.keySet()) {
			if(!visitados.contains(v)) {
				dfs_visit(v);
			}
		}
	}

	private void dfs_visit(Integer i) {
		ArrayList<Integer> visitando = new ArrayList<>();
		visitando.add(i);
		tiempo++;
		System.out.println("Tiempo de entrada de " + i + " es: " + tiempo);
		for (Integer ady: vertices.get(i)) {
			if(!visitados.contains(ady)) {
				dfs_visit(ady);
			}
			else if(visitando.contains(ady)) {
				System.out.println("HAY CICLO");
			}
		}
		visitados.add(i);
		visitando.remove(i);
		tiempo++;
		System.out.println("Tiempo de salida de " + i +" es: " + tiempo);
	}
	
	public void bfs() {
		fila.clear();
		visitados.clear();
		for (Integer v: vertices.keySet()) {
			if(!visitados.contains(v)) {
				bfs(v);
			}
		}
	}

	private void bfs(Integer v) {
		visitados.add(v);
		fila.add(v);
		while(!fila.isEmpty()) {
			Integer x = fila.get(0);
			for (Integer vAdyacente: vertices.get(x)) {
				if(!visitados.contains(vAdyacente)) {
					visitados.add(vAdyacente);
					fila.add(vAdyacente);
				}
			}
		}
		
	}
	
	
	
	
	
}
