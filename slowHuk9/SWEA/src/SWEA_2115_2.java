import java.util.Scanner;

public class SWEA_2115_2 {
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

        if (j < N && !visited[i][j]) {
            // 현재 위치 방문 처리
            visited[i][j] = true;

            // 현재 위치 선택
            calculation(i, j + 1, cnt + 1, sum + map[i][j], profit + (map[i][j] * map[i][j]));

            // 현재 위치 선택하지 않음
            calculation(i, j + 1, cnt + 1, sum, profit);

            // 방문 처리 해제
            visited[i][j] = false;
        } else if (j < N) {
            // 현재 위치를 건너뛰고 다음 위치로 이동
            calculation(i, j + 1, cnt, sum, profit);
        }
    }
}
