import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14696 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 라운드 수
        for (int i = 1; i <= n; i++) {
            int cnt = sc.nextInt(); // 카드의 수
            int[] A = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                A[j] = sc.nextInt();
            }
            cnt = sc.nextInt();
            int[] B = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                B[j] = sc.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B);
            System.out.println(Arrays.toString(A));
            System.out.println(Arrays.toString(B));
            
            
        }

    }

}