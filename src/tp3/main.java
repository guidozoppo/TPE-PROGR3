package tp3;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class main {

	public static void main(String[] args) {
		GrafoDirigido<String> grafo = new GrafoDirigido();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		/*grafo.agregarVertice(6);
		grafo.agregarVertice(7);*/
		
		grafo.agregarArco(1, 2, "Asd");
		grafo.agregarArco(2, 3, "Asd");
		grafo.agregarArco(2, 4, "Asd");
		grafo.agregarArco(3, 4, "Asd");
		grafo.agregarArco(3, 5, "Asd");
		grafo.agregarArco(5, 4, "Asd");
		
		
		/*EJERCICIO 4
		 * EncontrarCaminoLargo ec = new EncontrarCaminoLargo(grafo);
		System.out.println(ec.encontrarCaminos(1, 4));*/
		
		//EJERCICIO 5
		//Ejercicio5 ec = new Ejercicio5(grafo);
		//System.out.println(ec.encontrarCaminos(3));
		
		/*
		EncontrarTodosLosCaminos etlc = new EncontrarTodosLosCaminos(grafo);
		System.out.println(etlc.encontrarCaminos(1, 4));
		*/
		
		/*
		EncontrarCamino ecn = new EncontrarCamino(grafo, 1, 4);
		System.out.println(ecn.encontrarUnCamino(1, 4));
		 */
		
		
	}

}
