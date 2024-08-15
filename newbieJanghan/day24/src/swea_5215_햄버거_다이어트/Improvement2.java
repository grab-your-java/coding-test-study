package swea_5215_햄버거_다이어트;

import java.util.Arrays;
import java.util.Scanner;

public class Improvement2 {
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

    private static void calculate(int start, int accTaste, int accCal) {
        // 1. evaluate this scope
        // a. validate calorie limit
        if (accCal > CALORIE_LIMIT) {
            return;
        }
        // b. update max taste
        if (accTaste > MAX_TASTE) {
            MAX_TASTE = accTaste;
        }

        // 2. try to combine next element
        // validation of these combinations would be done at next scope.
        for (int i = start; i < INGREDIENTS.length; i++) {
            calculate(i + 1, accTaste + INGREDIENTS[i].taste, accCal + INGREDIENTS[i].calorie);
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
