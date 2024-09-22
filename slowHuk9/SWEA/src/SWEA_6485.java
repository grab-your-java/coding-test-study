
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6485 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();

			int[] busStopList = new int[5001];

			for (int i = 0; i < n; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				for (int j = start; j <= end; j++) {
					busStopList[j]++;
				}
			}
			int P = sc.nextInt();
			int[] arr = new int[P];
			for (int i = 0; i < P; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(busStopList[arr[i]] + " ");
			}
			System.out.println();

		}
	}

}
