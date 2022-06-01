package tpe;

import java.util.Iterator;

public class MyIterator implements Iterator<Node>{

	private Node cursor;
	
	public MyIterator(Node cursor) {
		this.cursor = cursor;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public Node next() {
		Node valor = this.cursor;
		this.cursor = this.cursor.getNext();
		return valor;
	}

}
