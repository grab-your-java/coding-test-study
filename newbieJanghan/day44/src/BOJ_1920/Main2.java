package BOJ_1920;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<Integer, Boolean> map = new HashMap<>();
		int N = sc.nextInt();
		while (N-- > 0) {
			map.put(sc.nextInt(), true);
		}

		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		while (M-- > 0) {
			if (map.get(sc.nextInt()) == null) {
				sb.append("0");
			} else {
				sb.append("1");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
