package BOJ_10158_ant;

import java.util.Scanner;

public class BOJ_10158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();

        int p = sc.nextInt();
        int q = sc.nextInt();

        int t = sc.nextInt();

        p = (p + t) % (2 * w);
        q = (q + t) % (2 * h);

        if (p > w)
            p = w - (p - w);
        if (q > h)
            q = h - (q - h);

        System.out.println(p + " " + q);

        sc.close();
    }
}