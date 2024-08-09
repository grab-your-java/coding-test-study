import java.util.Scanner;

public class SWEA_1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int testCase = sc.nextInt();
			// 사다리 초기화
			int[][] ladder = new int[100][100];
			int x = -1; // 도착지점의 좌표는 (99,x)이다.
			// 사다리에 값을 넣고
			for (int i = 0; i < ladder.length; i++) {
				for (int j = 0; j < ladder.length; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			// 가장 아래줄 i=99 에서 2의 j 좌표를 찾고
			for (int j = 0; j < ladder.length; j++) {
				if (ladder[99][j] == 2) {
					x = j; //
					break;
				}
			}
			//한칸 씩 위로 이동
			for (int i = 99; i >= 0; i--) {
				// 왼쪽에 1이 있다면
				if (x > 0 && ladder[i][x - 1] == 1) {
					// 1의 개수만큼 왼쪽으로 이동
					while (x > 0 && ladder[i][x - 1] == 1) {
						x--;
					}
				} else if (x < 99 && ladder[i][x + 1] == 1) {
					while (x < 99 && ladder[i][x + 1] == 1) {
						x++;
					}
				}
			}
			System.out.println("#" + testCase + " " + x);
		}
	}
}
