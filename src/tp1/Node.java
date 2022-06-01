	package tp1;

public class Node {
	private Integer info;
	private Node next;

	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(int info, Node next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
	
	
	
	public String toString() {
		return " " + this.getInfo();
	}
	

	
	

}
