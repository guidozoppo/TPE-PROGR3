package tp1;

import java.util.ArrayList;

public class Libro {

	private String titulo, autor;
	private int cantPaginas;
	private ArrayList<String> generos;
	
	public Libro(String titulo, String autor, int cantPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.cantPaginas = cantPaginas;
		this.generos = new ArrayList<>();
	}

	@Override
	public String toString() {
		return titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(int cantPaginas) {
		this.cantPaginas = cantPaginas;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}

	public void addGeneros(String genero) {
		this.generos.add(genero);
	}
	
	public boolean contieneGenero(String genero) {
		return generos.contains(genero);
	}
	
}
