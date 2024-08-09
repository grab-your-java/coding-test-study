import java.util.Scanner;

public class SWEA_1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 1; i <= t; i++) {
			int day = sc.nextInt();
			int[] arr = new int[day];

			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			int max = 0;
			long result = 0;

			for (int j = arr.length - 1; j >= 0; j--) {
				max = Math.max(max, arr[j]);

				int profit = max - arr[j];
				result += profit;

			}

			System.out.println("#" + i + " " + result);
		}
	}

}
