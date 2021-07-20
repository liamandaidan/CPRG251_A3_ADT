package sait.sll.utility;

public class Node {
	
	private Object element;
	private Node successor;
	
	/**
	 * 
	 */
	public Node() {
		
	}

	/**
	 * @param element
	 */
	public Node(Object element) {
		super();
		this.element = element;
		this.successor = null;
	}

	/**
	 * @return the element
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(Object element) {
		this.element = element;
	}

	/**
	 * @return the successor
	 */
	public Node getNext() {
		return successor;
	}

	/**
	 * @param successor the successor to set
	 */
	public void setNext(Node successor) {
		this.successor = successor;
	}
	
	
	
	
	

}
