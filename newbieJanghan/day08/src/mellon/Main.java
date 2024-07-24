package mellon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int height = 0;
        int width = 0;
        int spareArea = 0;

        // when direction doubled, multiply its distance with before distance
        // it would be spare area which should be subtracted;
        int[] directionCounter = new int[4];
        int lastDistance = 0;

        int iter = 6;
        while (iter-- > 0) {
            int dir = sc.nextInt();
            int distance = sc.nextInt();

            // case: already this direction proceeded
            if (directionCounter[dir - 1] > 0) {
                spareArea = lastDistance * distance;
            } else {
                // Set height, width
                if (dir == 3 || dir == 4) {
                    height = Math.max(height, distance);
                } else {
                    width = Math.max(width, distance);
                }
            }
            lastDistance = distance;
            directionCounter[dir - 1]++;
        }

        long area = (long) height * width - spareArea;
        System.out.println(P * area);
    }
}
