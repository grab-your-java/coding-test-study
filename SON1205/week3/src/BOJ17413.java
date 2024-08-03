import java.util.Scanner;

public class BOJ17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("");

        int prevIdx = 0;
        int idx = 0;

        while (idx < input.length) {
            if (input[idx].equals("<")) {
                swap(input, prevIdx, idx);
                prevIdx = idx;
                for (int i = idx + 1; i < input.length; i++) { // 문제 잘 읽자...
                    if (input[i].equals(">")) {
                        prevIdx = idx = i + 1;
                        break;
                   }
                }
            } else if (input[idx].equals(" ")) {
                swap(input, prevIdx, idx);
                prevIdx = ++idx;
            } else if (idx == input.length - 1) {
                swap(input, prevIdx, ++idx);
            } else {
                idx++;
            }
        }

        for (String s : input) {
            System.out.print(s);
        }

    }

    static void swap(String[] arr, int prevIdx, int idx) {
        for (int i = 0; i < idx - prevIdx; i++) {
            if (prevIdx + i <= idx - 1 - i) {
                String tmp = arr[prevIdx + i];
                arr[prevIdx + i] = arr[idx - 1 - i];
                arr[idx - 1 - i] = tmp;
            }
        }
    }
}
