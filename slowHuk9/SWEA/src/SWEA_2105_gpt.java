import java.util.Scanner;

public class SWEA_2105_gpt {
    static int N, maxDessert;
    static int[][] cafe;
    static boolean[] visited;
    static int[] dx = {1, 1, -1, -1}; // 하우, 하좌, 상좌, 상우
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            cafe = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cafe[i][j] = sc.nextInt();
                }
            }

            maxDessert = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[101];
                    dfs(i, j, i, j, 0, 0, -1);
                }
            }
            System.out.println("#" + t + " " + (maxDessert == -1 ? -1 : maxDessert));
        }
        sc.close();
    }

    static void dfs(int x, int y, int startX, int startY, int dir, int count, int lastDir) {
        if (visited[cafe[x][y]]) return;
        visited[cafe[x][y]] = true;
        for (int d = 0; d < 4; d++) {
            if (lastDir != -1 && (d < lastDir || d > lastDir + 1)) continue; // 방향은 이전 방향에서 +1, 0
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[cafe[nx][ny]]) {
                    dfs(nx, ny, startX, startY, d, count + 1, d);
                } else if (nx == startX && ny == startY && count >= 3) {
                    maxDessert = Math.max(maxDessert, count + 1);
                    visited[cafe[x][y]] = false;
                    return;
                }
            }
        }
        visited[cafe[x][y]] = false;
    }
}
