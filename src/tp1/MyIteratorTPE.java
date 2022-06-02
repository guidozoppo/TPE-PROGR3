package tp1;

import java.util.Iterator;

public class MyIteratorTPE implements Iterator<NodeTPE>{

	private NodeTPE cursor;
	
	public MyIteratorTPE(NodeTPE cursor) {
		this.cursor = cursor;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public NodeTPE next() {
		NodeTPE valor = this.cursor;
		this.cursor = this.cursor.getNext();
		return valor;
	}

}
