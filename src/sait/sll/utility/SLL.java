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
		this.head = null;
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
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		this.head = null;

	}

	@Override
	public void append(Object data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		//	System.out.println("This is the new node: "+ newNode.getElement());
		}
		this.size++;

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

		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node newNode = new Node(data);
		if (index == 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			Node currentNode = head;
			int currentIndex = 0; // current index
			while (currentNode != null && currentIndex < index - 1) {
				currentNode = currentNode.getNext();
				currentIndex++;
			}
			Node previousNode = currentNode; // set the previous node come before the node at the current index
			Node nextNode = currentNode.getNext(); // set the next node to go after the one we are adding
			previousNode.setNext(newNode);
			newNode.setNext(nextNode);
		}
		size++;

	}

	@Override
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// Check for valid size first
		if (index > this.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// traverse through list
		Node current = head;
		int currentIndexPosistion = 0;

		while (!(current == null) && currentIndexPosistion < index) {
			currentIndexPosistion++;
			current = current.getNext();
		}
		current.setElement(data);
	}

	/**
	 * This function will return the size of the SLL
	 * 
	 * @return the size of the linked list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * This function will delete a node at the specified index.
	 * 
	 * @throws IndexOutOfBoundsException
	 * @param index the index to remove the node at
	 */
	@Override
	public void delete(int index) throws IndexOutOfBoundsException {

		Node node = head;
		if (index >= size) {
			throw new IndexOutOfBoundsException("The index at: " + index + ", is out of bounds!");
		} else if (index == 0) {// head
			head = node.getNext();
			size--;
		} else {// between to tail

			for (int i = 0; i < index - 1; i++) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());
			size--;
		}
	}

	@Override
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// Check for valid size
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException();
		}

		// set the position of the current node to the head
		Node current = head;

		// move through the list
		if (index == 0) {// head
			return head.getElement();
		}
		
		for (int i = 0; i < this.size(); i++) {
			if(i == index) {
				//System.out.println("the index and iterator match");
				return current.getElement();
			}
			
			current = current.getNext(); // set the node to the next node
		}

		// return the element in the node
		return null;
	}

	/**
	 * @author Ben
	 */
	@Override
	public int indexOf(Object data) {

		int index = 0;
		Node current = head;
		while (current != null) {
			if (current.getElement().equals(data)) {
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
		// int index = 0;
		
		Node current = head;
		
		if (head == null) {
			return false;
		}

		//System.out.println("(contains method)This is the current " + current.getElement());
		//System.out.println();
		while (current != null) {
			if (current.getElement().equals(data)) {
				System.out.println("Made it here! "+ current.getElement());
				return true;
			} else {
				current = current.getNext();
			}
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
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
