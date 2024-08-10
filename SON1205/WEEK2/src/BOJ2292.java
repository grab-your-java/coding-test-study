import java.util.Scanner;

public class BOJ2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = 1;
        int cnt = 1;

        int input = sc.nextInt();

        while (input > num) {
            num += cnt * 6;
            cnt++;
        }

        System.out.println(cnt);
    }
}
