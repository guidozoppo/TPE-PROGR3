package tp4EJ1;

import java.util.ArrayList;
import java.util.HashSet;

public class Camino {

	private HashSet<Sala> salasVisitadas;
	private ArrayList<Sala> camino;
	private int valor;

	public int getValor() {
		return this.valor;
	}
	
	public void incrementar(int valor) {
		this.valor += valor;
	}

	public void decrementar(int valor) {
		this.valor -= valor;
	}
	
	public void agregarAlCamino(Sala sala) {
		this.camino.add(sala);
	}
	
	public void quitarUltimo() {
		this.camino.remove(this.camino.size()-1);
	}
	
	public void marcarVisitado(Sala sala) {
		this.salasVisitadas.add(sala);
	}
	
	public void quitarVisitado(Sala sala) {
		this.salasVisitadas.remove(sala);
	}
	
	public boolean estaVisitado(Sala sala) {
		return this.salasVisitadas.contains(sala);
	}

	public ArrayList<Sala> getCamino() {
		return this.camino;
	}
	
	public void setCamino(ArrayList<Sala> camino) {
		this.camino.clear();
		this.camino.addAll(camino);
	}

	public void setValor(int valor) {
		this.valor = valor;
		
	}
}
