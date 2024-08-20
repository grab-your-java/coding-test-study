package baekjoon;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10828_Node {
	public static void main(String[] args) {
		
		class Node {
			int item;
			Node next;
			
			Node() {
				
			}
			
			Node(int item) {
				this.item = item;
			}
		}
		
		Node stack = null;
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		while (cnt > 0) {
			String method = sc.next();
			switch (method) {
			case "push" : 
				Node newNode = new Node(sc.nextInt());
				if (stack == null) {
					stack = newNode;
				} else {
					Node x = stack;
					while (x.next != null) {
						x = x.next;
					}
					x.next = newNode;
				}
				break;
				
			case "top" :
				if (stack == null) {
					System.out.println(-1);
					break;
				}
				
				Node y = stack;
				while (y.next != null) {
					y = y.next;
				}
				System.out.println(y.item);
				break;
			case "size" :
				int size = 0;
				Node p = stack;
				while (p.next != null) {
					p = p.next;
					size++;
				}
				size++;
				System.out.println(size);
				break;
				
			case "empty" :
				if (stack == null) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				
				break;
				
			default :
				if (stack == null) {
					System.out.println(-1);
					break;
				}
				
				Node q = stack;
				while (q.next != null) {
					q = q.next;
				}
				System.out.println(q.item);
				q = null;
			}
			
			cnt--;
		}
	}
}
