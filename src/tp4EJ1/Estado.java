package tp4EJ1;

public class Estado {
	private Sala posActual;
	private Camino caminoActual;
	private int largo;

	public int getLargo() {
		return largo;
	}

	public void setLargo(int costo) {
		this.largo = costo;
	}

	public Camino getCaminoActual() {
		return caminoActual;
	}

	public void setCaminoActual(Camino caminoActual) {
		this.caminoActual = caminoActual;
	}

	public Sala getPosActual() {
		return posActual;
	}

	public void setPosActual(Sala posActual) {
		this.posActual = posActual;
	}

	public void incrementarCosto(int valor) {

	}

	public void decrementarCosto(int valor) {
		// TODO Auto-generated method stub

	}

	public boolean estaVisitado(Sala vecino) {
		// TODO Auto-generated method stub
		return false;
	}

	public void marcarVisitado(Sala vecino) {
		// TODO Auto-generated method stub

	}

	public void desmarcarVisitado(Sala vecino) {
		// TODO Auto-generated method stub

	}
}
