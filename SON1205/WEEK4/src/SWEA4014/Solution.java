package SWEA4014;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int X = sc.nextInt();

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = checkingColumn(map, X) + checkingRow(map, X);

            System.out.println("#" + tc + " " + result);
        }
    }

    static int checkingColumn(int[][] map, int x) {
        int result = 0;

        for (int i = 0; i < map.length; i++) {
            int idx = 1;

            boolean isValid = true;
            boolean[] visited = new boolean[map.length];
            while (idx < map.length && isValid) {
                int diff = Math.abs(map[idx][i] - map[idx - 1][i]);
                //exception
                if (diff == 0) {
                    idx++;
                    continue;
                } else if (diff > 1) {
                    isValid = false;
                    break;
                }

                //main logic
                if (map[idx][i] - map[idx - 1][i] > 0) {
                    for (int j = 1; j <= x; j++) {
                        if (idx - j < 0 || visited[idx - j] || map[idx - j][i] != map[idx - 1][i]) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        for (int j = 1; j <= x; j++) {
                            visited[idx - j] = true;
                        }
                    }
                } else {
                    for (int j = 0; j < x; j++) {
                        if (idx + j >= map.length || visited[idx + j] || map[idx + j][i] != map[idx][i]) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        for (int j = 0; j < x; j++) {
                            visited[idx + j] = true;
                        }
                    }
                }

                idx++;
            }

            if (isValid) {
//                System.out.println("c:" + i);
                result++;
            }
        }

        return result;
    }

    static int checkingRow(int[][] map, int x) {
        int result = 0;

        for (int i = 0; i < map.length; i++) {
            int idx = 1;

            boolean isValid = true;
            boolean[] visited = new boolean[map.length];
            while (idx < map.length && isValid) {
                int diff = Math.abs(map[i][idx] - map[i][idx - 1]);
                //exception
                if (diff == 0) {
                    idx++;
                    continue;
                } else if (diff > 1) {
                    isValid = false;
                    break;
                }

                //main logic
                if (map[i][idx] - map[i][idx - 1] > 0) {
                    for (int j = 1; j <= x; j++) {
                        if (idx - j < 0 || visited[idx - j] || map[i][idx - j] != map[i][idx - 1] ) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        for (int j = 1; j <= x; j++) {
                            visited[idx - j] = true;
                        }
                    }
                } else {
                    for (int j = 0; j < x; j++) {
                        if (idx + j >= map.length || visited[idx + j] || map[i][idx + j] != map[i][idx] ) {
                            isValid = false;
                            break;
                        }
                    }

                    if (isValid) {
                        for (int j = 0; j < x; j++) {
                            visited[idx + j] = true;
                        }
                    }
                }

                idx++;
            }

            if (isValid) {
//                System.out.println("r: " + i);
                result++;
            }
        }

        return result;
    }
}
