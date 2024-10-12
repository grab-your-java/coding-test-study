import java.util.Scanner;

public class SWEA_7733 {
    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };
    static int N;
    static int[][] cheese;
    static boolean[][] visited;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스
        for (int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();// 치즈 한변의 길이
            cheese = new int[N][N];
            // 치즈 칸마다 맛의 정도 입력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                }
            }
            int cnt = 1; // 덩어리는 1개부터 시작
            for (int day = 1; day <= 100; day++) {

                visited = new boolean[N][N];
                int tmp = 0; // day 별 덩어리 수
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (cheese[i][j] > day && !visited[i][j]) { // 아직 요정이 먹지 않고, 방문 하지 않았다면
                            dfs(i, j, day);
                            tmp++;
                        }
                    }
                }
                cnt = Math.max(tmp, cnt);

            }
            System.out.println("#" + tc + " " + cnt);
        }
    }

    private static void dfs(int i, int j, int day) {
        visited[i][j] = true;
        for (int k = 0; k < dr.length; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && cheese[nr][nc] > day) {
                dfs(nr, nc, day);
            }
        }
    }
}
