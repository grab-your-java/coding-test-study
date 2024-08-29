import java.util.Scanner;

public class SWEA_1220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];

		int x = 0;
		int y = 0;
		int result = 0;
		// 값 입력 0 or 1 or 2
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int j = 0; j < map.length; j++) {
			for (int i = 0; i < map.length; i++) {
				if (map[i][j] == 1) {
					x++; // 
				}
				if (map[i][j] == 2) {
					y++;
				}
				if(x == 1 && y== 1) {
					result ++;
				}
				
			}
		}
		
		System.out.println(result);
	}

}
