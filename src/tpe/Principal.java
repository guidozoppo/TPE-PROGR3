package tpe;

public class Principal {

	public static void main(String[] args) {
		Buscador b1 = new Buscador();
		b1.addLibro();
		b1.crearIndice();
		//System.out.println(b1.getGeneros());
		
		//System.out.println(b1.getLibro("thriller"));
		//System.out.println(b1.getLibrosPorGenero("cine"));
		
		BuscadorLista b2 = new BuscadorLista();
		b2.addLibro();
		b2.crearIndice();
		System.out.println(b2.getIndice());
	}

}
