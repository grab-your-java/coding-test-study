import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_3052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		int[] remainder = new int[10];

		List<Integer> remainderList = new ArrayList<>();

		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			remainder[i] = num[i] % 42;
		}
//		System.out.println(Arrays.toString(num));
//		System.out.println(Arrays.toString(remainder));

		for (int i = 0; i < remainder.length; i++) {
			if (!remainderList.contains(remainder[i])) {
				remainderList.add(remainder[i]);
			}
		}
		System.out.println(remainderList.size());

	}

}
