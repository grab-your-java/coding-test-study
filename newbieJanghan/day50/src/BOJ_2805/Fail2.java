package BOJ_2805;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 시간 초과. 왜?
public class Fail2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] constraints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = constraints[0], M = constraints[1];
		int[] lens = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		HashMap<Integer, Integer> treeCnt = new HashMap<>();
		int MAX = lens[0];
		for (int len : lens) {
			MAX = Math.max(MAX, len);

			treeCnt.put(len, treeCnt.getOrDefault(len, 0) + 1);
		}

		int start = 0, end = MAX;
		while (start < end) {
			int mid = (start + end) / 2;
			long sum = 0;
			for (int sliced = mid + 1; sliced <= MAX; sliced++) {
				sum += (sliced - mid) * treeCnt.getOrDefault(sliced, 0);
			}

			if (sum < M) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(end - 1);
	}
}
