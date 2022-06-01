	package tpe;

public class Node {
	private String info;
	private Node next;
	private ListaSimple libros;

	public Node() {
		this.info = null;
		this.next = null;
		this.libros = null;
	}
	
	public Node(String info, Node next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public Node getNext() {
		return next;
	}
	
	public void addListaLibros(ListaSimple lb) {
		libros = lb;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	public ListaSimple getLibros() {
		return libros;
	}

	public void setLibros(ListaSimple libros) {
		this.libros = libros;
	}

	public String toString() {
		return " " + this.getInfo();
	}
	

	
	

}
