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
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author Ben
	 */
	@Override
	public int indexOf(Object data) {
		
		int index = 0;
		Node current = head.getNext();
		while(current != null)
		{
			if(current.equals(data))
			{
				return index;
			}
			index++;
			current = current.getNext();
		}
		return -1;
	}
	/**
	 * @author Ben
	 */
	@Override
	public boolean contains(Object data) {
		int index = 0;
		Node current = head.getNext();
		while(current != null)
		{
			if(current.equals(data))
			{
				return true;
			}
			index++;
			current = current.getNext();
		}
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
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	

}
