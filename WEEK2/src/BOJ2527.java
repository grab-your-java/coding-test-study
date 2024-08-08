import java.util.Scanner;

public class BOJ2527 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            int[] square1 = new int[4];
            int[] square2 = new int[4];

            for (int j = 0; j < 8; j++) {
                if (j / 4 == 0) {
                    square1[j] = sc.nextInt();
                } else {
                    square2[j % 4] = sc.nextInt();
                }
            }

            if (square2[2] < square1[0] || square1[2] < square2[0]) {
                System.out.println("d");
            } else if (square2[2] == square1[0] || square2[0] == square1[2]) {
                if (square2[1] > square1[3] || square2[3] < square1[1]) {
                    System.out.println("d");
                } else if (square2[1] == square1[3] || square2[3] == square1[1]) {
                    System.out.println("c");
                } else {
                    System.out.println("b");
                }
            } else {
                if (square2[1] > square1[3] || square2[3] < square1[1]) {
                    System.out.println("d");
                } else if (square2[1] == square1[3] || square2[3] == square1[1]) {
                    System.out.println("b");
                } else {
                    System.out.println("a");
                }
            }

        }
    }
}
