package stack;

import java.util.Objects;

public class NodeStack<T> {
	private class Node<T> {
		private T value;
		private Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	private Node<T> top;
	private int size = 0;
	
	public boolean isEmpty() {
		return Objects.isNull(top) && size == 0;
	}
	
	public void push(T value) {
		Node<T> node = new Node<T>(value);
		
		if (!isEmpty()) node.next = top;
		this.top = node;
		size++;
	}
	
	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			T value = top.value;
			top = top.next;
			size--;
			
			return value;
		}
	}
	
	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return top.value;
		}
	}
	
	public int size() {
		return this.size;
	}
}
