package tp4EJ2;

import java.util.ArrayList;

public class Backtracking {

	private Casillero destino;
	private Solucion mejorSolucion;
	
	private void back(Estado estado) {
			
		if (this.destino.equals(estado.getPosActual())) { // Condicion de corte
			// Operar solucion
			if (this.mejorSolucion == null || this.mejorSolucion.getCosto() > estado.getCosto()) { //si no tengo mejor solucion o si la nueva es mejor que la vieja
				this.mejorSolucion = new Solucion(estado.getCaminoActual(),estado.getCosto()); 
			}
		} else { // Sino
			
			ArrayList<Casillero> vecinos = estado.getPosActual().getVecinos(); //vecinos a los que puedo acceder
			
			Casillero original = estado.getPosActual();
			
			for (Casillero vecino: vecinos) { // Por cada posible decisión / hijo
				
				if (!estado.estaVisitado(vecino)) {
					
					// Aplico los cambios que resultan de tomar esa decisión
					estado.getCaminoActual().agregarAlCamino(vecino); //agrego el vecino al camino
					estado.setPosActual(vecino);					//seteo la posicion actual a vecino (me paro en vecino)
					estado.incrementarCosto(vecino.getValor());		//le sumo el costo del vecino al costo total
					estado.marcarVisitado(vecino);					//marco como visitado el vecino
					
					if (!poda(estado)) // Si no debo podar
						this.back(estado); // Llamo al backtracking
					
					// Deshago los cambios que resultaron de tomar esa decisión
					// Esto de deshacer lo tengo que hacer siempre al mismo nivel que agregue todo lo que quiero sacar
					estado.getCaminoActual().quitarUltimo();
					estado.setPosActual(original);
					estado.decrementarCosto(vecino.getValor());
					estado.desmarcarVisitado(vecino);
					
				}
						
			}
		}
	}
	
	private boolean poda(Estado estado) {
		return (this.mejorSolucion != null && estado.getCosto() > this.mejorSolucion.getCosto()); //si tengo mejorSolucion y si el costo actual es mayor al 
	}																							//que tengo guardado corto, porque no tendria sentido seguir sumando

	public Solucion back(Casillero origen, Casillero destino) {		
		this.destino = destino;
		this.mejorSolucion = null;
		
		// Generacion del estado inicial
		Estado estado = new Estado();
		estado.getCaminoActual().agregarAlCamino(origen);
		estado.setPosActual(origen);
		estado.incrementarCosto(origen.getValor());
		estado.marcarVisitado(origen);
		
		// Llamo al bactracking desde ese estado incial
		this.back(estado);
				
		return this.mejorSolucion;
	}
}
