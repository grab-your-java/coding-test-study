package BOJ11403;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        int N = sc.nextInt();

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        //탐색-플로이드워셜
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(matrix[i][j]==1) continue;
                    matrix[i][j] = matrix[i][k] & matrix[k][j];
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
