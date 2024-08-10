package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class BOJ10828_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int capacity = 8;
		int[] stack = new int[capacity];
		int size = 0;
		
		int cnt = sc.nextInt();
		
		while (cnt > 0) {
			String method = sc.next();
			switch (method) {
			case "push" : 
				if (size == capacity) {
					capacity *= 2;
					stack = Arrays.copyOf(stack, capacity);
				}
				
				int item = sc.nextInt();
				
				stack[size++] = item;
				break;
			case "top" :
				if (size == 0) {
					System.out.println(-1);
					break;
				}
				System.out.println(stack[size - 1]);
				break;
			case "size" :
				System.out.println(size);
				break;
			case "empty" :
				if (size == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			default :
				if (size == 0) {
					System.out.println(-1);
					break;
				}
				
				System.out.println(stack[size - 1]);
				stack[size - 1] = 0;
				size--;
			}
			
			cnt--;
		}
	}
}
