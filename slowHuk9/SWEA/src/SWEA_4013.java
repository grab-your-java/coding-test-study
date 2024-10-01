import java.util.Scanner;

public class SWEA_4013 {
	static int[][] magnetic = new int[5][8];
	static int[] arrow = new int[5]; // {0 , 0, 0 , 0, 0}
	static int N = magnetic[1].length;
	static boolean[] visited = new boolean[5];
	static int score, K;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			 K = sc.nextInt(); // 회전횟수
			for (int i = 1; i < 5; i++) {
				for (int j = 0; j < 8; j++) {
					magnetic[i][j] = sc.nextInt();
				}
			}
			score = 0;

			for (int i = 0; i < K; i++) {
			int selectMagnet = sc.nextInt(); // 회전시킬 자석 번호
			int direction = sc.nextInt(); // 회전 방향 / 1 시계 -1 반시계
			spin(selectMagnet, direction, 0);
			score = calculate();
			}
			System.out.println(score);
		}
	}

	static void spin(int i, int direction, int depth) {
		if (i < 4 && magnetic[i][2] == magnetic[i + 1][6]) {
			System.out.println("1111");
			return;
		}
		
		if(depth == K) {
			System.out.println("DEPTH == K");
			return;
		}

		// 재귀
		if (i > 1 && magnetic[i - 1][2] != magnetic[i][6] && !visited[i-1]) { // 왼쪽 자석과 날이 다를 경우
			if (direction == 1) {
				arrow[i] = (arrow[i] + N + 1) % N;
				visited[i] = true;
				spin(i - 1, -direction, depth +1);
				visited[i] = false;
			}
			if (direction == -1) {
				arrow[i] = (arrow[i] + N - 1) % N;
				visited[i] = true;
				spin(i - 1, -direction, depth +1);
				visited[i] = false;
			}
		}
		if (i < 4 && magnetic[i][2] != magnetic[i + 1][6] && !visited[i+1]) { // 오른 자석과 날이 다른 경우
			if (direction == 1) {
			
				System.out.println(i+"번 자석" + direction + "이므로 시계방향 회전");
				System.out.println("before 화살표 인덱스 : " + arrow[i]);
				arrow[i] = (arrow[i] + N + 1) % N;
				System.out.println("after 화살표 인덱스 : " + arrow[i]);
				visited[i] = true;
				spin(i + 1, -direction, depth +1);
				visited[i] = false;
				System.out.println("호출");
			}
			if (direction == -1) {
				arrow[i] = (arrow[i] + N - 1) % N;
				visited[i] = true;
				spin(i + 1, -direction, depth +1);
				visited[i] = false;
			}
		}

	}

	static int calculate() {
		int sum = 0;
		for (int i = 1; i < arrow.length; i++) {
			if (i == 1 && magnetic[i][arrow[i]] == 1) {
				sum += magnetic[i][arrow[i]] * 1;
			}
			if (i == 2 && magnetic[i][arrow[i]] == 1) {
				sum += magnetic[i][arrow[i]] * 2;
			}
			if (i == 3 && magnetic[i][arrow[i]] == 1) {
				sum += magnetic[i][arrow[i]] * 4;
			}
			if (i == 4 && magnetic[i][arrow[i]] == 1) {
				sum += magnetic[i][arrow[i]] * 8;
			}
		}
		return sum;
	}

}