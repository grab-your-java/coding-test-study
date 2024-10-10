package PGM_할인행사;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        int answer = solution.solution(want, number, discount);
        System.out.println(answer);
    }
}
