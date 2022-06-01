package tp4EJ1;

import java.util.ArrayList;

public class Backtracking {

	private Sala destino;
	private Solucion mejorSolucion;
	
	private void back(Estado estado) {
			
		if (this.destino.equals(estado.getPosActual())) { // Condicion de corte
			// Operar solucion
			if (this.mejorSolucion == null || this.mejorSolucion.getLargo() > estado.getLargo()) { //si no tengo mejor solucion o si la nueva es mejor que la vieja
				this.mejorSolucion = new Solucion(estado.getCaminoActual(),estado.getLargo()); 
			}
		} else { // Sino
			
			ArrayList<Sala> adyacentes = estado.getPosActual().getAdyacentes(); //vecinos a los que puedo acceder
			
			Sala original = estado.getPosActual();
			
			for (Sala adyacente: adyacentes) { // Por cada posible decisión / hijo
				
				if (!estado.estaVisitado(adyacente)) {
					
					// Aplico los cambios que resultan de tomar esa decisión
					estado.getCaminoActual().agregarAlCamino(adyacente); //agrego el adyacente al camino
					estado.setPosActual(adyacente);					//seteo la posicion actual como adyacente (me paro en adyacente)
					estado.incrementarCosto(1);					//le sumo 1 al largo del estado 
					estado.marcarVisitado(adyacente);					//marco como visitado el adyacente
					
					if (!poda(estado)) // Si no debo podar
						this.back(estado); // Llamo al backtracking
					
					// Deshago los cambios que resultaron de tomar esa decisión
					// Esto de deshacer lo tengo que hacer siempre al mismo nivel que agregue todo lo que quiero sacar
					estado.getCaminoActual().quitarUltimo();
					estado.setPosActual(original);
					estado.decrementarCosto(1);
					estado.desmarcarVisitado(adyacente);
					
				}
						
			}
		}
	}
	
	private boolean poda(Estado estado) {
		return (this.mejorSolucion != null && estado.getLargo() > this.mejorSolucion.getLargo()); //si tengo mejorSolucion y si el largo actual es mayor al 
	}																							//que tengo guardado: podo, porque no tendria sentido seguir sumando

	public Solucion back(Sala origen, Sala destino) {		
		this.destino = destino;
		this.mejorSolucion = null;
		
		// Generacion del estado inicial
		Estado estado = new Estado();
		estado.getCaminoActual().agregarAlCamino(origen);
		estado.setPosActual(origen);
		estado.incrementarCosto(1);
		estado.marcarVisitado(origen);
		
		// Llamo al bactracking desde ese estado incial
		this.back(estado);
				
		return this.mejorSolucion;
	}
}
