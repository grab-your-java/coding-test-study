import java.util.Scanner;

public class BOJ_1107_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();
		int N = sc.nextInt();
		boolean[] broken = new boolean[10];
		for (int i = 0; i < N; i++) {
			broken[sc.nextInt()] = true;
		}

		int result = Math.abs(target - 100);

		for (int i = 0; i <= 999999; i++) {
			String num = String.valueOf(i);

			boolean pushBrokenBtn = false;
			for (int j = 0; j < num.length(); j++) {
				if (broken[num.charAt(j) - '0']) {
					pushBrokenBtn = true;
					break;
				}
			}
			if (!pushBrokenBtn) { // 고장난 번호를 누르지 않았다면
				int min = Math.abs(target - i) + num.length();
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}
}
