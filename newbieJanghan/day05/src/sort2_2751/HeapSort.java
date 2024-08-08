package sort2_2751;

import java.util.Scanner;

public class HeapSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] list = new int[N];

		// insert
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		// sort
		
		int[] result = new int[N];
		for (int i=0; i<result.length; i++) {
			makeMinHeap(list, list.length-i);
			printHeap(list, list.length-i);
			result[i] = list[0];
			swap(list, 0, list.length-1-i);
		}

		// print
		StringBuilder sb = new StringBuilder();
		for (int x: result) {
            sb.append(x).append("\n");
        }

        System.out.println(sb);
	}
	
	public static void makeMinHeap(int[] heap, int length) {
		for (int i = length / 2 - 1; i >= 0; i--) {
			minHeapify(heap, i, length);
		}
	}
	
	public static void minHeapify(int[] heap, int idx, int length) {
		int parent = idx;
		int left = 2*idx+1;
		int right = 2*idx+2;
		
		int minChild;	
		if (left < length && right < length) {
			minChild = heap[left] < heap[right] ? left : right;
		}
		else if (left >= length) {
			minChild = right;
		} 
		else if (right >= length) {
			minChild = left;
		}
		else {
			minChild = parent;
		}
		
		if (heap[parent] > heap[minChild]) {
			swap(heap, parent, minChild);
		}
	}
	
	public static void swap(int[] list, int a, int b) {
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}

	public static void printHeap(int[] heap, int length) {
		StringBuilder sb = new StringBuilder();
		int round = 1;
		int index = 0;
		while (round <= heap.length / 2) {
			int breadth = (int) Math.pow(2,  round-1);
			
			while (breadth > 0 && index < length) {
				sb.append(" " + heap[index] + " ");
				index++;
				breadth--;
			}
			sb.append(" / ");
			
			round++;
		}
		System.out.println(sb);
	}
}

