package tpe;

public class Principal {

	public static void main(String[] args) {
		Biblioteca b1 = new Biblioteca();
		b1.addLibro();
		b1.crearBusqueda();
		Genero g1 = new Genero("cine");

		
		System.out.println(b1.getLibros(g1));
		Escritor e1 = new Escritor();
		e1.escribirArchivo(b1.getLibros(g1));
		
	}

}
