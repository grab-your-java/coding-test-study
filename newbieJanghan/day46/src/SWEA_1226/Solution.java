package SWEA_1226;

import java.util.Scanner;

public class Solution {
    static char[][] map;
    static boolean[][] visited;
    static boolean answer;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int tc = 10;
        while (tc-- > 0) {
            sb.append("#").append(sc.nextLine()).append(" ");

            map = new char[16][16];
            int startY = -1, startX = -1;

            for (int y = 0; y < 16; y++) {
                char[] row = sc.nextLine().toCharArray();
                for (int x = 0; x < 16; x++) {
                    if (row[x] == '2') {
                        startY = y;
                        startX = x;
                    }
                    map[y][x] = row[x];
                }
            }

            answer = false;
            visited = new boolean[16][16];

            visited[startY][startX] = true;
            dfs(startY, startX);

            sb.append(answer ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        if (answer || map[y][x] == '3') {
            answer = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (0 <= ny && ny < 16 && 0 <= nx && nx < 16 && map[ny][nx] != '1' && map[ny][nx] != '2' && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}
