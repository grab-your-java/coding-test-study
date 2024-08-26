
import java.util.Scanner;

public class SWEA_5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 좌괄호가 계속되면 막대가 지속, (다음에 바로 )가 오면 그건 레이저 -> 개수를 더해줘야함
		// 바로앞이 )이 아닌데 )가 나오면 막대가 하나 줄어드는 것
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String input = sc.next();

			boolean prevIsOpen = false;
			int sum = 0;
			int bar = 0;
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c == '(') {
					// 좌괄호는 막대 or 레이저
					sum++;
					bar++;
					prevIsOpen = true;

				} else if (c == ')' && prevIsOpen) {
					// 레이저인 경우
					sum--;
					bar--; // bar의 개수를 하나 감소

					// bar가 1개씩 쪼개짐 -> bar의 개수만큼 sum에 추가
					sum += bar;
					prevIsOpen = false;
				} else {
					// 막대 하나가 끝남
					bar--;

					prevIsOpen = false;

				}

			}
			System.out.println("#" + test_case + " " + sum);

		}
	}

}