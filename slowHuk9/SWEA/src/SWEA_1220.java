import java.util.Scanner;
import java.util.Stack;

public class SWEA_1220 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            int[][] table = new int[n][n];
            int cnt = 0;

            // 테이블 값 입력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    table[i][j] = sc.nextInt();
                }
            }

            // 교착 상태 카운팅
            for (int j = 0; j < n; j++) {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < n; i++) {
                    if (table[i][j] != 0) {
                        if (!stack.isEmpty() && (stack.peek() == 1 && table[i][j] == 2)) {
                            cnt++;
                            stack.clear();  // 교착 상태 발생 시 스택 초기화
                        } else {
                            stack.push(table[i][j]);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}
