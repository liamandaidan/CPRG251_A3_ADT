package sait.sll.utility;

public class SLL implements LinkedListADT {

	private Node head;
	private Node tail;
	private int size;

	/**
	 * 
	 */
	public SLL() {
		super();
		this.size = 0;
	}

	/**
	 * @param head
	 * @param tail
	 * @param size
	 */
	public SLL(Node head, Node tail, int size) {
		super();
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		this.head = null;

	}

	@Override
	public void append(Object data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);
		newNode.setNext(this.head);
		head = newNode;
		size++;

	}

	@Override
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int index) throws IndexOutOfBoundsException {

		Node node = head;
		if (index >= size) {
			throw new IndexOutOfBoundsException("out of bounds!");
		} else if (index == 0) {//head
			head = node.getNext();
			size--;
		}else {//between to tail

			for (int i = 0; i < index-1; i++) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());
			size--;
		}
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object data) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return this.size;

	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
