import java.util.Scanner;

public class SWEA_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int p = 1; p <= t; p++) {

			int n = sc.nextInt();
			int[][] map = new int[n][n];

			int x = 0;
			int y = 0;
			int num = 1;
			int direction = 0; // 0: 오른쪽, 1: 아래 2: 왼쪽 3: 위
			int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상 행 기준
			int[] dy = { 1, 0, -1, 0 }; // 우 하 좌 상 열 기준

			while (num <= n * n) {
				map[x][y] = num;
				num++;

				int nx = x + dx[direction]; // 다음 x 값은, x + 진행방향에 따른 x 변동값
				int ny = y + dy[direction];
				// 다음으로 이동할 칸이 배열 안에 있고, 값이 0(없다면) 그대로
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 0) {
					x = nx;
					y = ny;
				} else { // 다음 이동 칸이 배열 밖이라면 진행방향을 바꾼다.
					direction = (direction + 1) % 4; // 0--> 1, 1--> 2, 2--> 3, 3--> 0 // 90도 회전
					x = x + dx[direction]; // x = x + dx[1] 
					y = y + dy[direction];
				}

			}
			System.out.println("#" + p);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}