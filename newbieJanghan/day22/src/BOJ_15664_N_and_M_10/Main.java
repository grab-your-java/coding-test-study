package BOJ_15664_N_and_M_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static String[] numbers;
	static int size;
	static Map<String, Boolean> sequenceMap = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	/**
	 * Constraints 
	 * 
	 * 1. 조합 & 비내림차순 수열 
	 * 2. 조합 원소의 중복 체크 
	 * 3. 사전 순 증가 순서
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = Integer.parseInt(sc.nextLine().split(" ")[1]);
		numbers = sc.nextLine().split(" ");

		/**
		 * Key 1, 3. 미리 문자열을 숫자 값 오름차순으로 정렬해두면, 조합 생성 시 비내림차순과 사전 순 증가를 반영할 수 있다.
		 */
		Arrays.sort(numbers, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));

		combination(new String[size], 0, 0);
		System.out.println(sb);
	}

	static void combination(String[] sequence, int depth, int start) {
		if (depth == size) {
			if (unique(sequence)) {
				for (String num : sequence) {
					sb.append(num + " ");
				}
				sb.append("\n");
			}

			return;
		}

		for (int i = start; i < numbers.length; i++) {
			sequence[depth] = numbers[i];
			/**
			 * Key 1. 중복 조합을 피하기 위해 
			 * 재귀 함수에 순회 시작 인덱스를 현재 index + 1 를 start 인자로 넣어서
			 * 다음 뎁스에서 본인을 순회 대상에서 제외함.
			 */
			combination(sequence, depth + 1, i+1);
		}
	}

	/**
	 * Key 2. 중복 체크
	 */
	static boolean unique(String[] sequence) {
		String key = "";
		for (String string : sequence) {
			key += string + "-";
		}

		boolean exist = sequenceMap.computeIfAbsent(key, (k) -> false);
		if (!exist) {
			sequenceMap.put(key, true);
		}

		return !exist;
	}
}
