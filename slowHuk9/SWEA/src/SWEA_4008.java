import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4008 {
	static int N;
	static int[] opCnt;
	static char[] op;
	static boolean[] visited;
	static char[] input;
	static int[] nums;
	static int[] numsCopy;
	static int min;
	static int max;
	static ArrayList<Integer> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			opCnt = new int[5];
			op = new char[5];
			visited = new boolean[N];
			nums = new int[N];
			numsCopy = new int[N];

			op[1] = '+';
			op[2] = '-';
			op[3] = '*';
			op[4] = '/';
			input = new char[N - 1];
			list = new ArrayList<>();
			for (int i = 1; i < opCnt.length; i++) {
				opCnt[i] = sc.nextInt();
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i] = sc.nextInt();
			}

			int idx = 0;
			for (int i = 1; i < opCnt.length; i++) {
				for (int j = 0; j < opCnt[i]; j++) {
					input[idx++] = op[i];
				}
			} // 연산자 배열 저장 완료
			char[] output = new char[N - 1];
			 min = Integer.MAX_VALUE;
			 max = Integer.MIN_VALUE;
			permutation(0, output);
			
			int result = max - min;
			System.out.println("#" + tc + " " + result);

		}
	}

	static void permutation(int depth, char[] output) {
		if (depth == N - 1) {
			for (int i = 0; i < nums.length; i++) {
				numsCopy[i] = nums[i];
			}
			for (int i = 0; i < N - 1; i++) {
				if (output[i] == '+') {
					numsCopy[i + 1] = numsCopy[i] + numsCopy[i + 1];
				}
				if (output[i] == '-') {
					numsCopy[i + 1] = numsCopy[i] - numsCopy[i + 1];
				}
				if (output[i] == '*') {
					numsCopy[i + 1] = numsCopy[i] * numsCopy[i + 1];
				}
				if (output[i] == '/') {
					numsCopy[i + 1] = numsCopy[i] / numsCopy[i + 1];
				}
			}
			min = Math.min(min, numsCopy[numsCopy.length-1]);
			max = Math.max(max, numsCopy[numsCopy.length-1]);
			return;
		}
		for (int i = 0; i < output.length; i++) {
			if (!visited[i + 1]) {
				visited[i + 1] = true;
				output[depth] = input[i];
				permutation(depth + 1, output);
				visited[i + 1] = false;
			}
		}
	}

}
