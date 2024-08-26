package jungol_1206_조커;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numberCnt = new int[1000001];
        while (N-- > 0) {
            numberCnt[sc.nextInt()]++;
        }

        int jokerCnt = numberCnt[0];
        int maxJokerUsage = 0, maxStraight = 0;
        for (int number = 1; number < numberCnt.length; number++) {
            // 반례 여지 있음.
            if (numberCnt[number] == 0) {
                continue;
            }

            int straight = 1;
            int jokerUsage = 0;
            for (int nextNum = number + 1; nextNum < numberCnt.length; nextNum++) {
                if (numberCnt[nextNum] == 0) {
                    if (jokerUsage == jokerCnt) {
                        break;
                    }
                    jokerUsage++;
                }
                straight++;
            }

            if (straight > maxStraight) {
                maxStraight = straight;
                maxJokerUsage = jokerUsage;
            }

        }
        System.out.println(maxStraight + jokerCnt - maxJokerUsage);

    }
}