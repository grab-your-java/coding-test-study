package swea.D3;

import java.util.Scanner;

public class SWEA_6485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] canGoStation = new int[N][2];
			for (int i = 0; i < N; i++) {
				canGoStation[i][0] = sc.nextInt();
				canGoStation[i][1] = sc.nextInt();
			}
			int P = sc.nextInt();
			int[] wantKnow = new int[P];
			for (int i = 0; i < P; i++) {
				wantKnow[i] = sc.nextInt();
			}
			int[] ans = new int[P];
			for (int i = 0; i < P; i++) {
				for (int j = 0; j < N; j++) {
					if (wantKnow[i] >= canGoStation[j][0] && wantKnow[i] <= canGoStation[j][1])
						ans[i]++;

				}
			}
			System.out.print("#" + tc);
			for (int i = 0; i < P; i++) {
				System.out.print(" " + ans[i]);
			}
            System.out.println();
		}
	}
}
