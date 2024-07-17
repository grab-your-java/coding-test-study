package day03;

import java.util.Scanner;
import java.util.LinkedList;

public class WithLinkedList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		
		// Mapping
		for (int i=1; i<=N; i++) {
			list.add(i);
		}
		
		// poll or add after poll
		boolean pollOnly = true;
		while (list.size() > 1) {
			int polled = list.poll();
			
			if (pollOnly) {
				pollOnly = false;
			} else {
				list.add(polled);
				pollOnly = true;
			}
		}
		
		System.out.println(list.poll());
	}
	
}
