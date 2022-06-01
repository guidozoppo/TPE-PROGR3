package tp1;

public class NodeDouble extends Node {

	private Node previous;

	public NodeDouble() {
		super();
		this.previous = null;
	}
	
	public NodeDouble(Node previous, Node next, int info) {
		super(info, next);
		this.previous = previous;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	
	
}
