package queue;

import java.util.Arrays;

public class ArrayQueue<T> {
	public int CAPACITY = 8;
	private int top = -1;
	private T[] list = (T[]) new Object[0];
	
	public boolean isEmpty() {
		return list.length == 0;
	}
	
	public int size() {
		return list.length;
	}
	
	public void push(T value) {
		this.resize();
		list[list.length] = value;
	}
	
	public T pop() {
		this.resize();
		return list[top++];
	}
	
	public T front() {
		if (isEmpty()) return null;
		return list[0];
	}
	
	public T back() {
		if (isEmpty()) return null;
		return list[list.length-1];
	}
	
	private void resize() {
		if (top >= list.length-1) {
			list = (T[]) new Object[CAPACITY]; 
		} else if (list.length % CAPACITY == 7) {
			list = Arrays.copyOf(list, list.length + CAPACITY);
		}
	}
}
