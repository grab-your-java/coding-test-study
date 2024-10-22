import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2115_3 {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static boolean[][] visited;
	static int maxProfit = 0;

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        for (int tc = 1; tc <= T; tc++) {
	            N = sc.nextInt(); // 벌통의 크기
	            M = sc.nextInt(); // 한명의 일꾼이 선택하는 벌집의 수
	            C = sc.nextInt(); // 벌꿀통에 담을 수 있는 꿀의 양
	            visited = new boolean[N][N];
	            map = new int[N][N];
	            for (int i = 0; i < map.length; i++) {
	                for (int j = 0; j < map.length; j++) {
	                    map[i][j] = sc.nextInt();
	                }
	            }

	            // 성능 측정을 위한 반복 측정
	            long totalDuration = 0;
	            int iterations = 1000; // 1000번 측정

	            for (int k = 0; k < iterations; k++) {
	                long startTime = System.nanoTime();
	                int result = combination();
	                long endTime = System.nanoTime();
	                totalDuration += (endTime - startTime);
	            }

	            long averageDuration = totalDuration / iterations;

	            System.out.println("#" + tc + " 평균 실행 시간: " + averageDuration + " 나노초");
	        }
	    }


	static int combination() {
		int result = 0;
		int max1 = 0;
		int max2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				maxProfit = 0;
				calculation(i, j, 0, 0, 0);
				max1 = maxProfit;

				maxProfit = 0;
				max2 = 0;
				for (int j2 = j + M; j2 < N - M + 1; j2++) { // 같은 행에서 고를 때
					calculation(i, j2, 0, 0, 0);
					max2 = Math.max(max2, maxProfit);
				}
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 < N - M + 1; j2++) {
						calculation(i2, j2, 0, 0, 0);
						max2 = Math.max(max2, maxProfit);
					}
				}
				result = Math.max(result, max1 + max2);
			}
		}
		return result;
	}

	static void calculation(int i, int j, int cnt, int sum, int profit) {
		if (sum > C) {
			return;
		}

		if (cnt == M) {
			maxProfit = Math.max(profit, maxProfit);
			return;
		}

		calculation(i, j + 1, cnt + 1, sum + map[i][j], profit + (map[i][j] * map[i][j]));
		calculation(i, j + 1, cnt + 1, sum, profit);

	}
}
/* 
10
4 2 13
6 1 9 7
9 8 5 8
3 4 5 3
8 2 6 7
3 3 10
7 2 9
6 6 6
5 5 7
4 1 10
8 1 8 2
4 6 1 6
4 9 6 3
7 4 1 3
4 3 12
8 8 6 5
5 2 7 4
8 5 1 7
7 8 9 4
5 2 11
7 5 9 9 6
7 3 7 9 3
1 7 1 4 5
1 7 9 2 6
6 6 8 3 8
6 3 20
8 5 2 4 3 1
4 3 6 1 1 8
4 4 1 2 3 1
1 7 4 9 6 1
6 5 1 2 8 4
3 1 4 5 1 3
7 2 11
2 8 2 5 2 8 6
2 3 7 4 6 4 8
3 7 8 3 9 4 4
8 8 5 9 3 6 9
9 7 6 2 4 1 3
2 9 2 8 9 7 3
2 1 7 2 7 8 3
8 3 12
9 1 6 7 5 4 6 7
9 5 1 8 8 3 5 8
5 2 6 8 6 9 2 1
9 2 1 8 7 5 2 3
6 5 5 1 4 5 7 2
1 7 1 8 1 9 5 5
6 2 2 9 2 5 1 4
7 1 1 2 5 9 5 7
9 4 20
5 2 4 8 3 7 6 2 1
7 9 8 5 8 2 6 3 6
1 9 4 6 7 5 3 1 1
4 4 7 6 2 2 8 1 7
9 6 8 5 7 3 7 9 5
7 3 1 4 1 1 8 5 3
4 6 8 9 4 5 3 8 8
1 3 4 2 4 1 1 3 6
5 9 2 3 5 2 4 8 5
10 5 30
7 4 7 5 9 3 6 4 6 7
8 9 8 4 5 7 8 9 2 9
6 5 3 4 6 4 7 6 3 2
4 7 4 3 4 7 3 3 4 3
3 5 6 4 8 8 2 1 8 6
3 7 9 7 1 7 6 2 8 9
3 6 1 6 8 9 7 7 5 1
4 3 5 6 2 1 2 6 3 6
3 4 9 2 1 5 9 9 6 3
9 9 7 3 7 5 5 5 8 4
*/
