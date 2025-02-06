package 실버;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724 {
	static int ans, cnt, line;
	static boolean check[];
	static List<Integer>[] list;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		line = sc.nextInt();
		list = new ArrayList[cnt];
		ans = 0;
		check = new boolean[cnt];
		q = new ArrayDeque<>();
		for (int i = 0; i < cnt; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < line; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < cnt; i++) {
			if (!check[i]) {
				check[i] = true;
				getAns(i);
			}
		}
		System.out.println(ans);
	}

	private static void getAns(int origin) {
		q.add(origin);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < list[now].size(); i++) {
				if (!check[list[now].get(i)]) {
					check[list[now].get(i)] = true;
					q.add(list[now].get(i));
				}
			}
		}
		ans++;
	}
}
