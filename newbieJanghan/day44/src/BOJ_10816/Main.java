package BOJ_10816;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());
		Map<Integer, Integer> map = new HashMap<>();
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < N; i++) {
			int key = arr[i];
			Integer val = map.get(key);
			if (val == null) {
				map.put(key, 1);
			} else {
				map.put(key, val + 1);
			}
		}

		int M = Integer.parseInt(sc.nextLine());
		int[] keys = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		StringBuilder sb = new StringBuilder();
		for (int key : keys) {
			Integer val = map.get(key);
			if (val == null) {
				sb.append(0).append(" ");
			} else {
				sb.append(val).append(" ");
			}

		}

		System.out.println(sb);
	}
}
