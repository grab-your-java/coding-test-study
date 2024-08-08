import java.util.Scanner;

public class BOJ_10163 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int paper = sc.nextInt();

        int[][] map = new int[1001][1001];
        for (int i = 1; i <= paper; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int width = sc.nextInt();
            int height = sc.nextInt();

            for (int j = x; j < x + width; j++) { 
                for (int k = y; k < y + height; k++) {
                    map[j][k] = i;
                }
            }
        }

        for (int i = 1; i <= paper; i++) {
            int area = 0;
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    if (map[j][k] == i) {
                        area++;
                    }
                }
            }
            System.out.println(area);
        }
    }
}