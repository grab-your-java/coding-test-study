import java.util.Scanner;

public class BOJ_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 0;

		while (n > 0) {
			if (n % 5 == 0) { // 5로 나누어 떨어질때
				cnt += n / 5;
				System.out.println(cnt);
				return;
			}
			if (n < 3) { 
				System.out.println(-1);
				return;
			} else { //5로 안될 때, 3kg 짜리 봉투 하나를 만들고 총 봉투 갯수 +1 해준다.
				n -= 3;
				cnt++;

			}
		}
		System.out.println(cnt);
	}

}
