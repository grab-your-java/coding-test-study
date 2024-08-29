package stack;

import java.util.Arrays;

public class ArrayStack<T> {
	public int SIZE = 8;
	private T[] list = (T[]) new Object[0];
	private int top = -1;
	
	private void resize() {
		if (top < 0 || list.length <= 0) {
			list = (T[]) new Object[SIZE];
		} else if (top >= list.length) {
			list = Arrays.copyOf(list, list.length + SIZE);	
		} else if (top < list.length - SIZE) {
			list = Arrays.copyOf(list,  top+1);
		}
	}
	
	public void push(T val) {
		top++;
		this.resize();
		list[top] = val;
	}
	
	public T pop() {
		if (isEmpty()) return null;
		
		T value = this.list[top];
		
		top--;
		this.resize();
		
		return value;
	}
	
	public T peek() {
		if (isEmpty()) return null;
		
		return list[top];
	}
	
	public int size() {
		return this.top + 1;
	}
	
	public boolean isEmpty() {
		return this.list.length == 0 || this.top < 0;
	}
}