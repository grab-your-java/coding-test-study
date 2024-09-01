import java.util.Scanner;

public class BOJ_2567 {
	static int cnt = 0;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int paperCnt = sc.nextInt();

		map = new int[101][101];
		for (int i = 0; i < paperCnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						// 테두리를 타면서 cnt ++을 해주면 되는데
						// 테두리를 타고 있다는 판단은, 4방향 탐색으로 한 방향이라도 다음칸에 0이 있으면 테두리 라는것. 
						if(map[nx][ny] == 0 || nx<0 || nx>100||ny<0 || ny > 100) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
