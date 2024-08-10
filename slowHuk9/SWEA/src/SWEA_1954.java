import java.util.Scanner;

public class SWEA_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();


		for (int i = 1; i <= testCase; i++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			int x = 0;
			int y = 0;
			
			int direction = 0; // 우 하 좌 상
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };
			int num = 1;
			//맵에 숫자채우기
			while (num <= N * N) {
				map[x][y] = num;
				num++;

				int nx = x + dx[direction];
				int ny = y + dy[direction];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
					x = nx;
					y = ny;
				} else {
					direction = (direction + 1) % 4;
					x = x + dx[direction];
					y = y + dy[direction];
				}
			}
			
			
			System.out.println("#" + i);
			// 숫자 출력
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					System.out.print(map[j][k] + " ");
				}
				System.out.println();
			}
			

		}

	}

}
