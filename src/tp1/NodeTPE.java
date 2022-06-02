	package tp1;

public class NodeTPE {
	private String info;
	private NodeTPE next;
	private ListaSimpleTPE libros;

	public NodeTPE() {
		this.info = null;
		this.next = null;
		this.libros = null;
	}
	
	public NodeTPE(String info, NodeTPE next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public NodeTPE getNext() {
		return next;
	}
	
	public void addListaLibros(ListaSimpleTPE lb) {
		libros = lb;
	}

	public void setNext(NodeTPE next) {
		this.next = next;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	public ListaSimpleTPE getLibros() {
		return libros;
	}

	public void setLibros(ListaSimpleTPE libros) {
		this.libros = libros;
	}

	public String toString() {
		return " " + this.getInfo();
	}
	

	
	

}
