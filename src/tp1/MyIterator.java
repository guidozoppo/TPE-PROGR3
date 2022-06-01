package tp1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer>{

	private Node cursor;
	
	public MyIterator(Node cursor) {
		this.cursor = cursor;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public Integer next() {
		Integer valor = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		return valor;
	}

}
