package tpe;

import java.util.Iterator;

public class ListaSimple implements Iterable<Node>{

	private Node first;
	private int size;
	
	public ListaSimple() {
		this.first = null;
		this.size = 0;
	}
	

	public void insertFront(String info) {
		Node tmp = new Node(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}
	

	public boolean isEmpty() {
		return this.first == null;
	}
	
	/*
	public int get(int index) {
		int contador = 0;
		Node tmp = this.first;
		while(contador < index) {
			tmp = tmp.getNext();
			contador++;
		}
		return tmp.getInfo();
	}*/
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String aux = "";
		int contador = 0;
		Node tmp = this.first;
		while(contador < this.size) {
			aux += tmp.toString() + " - ";
			tmp = tmp.getNext();
			contador++;
		}
		return aux;
	}

	@Override
	public Iterator<Node> iterator(){
		return new MyIterator(this.first);
	}
	
	/*
	public void ordenarLista(ListaSimple lista) {
		if(size > 1) { 
			boolean cambio;
			do {
				Node actual = this.first;
				Node anterior = null;
				Node siguiente = first.getNext();
				cambio = false;
				while (siguiente != null) {
					if(actual.getInfo() > siguiente.getInfo()) {
						cambio = true;
						if(anterior != null) {
							Node sig = siguiente.getNext();
							anterior.setNext(siguiente);
							siguiente.setNext(actual);
							actual.setNext(sig);
						} else {
							Node sig = siguiente.getNext();
							first = siguiente;
							siguiente.setNext(actual);
							actual.setNext(sig);
						}
						anterior = siguiente;
						siguiente = actual.getNext();
					} else {
						anterior = actual;
						actual = siguiente;
						siguiente = siguiente.getNext();
					}
				}
			} while (cambio);
		} 
		
	}

	public boolean buscar(Integer e, ListaSimple l2) {
		boolean esta = false;
		for (Integer el: l2) {
			if(el == e) {
				esta = true;
			}
		}
		return esta;
	}
	
	public ListaSimple buscarComun(ListaSimple l1, ListaSimple l2) {
		ListaSimple aux = new ListaSimple();
		for (Integer el1: l1) {
			if(l1.buscar(el1, l2)) {
				aux.insertFront(el1);
			}
		}
		aux.ordenarLista(aux);
		return aux;
	}
	
	public ListaSimple primeraSiSegundaNo(ListaSimple l1, ListaSimple l2) {
		ListaSimple aux = new ListaSimple();
		for (Integer el1: l1) {
			if(!l1.buscar(el1, l2)) {
				aux.insertFront(el1);
			}
		}
		aux.ordenarLista(aux);
		return aux;
	}
	
	*/
}
