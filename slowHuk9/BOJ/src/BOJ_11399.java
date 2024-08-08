import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] minute = new int[n];
		for (int i = 0; i < n; i++) {
			minute[i] = sc.nextInt();
		}
		Arrays.sort(minute);
		int sum = 0;
		for (int i = 0; i < minute.length; i++) {
			sum += minute[i];
			minute[i] = sum;
		}
		int result = 0;
		for (int i = 0; i < minute.length; i++) {
			result += minute[i];
		}
		System.out.println(result);
	}

}

