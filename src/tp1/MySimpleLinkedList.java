package tp1;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Integer>{

	private Node first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	

	public void insertFront(int info) {
		Node tmp = new Node(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}
	
	public Integer extractFront() {		
		if (this.first != null) {
			Node tmp = this.first;
			this.first = this.first.getNext();
			this.size--;
			return tmp.getInfo();
		} else {
			return null;
		}
		
	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	public int get(int index) {
		int contador = 0;
		Node tmp = this.first;
		while(contador < index) {
			tmp = tmp.getNext();
			contador++;
		}
		return tmp.getInfo();
	}
	
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
	public Iterator<Integer> iterator(){
		return new MyIterator(this.first);
	}
	
	public void ordenarLista(MySimpleLinkedList lista) {
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

	public boolean buscar(Integer e, MySimpleLinkedList l2) {
		boolean esta = false;
		for (Integer el: l2) {
			if(el == e) {
				esta = true;
			}
		}
		return esta;
	}
	
	public MySimpleLinkedList buscarComun(MySimpleLinkedList l1, MySimpleLinkedList l2) {
		MySimpleLinkedList aux = new MySimpleLinkedList();
		for (Integer el1: l1) {
			if(l1.buscar(el1, l2)) {
				aux.insertFront(el1);
			}
		}
		aux.ordenarLista(aux);
		return aux;
	}
	
	public MySimpleLinkedList primeraSiSegundaNo(MySimpleLinkedList l1, MySimpleLinkedList l2) {
		MySimpleLinkedList aux = new MySimpleLinkedList();
		for (Integer el1: l1) {
			if(!l1.buscar(el1, l2)) {
				aux.insertFront(el1);
			}
		}
		aux.ordenarLista(aux);
		return aux;
	}
}
