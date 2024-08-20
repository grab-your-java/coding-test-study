package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int i = 1; i <= TC; i++) {
			String[] inputs = sc.next().split("");
			
			Stack<String> stack = new Stack<>();
			
			int cut = 0;
			
			for (int j = 0; j < inputs.length; j++) {
				if ("(".equals(inputs[j])) {
					stack.push(inputs[j]);
				} else if (")".equals(inputs[j]) && "(".equals(inputs[j - 1])) {
					stack.pop();
					cut += stack.size();
				} else {
					stack.pop();
					cut++;
				}
			}
			
			System.out.println("#" + i + " " + cut);
		}
	}
	
	static class Stack<T> {
		List<T> input = new ArrayList<>();
		
		public boolean push(T item) {
			return input.add(item);
		}
		
		public T pop() {
			if (isEmpty()) {
				return null;
			}
			
			return input.remove(input.size() - 1);
		}
		
		public T peek() {
			return input.get(input.size() - 1);
		}
		
		public boolean isEmpty() {
			if (input.size() == 0) {
				return true;
			}
			
			return false;
		}
		
		public int size() {
			return input.size();
		}
	}
}