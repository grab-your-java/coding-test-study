import java.util.Scanner;

public class BOJ_13300 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 학생 수
        int k = sc.nextInt(); // 방에 들어갈 수 있는 최대 학생 수
        int cnt = 0;
        int[][] st = new int[2][6]; // [성별][학년]
        for (int i = 0; i < n; i++) {
            int gender = sc.nextInt(); // 0 or 1
            int grade = sc.nextInt(); // 1~6
            st[gender][grade - 1]++;
        }

        for (int gender = 0; gender < st.length; gender++) {
            for (int grade = 0; grade < st[0].length; grade++) {
                if (st[gender][grade] > 0 && st[gender][grade] <= k) {
                    cnt++;
                }
                if (st[gender][grade] > 0 && st[gender][grade] > k) {
                    if (st[gender][grade] % k == 0) {
                        cnt += st[gender][grade] / k;
                    } else
                        cnt += (st[gender][grade] / k) + 1;
                }
            }
        }
        System.out.println(cnt);

//        for (int gender = 0; gender < st.length; gender++) {
//            for (int grade = 0; grade < st[0].length; grade++) {
//                System.out.print(st[gender][grade] + " ");
//            }
//            System.out.println();
//        }

    }

}
