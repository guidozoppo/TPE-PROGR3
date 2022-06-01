package tpe;

import java.util.ArrayList;
import java.util.Iterator;


public class BuscadorLista {

	private Lector l1;
	private ArrayList<Libro> libros;
	private ArrayList<String> generos;
	private ListaSimple indice;
	
	public BuscadorLista() {
		generos = new ArrayList<>();
		l1 = new Lector();
		indice = new ListaSimple();
		libros = new ArrayList<>();
	}
	
	public void addLibro() {
		libros = l1.getLibros();
	}
	
	public void printLibros() {
		System.out.println(l1.getLibros());
	}
	
	private void setGeneros() { //indice interno con generos no repetidos
		for (Libro l : libros) {
			for(String g: l.getGeneros()) {
				if(!generos.contains(g)) {
					generos.add(g);
				}
			}
		}
	}
	
	public ArrayList<String> getGeneros(){
		return generos;
	}
		
	public void crearIndice() {
		this.setGeneros();
		for (String g: generos) {
			indice.insertFront(g);
		}
		
		Iterator<Node> it = indice.iterator();
		while(it.hasNext()) {
			Node nxt = it.next();
			nxt.setLibros(getLibrosPorGenero(nxt.getInfo()));
			System.out.println(nxt.getLibros());
		}
		
	}
	
	public ListaSimple getIndice(){
		return indice;
	}
/*
	public ArrayList<Libro> getLibro(String genero){
		int i = generos.indexOf(genero);
		return getIndice().get(i);
		//PARA TRAER LOS LIBROS HAY QUE RECORRER LA PRIMERA LISTA (INDICE) 
		 * VERIFICAR LA INFO
		 * Y RETORNAR LA LISTA DEL NODO
	}*/
	
	//ESTRUCTURA LISTA
	private ListaSimple getLibrosPorGenero(String genero){
		ListaSimple aux = new ListaSimple();
		for (Libro l : libros) {
			if(l.contieneGenero(genero)) {
				aux.insertFront(l.getTitulo());
			}
		}
		return aux;
	}
	
	
	
}