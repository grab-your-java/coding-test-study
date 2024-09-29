package BOJ11047;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			stack.push(sc.nextInt());
		}
		
		int result = 0;
		
		while (K > 0) {
			int coin = stack.pop();
			int tmp = K / coin;
			
			if (tmp > 0) {
				result += tmp;
				
				K %= coin;
			}
		}
		
		System.out.println(result);
	}
}
