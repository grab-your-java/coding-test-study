import java.util.Scanner;

public class BOJ_11403 {
	static int N;
	static int[][] map;
	//플로이드 와샬
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// i 에서 j 까지 갈 수 있는가 = i 에서 j 까지, k를 거쳐서 갈 수 있는가?
		// map[i][k]와 map[k][j] 가 모두 1이면 갈 수 있는 것. 
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][k]==1 && map[k][j] ==1)
						map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+ " ");
			}System.out.println();
		}
	}
}
