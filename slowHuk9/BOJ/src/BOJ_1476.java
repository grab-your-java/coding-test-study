import java.util.Scanner;

public class BOJ_1476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		int e = 0;
		int s = 0;
		int m = 0;
		int year = 0;
//		E   1 ~ 15
//		S   1 ~ 28
//		M  1 ~ 19
		while (true) {
			if (e == E && s == S && m == M) {
				break;
			}
			e++;
			s++;
			m++;
			if (e == 16) {
				e = 1;
			}
			if (s == 29) {
				s = 1;
			}
			if (m == 20) {
				m = 1;
			}
			year++;
			System.out.println(year);
			System.out.println("E = " + e);
			System.out.println("S = " + s);
			System.out.println("M = " + m);
			System.out.println("-----------------------------------------------");
		}
		System.out.println(year);
	}

}
