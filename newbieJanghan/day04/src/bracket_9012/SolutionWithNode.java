package bracket_9012;

import java.util.Scanner;
import java.util.Objects;

public class SolutionWithNode {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for (int i=0; i<N; i++) {
            NodeStack<String> stack = new NodeStack<>();
        	String str = sc.next();
        	
            for (int j=0; j<str.length(); j++) {
            	String cur = String.valueOf(str.charAt(j));
            	if (stack.isEmpty()) {
            		stack.push(cur);
            		continue;
            	}
            	
            	String peek = stack.peek();
            	
            	if (peek.equals("(") && cur.equals(")")) {
            		stack.pop();
            		continue;
            	}
            	
            	stack.push(cur);
            }
            
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
	}
    
    public static class NodeStack<T> {
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
}
