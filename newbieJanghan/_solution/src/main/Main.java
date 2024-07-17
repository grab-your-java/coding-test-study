package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for (int i=0; i<N; i++) {
        	String command = sc.next();
        	
            switch (command) {
	            case "push":
	            	queue.push(sc.nextInt());
	            	break;
	            case "pop":
	            	System.out.println(queue.isEmpty() ? -1 : queue.poll());
	            	break;
            	case "front":
            		System.out.println(queue.isEmpty() ? -1 : queue.getFirst());
	            	break;
            	case "back":
            		System.out.println(queue.isEmpty() ? -1 : queue.getLast());
	            	break;
            	case "size":
            		System.out.println(queue.size());
            		break;
            	case "empty":
            		System.out.println(queue.isEmpty() ? 1 : 0);
            }
            
        }
	}
}