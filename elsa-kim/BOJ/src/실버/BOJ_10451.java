package 실버;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10451 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			int[] list = new int[size];
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] check = new boolean[size];
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				list[i] = sc.nextInt() - 1;
			}
			for (int i = 0; i < size; i++) {
				if (!check[i]) {
					cnt++;
					check[i] = true;
					q.add(i);
					while (!q.isEmpty()) {
						int n = q.poll();
						if (!check[list[n]]) {
							q.add(list[n]);
							check[list[n]] = true;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
