package tp1;

import java.util.Iterator;

public class MyDoubleLinkedList implements Iterable<Integer>{

	private NodeDouble first;
	private int size;
	
	public MyDoubleLinkedList() {
		super();
		first = null;
	}
	
	public void insertFront(int info) {
		NodeDouble tmp = new NodeDouble(null, null, info);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new MyIterator(this.first);
	}
	
	public Integer size() {
		return size;
	}
}
