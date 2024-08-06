import java.util.Scanner;

public class BOJ_8958 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int i = 1; i <= testCase; i++) {
			String s = sc.next();

			int j = 0;
			int sum = 0;
			int score = 0;
			
			while (j < s.length()) {
				if (s.charAt(j) == 'O') {
					score += 1;
					sum += score;
					j++;

				} else {
					score = 0;
					j++;

				}
			}
			System.out.println(sum);

		}
	}

}