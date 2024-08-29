package swea_5215_햄버거_다이어트;

import java.util.Arrays;
import java.util.Scanner;

public class Improvement1 {
    static int CALORIE_LIMIT;
    static Ingredient[] INGREDIENTS;
    static int MAX_TASTE = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            int[] constraints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int N = constraints[0];
            CALORIE_LIMIT = constraints[1];
            INGREDIENTS = new Ingredient[N];
            for (int i = 0; i < INGREDIENTS.length; i++) {
                int[] inputs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                INGREDIENTS[i] = new Ingredient(inputs[0], inputs[1]);
            }

            calculate(0, 0, 0);

            System.out.println("#" + t + " " + MAX_TASTE);
            MAX_TASTE = 0;
        }
    }

    private static void calculate(int i, int accTaste, int accCal) {
        Ingredient cur = INGREDIENTS[i];
        if (accCal + cur.calorie > CALORIE_LIMIT) {
            MAX_TASTE = Math.max(MAX_TASTE, accTaste);
            return;
        }

        accTaste += cur.taste;
        accCal += cur.calorie;

        if (i == INGREDIENTS.length - 1) {
            MAX_TASTE = Math.max(MAX_TASTE, accTaste);
            return;
        }

        // for combination with next element
        for (int j = i + 1; j < INGREDIENTS.length; j++) {
            calculate(j, accTaste, accCal);
        }

    }


    private static class Ingredient {
        int taste;
        int calorie;

        Ingredient(int taste, int calorie) {
            this.taste = taste;
            this.calorie = calorie;
        }
    }
}
