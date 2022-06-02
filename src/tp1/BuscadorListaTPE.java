package tp1;

import java.util.ArrayList;
import java.util.Iterator;

import tpe.Lector;


public class BuscadorListaTPE {

	private Lector l1;
	private ArrayList<Libro> libros;
	private ArrayList<String> generos;
	private ListaSimpleTPE indice;
	
	public BuscadorListaTPE() {
		generos = new ArrayList<>();
		l1 = new Lector();
		indice = new ListaSimpleTPE();
		libros = new ArrayList<>();
	}
	
	public void addLibro() {
		//libros = l1.getLibros();
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
		
		Iterator<NodeTPE> it = indice.iterator();
		while(it.hasNext()) {
			NodeTPE nxt = it.next();
			nxt.setLibros(getLibrosPorGenero(nxt.getInfo()));
			System.out.println(nxt.getLibros());
		}
		
	}
	
	public ListaSimpleTPE getIndice(){
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
	private ListaSimpleTPE getLibrosPorGenero(String genero){
		ListaSimpleTPE aux = new ListaSimpleTPE();
		for (Libro l : libros) {
			if(l.contieneGenero(genero)) {
				aux.insertFront(l.getTitulo());
			}
		}
		return aux;
	}
	
	
	
}