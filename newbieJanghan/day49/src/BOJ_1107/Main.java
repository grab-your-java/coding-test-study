package BOJ_1107;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		if (n == 100) {
			System.out.println(0);
			return;
		}

		boolean[] broken = new boolean[10];
		while (m-- > 0) {
			broken[sc.nextInt()] = true;
		}

		int lower = n;
		while (lower > 0) {
			int[] numbers = Arrays.stream(String.valueOf(lower).split("")).mapToInt(Integer::parseInt).toArray();

			int invalidIdx = numbers.length;
			for (int i = 0; i < numbers.length; i++) {
				if (broken[numbers[i]]) {
					invalidIdx = i;
					break;
				}
			}

			if (invalidIdx == numbers.length) {
				break;
			}

			int tmp = 0;
			for (int i = 0; i < numbers.length; i++) {
				int position = numbers.length - i - 1;

				if (i == invalidIdx) {
					tmp += numbers[i] * (int) Math.pow(10, position) - 1;
					break;
				}
				tmp += numbers[i] * (int) Math.pow(10, position);
			}

			lower = tmp;
		}

		int upper = n;
		while (upper < 1000000) {
			int[] numbers = Arrays.stream(String.valueOf(upper).split("")).mapToInt(Integer::parseInt).toArray();

			int invalidIdx = numbers.length;
			for (int i = 0; i < numbers.length; i++) {
				if (broken[numbers[i]]) {
					invalidIdx = i;
					break;
				}
			}

			if (invalidIdx == numbers.length) {
				break;
			}

			int tmp = 0;
			for (int i = 0; i < numbers.length; i++) {
				int position = numbers.length - i - 1;

				if (i == invalidIdx) {
					tmp += (numbers[i] + 1) * (int) Math.pow(10, position);
					break;
				}
				tmp += numbers[i] * (int) Math.pow(10, position);
			}

			upper = tmp;
		}

		boolean isLowerValid = isValid(lower, broken), isUpperValid = isValid(upper, broken);
		if (!isLowerValid && !isUpperValid) {
			System.out.println(Math.abs(100 - n));
			return;
		}

		int approximate;
		if (isLowerValid && isUpperValid) {
			if (upper - n < n - lower) {
				approximate = upper;
			} else {
				approximate = lower;
			}
		} else if (isLowerValid) {
			approximate = lower;
		} else {
			approximate = upper;
		}

		int moveCnt = Math.abs(n - approximate);
		int inputCnt = getIntLength(approximate);

		System.out.println(Math.min(moveCnt + inputCnt, Math.abs(100 - n)));

	}

	static int getIntLength(int number) {
		int cnt = 1;
		while (number / 10 >= 1) {
			cnt++;
			number /= 10;
		}

		return cnt;
	}

	static boolean isValid(int n, boolean[] broken) {
		int[] numbers = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
		for (int number : numbers) {
			if (broken[number]) {
				return false;
			}
		}

		return true;
	}
}
