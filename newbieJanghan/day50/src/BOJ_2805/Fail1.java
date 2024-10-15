package BOJ_2805;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Fail1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] constraints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = constraints[0], M = constraints[1];
		int[] lens = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		HashMap<Integer, Integer> treeCnt = new HashMap<>();
		int MAX = 0;
		for (int len : lens) {
			MAX = Math.max(MAX, len);
			int cur = treeCnt.getOrDefault(len, 0);
			treeCnt.put(len, cur + 1);
		}

		int sum = 0, answer = MAX;
		for (answer = MAX; answer >=0; answer--) {
			for (int cur = answer + 1; cur <=MAX; cur++) {
				sum += treeCnt.getOrDefault(cur, 0); 
			}

			System.out.println("divide " + answer + " sum " + sum);
			if (sum >= M) {
				break;
			}
		}

		System.out.println(answer);
	}

}
