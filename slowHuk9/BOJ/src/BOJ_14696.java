import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 라운드 수
		for (int i = 1; i <= n; i++) {
			int cnt = sc.nextInt(); // 카드의 수
			int[] A = new int[cnt];
			int[] Acount = new int[4]; // { 별, 동그라미, 네모, 세모}
			for (int j = 0; j < cnt; j++) {
				A[j] = sc.nextInt();
				if (A[j] == 4) {
					Acount[0]++;
				} else if (A[j] == 3) {
					Acount[1]++;
				} else if (A[j] == 2) {
					Acount[2]++;
				} else {
					Acount[3]++;
				}
			}
			cnt = sc.nextInt();
			int[] B = new int[cnt];
			int[] Bcount = new int[4]; // { 별, 동그라미, 네모, 세모}
			for (int j = 0; j < cnt; j++) {
				B[j] = sc.nextInt();
				if (B[j] == 4) {
					Bcount[0]++;
				} else if (B[j] == 3) {
					Bcount[1]++;
				} else if (B[j] == 2) {
					Bcount[2]++;
				} else {
					Bcount[3]++;
				}
			}
			for (int j = 0; j < Bcount.length; j++) {
				if (Acount[j] > Bcount[j]) {
					System.out.println("A");
					break;
				} else if (Acount[j] < Bcount[j]) {
					System.out.println("B");
					break;
				}
			}
			if (Arrays.equals(Acount, Bcount)) {
				System.out.println("D");
			}
		}
	}

}