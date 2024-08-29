package swea_5658_보물상자_비밀번호;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(sc.nextLine().split(" ")[1]);
            String[] nums = sc.nextLine().split("");
            Queue<String> cap = new LinkedList<>(Arrays.asList(nums));

            int numberLength = nums.length / 4;
            int cycleCount = nums.length / 4;
            Set<Integer> numberSet = new HashSet<>();

            while (cycleCount-- > 0) {
                // 경우의 수
                int count = 0;
                LinkedList<String> temp = new LinkedList<>();
                while (count++ < nums.length) {
                    temp.add(cap.poll());

                    if (temp.size() == numberLength) {
                        int number = 0;
                        while (!temp.isEmpty()) {
                            double position = temp.size() - 1;
                            String numStr16 = temp.poll();
                            number += (int) (Math.pow(16, position) * parse16to10(numStr16));

                            cap.add(numStr16);
                        }
                        numberSet.add(number);
                        temp.clear();
                    }
                }

                // 턴 종료
                cap.add(cap.poll());
            }

            Integer[] sorted = numberSet.stream().sorted((a, b) -> b - a).toArray(Integer[]::new);
            System.out.println("#" + t + " " + sorted[K - 1]);
        }
    }

    static int parse16to10(String string) {
        return switch (string) {
            case "A" -> 10;
            case "B" -> 11;
            case "C" -> 12;
            case "D" -> 13;
            case "E" -> 14;
            case "F" -> 15;
            default -> Integer.parseInt(string);
        };
    }
}