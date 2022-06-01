package tpe;

import java.util.ArrayList;


public class Buscador {

	private Lector l1;
	private ArrayList<Libro> libros;
	private ArrayList<String> generos;
	private ArrayList<ArrayList<Libro>> indice;
	
	public Buscador() {
		generos = new ArrayList<>();
		l1 = new Lector();
		indice = new ArrayList<>();
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
	
	private ArrayList<Libro> getLibrosPorGenero(String genero){
		ArrayList<Libro> aux = new ArrayList<>();
		for (Libro l : libros) {
			if(l.contieneGenero(genero)) {
				aux.add(l);
			}
		}
		return aux;
	}
	
	public void crearIndice() {
		this.setGeneros();
		for (String g: generos) {
			indice.add(generos.indexOf(g), getLibrosPorGenero(g));
		}
		
	}
	
	public ArrayList<ArrayList<Libro>> getIndice(){
		return indice;
	}

	public ArrayList<Libro> getLibro(String genero){
		int i = generos.indexOf(genero);
		return getIndice().get(i);
	}

	
	
	
}