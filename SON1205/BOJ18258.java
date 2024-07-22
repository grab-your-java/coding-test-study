package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ18258 {
	public static void main(String[] args) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			String keyword = sc.next();
			switch (keyword) {
				case "push" :
					queue.offer(sc.nextInt());
					break;
				case "pop":
					if (queue.isEmpty()) {
						System.out.println(-1);
						break;
					}
					System.out.println(queue.poll());
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					if (queue.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						System.out.println(-1);
						break;
					}
					System.out.println(queue.peekFirst());
					break;
				default:
					if (queue.isEmpty()) {
						System.out.println(-1);
						break;
					}
					System.out.println(queue.peekLast());
			}
		}
	}
}
