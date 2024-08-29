package SWEA;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SWEA_5658_보물상자비밀번호 {
	public static int getNum(String s) {
		switch (s) {
		case "A":
			return 10;
		case "B":
			return 11;
		case "C":
			return 12;
		case "D":
			return 13;
		case "E":
			return 14;
		case "F":
			return 15;
		default:
			return Integer.parseInt(s);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			int maxIdx = sc.nextInt();
			String str = sc.next();
			Queue<String> q = new ArrayDeque<>();
			for (int i = 0; i < str.length(); i++) {
				q.offer(str.substring(i, i + 1));
			}
			Set<String> list = new HashSet<>();
			for (int k = 0; k < size / 4; k++) {
				for (int i = 0; i < 4; i++) {
					String txt = "";
					for (int j = 0; j < size / 4; j++) {
						String s = q.poll();
						txt += s;
						q.offer(s);
					}
					list.add(txt);

				}
				q.offer(q.poll());
			}
			int[] num = new int[size];
			for (int i = 0; i < list.size(); i++) {
				String str1 = (String) list.toArray()[i];
				int cnt = 0;
				for (int j = 0; j < str1.length(); j++) {
					cnt += getNum(str1.substring(j, j + 1)) * Math.pow(16, str1.length() - 1 - j);
				}
				num[i] = cnt;
			}
			Arrays.sort(num);
			System.out.println("#" + tc + " " + num[num.length - maxIdx]);
		}
	}

}
