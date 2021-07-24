package sait.sll.utility;

import java.io.*;

/**
 * @author Mike
 * @author Ben
 * @author Liam
 * @author Robyn
 * 
 * This class is the implementation of LinkedListADT. Is also serializable. 
 */

public class SLL implements LinkedListADT, Serializable {

	private Node head;
	private Node tail;
	private int size;
	
	

	/**
	 * Constructor, no parameters, creates an empty linked list
	 */
	public SLL() {
		super();
		this.head = null;
		this.size = 0;
	}

	/**
	 * Constructor, creates a SLL with 3 params.
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

	/**
	 * Will return if a SLL is empty.
	 * @return true/false if list is empty
	 */
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

	/**
	 * Create a new SLL at the end of the current queue.
	 * @param Object the object to be appended to the list
	 * @throws IOException if the FileOutputStream can't find the file specified
	 */
	@Override
	public void append(Object data) throws IOException {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node currentNode = head;
			
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();	
			}
			

			FileOutputStream fos = new FileOutputStream("res/test.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			System.out.println("file created");
			
			oos.writeObject(currentNode.getElement()); 
			System.out.println("list item written");
			
			oos.reset();

			oos.close();
			fos.close();
			
			currentNode.setNext(newNode);

		}
		this.size++;	
	

	}

	/**
	 * Will add a new node at the start of the SLL.
	 * @param Object the object to be added to the start of the list
	 */
	@Override
	public void prepend(Object data) {
		Node newNode = new Node(data);
		newNode.setNext(this.head);
		head = newNode;
		size++;

	}

	/**
	 * Will insert a Node into a position specified by the method call.
	 * @param Object the object to be appended to the list
	 * @param index the position in the list for the object to be added
	 * @throws IndexOutOfBoundsException if the index falls outside the bounds of the list size
	 */
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

	/**
	 * Will replace a node at index with another.
	 * @param Object the new object
	 * @param index the position of the existing object to be replaced
	 * @throws IndexOutOfBoundsException if the index falls outside the bounds of the list size
	 */
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
	 * @author Liam McLaughlin
	 * @return the size of the linked list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * This function will delete a node at the specified index.
	 * @throws IndexOutOfBoundsException
	 * @param index the index to remove the node at
	 * @author Liam McLaughlin
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

	/**
	 * This function will retrieve a node at the specified index.
	 * @throws IndexOutOfBoundsException
	 * @param index the index to remove the node at
	 * @return whatever is at the specified index
	 */
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
	 * This method will search a SLL and return the index of a match.
	 * @author Ben
	 * @param the data of the object to be located
	 * @return the index of the found object, or -1 if the object isn't found
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
	 * This method will return a T/F if a SLL contains an object.
	 * @author Ben
	 * @param the data of the object to be located
	 * @return true/false if the object is located in the list
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
	 * Return the head of a SLL.
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * Set a reference to a new head of a SLL.
	 * @param head the head to set
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * Get the tail of a SLL.
	 * @return the tail
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * Set the tail reference of a SLL.
	 * @param tail the tail to set
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * Sets the size of the SLL.
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
