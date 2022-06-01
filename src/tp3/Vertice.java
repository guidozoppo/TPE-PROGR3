package tp3;

import java.util.LinkedList;

public class Vertice {

	private int valor;
	private LinkedList<Object> adyacentes;
	
	public Vertice(int v) {
		this.valor = v;
		adyacentes = new LinkedList<>();
	}
}
