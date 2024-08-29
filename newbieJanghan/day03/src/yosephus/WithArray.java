package yosephus;

import java.util.Scanner;
import java.util.ArrayList;

public class WithArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i=1; i<=N; i++) {
			list.add(i);
		}
		
		
		ArrayList<Integer> result = new ArrayList<>();
		
		int idx = 0; 
		int counter = N;
		
		while (counter > 0) {
			idx += K-1;
			// modify idx
			if (idx >= list.size()) {
				idx %= list.size();
			}
			
			// remove element
			counter--;
			result.add(list.remove(idx));
		}
		
		System.out.print("<");
		for (int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
			if (i<result.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
}
