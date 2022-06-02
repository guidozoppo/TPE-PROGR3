package tpe;

import java.util.ArrayList;


public class Biblioteca {

	private Lector lector;
	private ArrayList<Libro> libros;
	private ArrayList<ArrayList<Libro>> busqueda;
	private ArrayList<Genero> generos;
	
	public Biblioteca() {
		generos = new ArrayList<>();
		lector = new Lector();
		busqueda = new ArrayList<>();
		libros = new ArrayList<>();
	}
	
	public void addLibro() {
		libros = lector.getLibros();
	}
		
	public void addGenero(Genero g) {
		generos.add(g);
	}
	
	public boolean contieneGenero(Genero gen) { //se evalua si la biblioteca ya tiene el genero creado
		return generos.contains(gen);	
	}
	
	
	private void setGeneros() { //Se evalua si el genero existe(se le agrega el libro) y si no existe(se crea el genero y se agrega el libro)
		for (Libro l : libros) {
			for(Genero g: l.getGeneros()) { //por cada genero del libro
				if(this.contieneGenero(g)) {
					int i = getGeneros().indexOf(g);
					getGeneros().get(i).addLibro(l);
				}
				else {
					Genero g1 = new Genero(g.getNombre());
					this.addGenero(g1);
					g1.addLibro(l);
				}
			}
		}
	}
	
	public ArrayList<Genero> getGeneros(){
		return new ArrayList<>(generos);
	}
	
	private ArrayList<Libro> getLibrosPorGenero(Genero genero){
		return genero.getLibros();
	}
	
	public void crearBusqueda() {
		this.setGeneros();
		for (Genero g: generos) { //por cada genero, se le agrega en su posicion los libros 
			busqueda.add(generos.indexOf(g), getLibrosPorGenero(g));
		}
		
	}
	
	public ArrayList<ArrayList<Libro>> getBusqueda(){
		return new ArrayList<>(busqueda);
	}

	public ArrayList<Libro> getLibros(Genero genero){
		int i = generos.indexOf(genero);
		return getBusqueda().get(i);
	}

	
	
	
}