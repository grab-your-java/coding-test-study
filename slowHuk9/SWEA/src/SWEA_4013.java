import java.util.Scanner;

public class SWEA_4013 {
	static int[][] magnetic = new int[5][8];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt(); // 회전횟수
		for (int i = 1; i <=4 ; i++) {
			for (int j = 1; j <= 8; j++) {
				magnetic[i][j] = sc.nextInt();
			}
		}
			for (int i = 0; i < K; i++) {
				int selectMagnet = sc.nextInt();
				int direction = sc.nextInt();
				spin(selectMagnet, direction);
			}
		}
	}
	
	static void spin(int selectMagnet, int direction) {
		
	}

}
