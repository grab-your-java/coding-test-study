package swea;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA6485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();

			Map<Integer, Integer> busStop = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				for (int j = A; j <= B; j++) {
					busStop.put(j, busStop.getOrDefault(j, 0) + 1);
				}
			}
			
			int P = sc.nextInt();
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < P; j++) {				
				sb.append(busStop.getOrDefault(sc.nextInt(), 0) + " ");
			}
			
			System.out.println("#" + TC + " " + sb.toString());
		}
	}
}
