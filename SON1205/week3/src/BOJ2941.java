import java.util.Scanner;

public class BOJ2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.next().split("");

        int idx = -1;
        int cnt = 0;

        while (idx < input.length - 1) {
            idx++;

//            if (idx + 1 < input.length) {
//                switch (input[idx]) {
//                    case "c":
//                        if (input[idx + 1].equals("=") || input[idx + 1].equals("-")) {
//                            idx += 1;
//                        }
//                        break;
//                    case "d":
//
//                }
//            } else if (idx + 2 < input.length) {
//                if (input[idx].equals("d") && input[idx + 1].equals("z") && input[idx + 2].equals("=")) {
//                    idx += 2;
//                }
//            }

            if (input[idx].equals("c")) {
                if (idx + 1 < input.length && (input[idx + 1].equals("=") || input[idx + 1].equals("-"))) {
                    idx += 1;
                }
            } else if (input[idx].equals("d")) {
                if (idx + 2 < input.length && input[idx + 1].equals("z") && input[idx + 2].equals("=")) {
                    idx += 2;
                } else if (idx + 1 < input.length && input[idx + 1].equals("-")) {
                    idx += 1;
                }
            } else if (idx + 1 < input.length && input[idx].equals("l") && input[idx + 1].equals("j")) {
                idx += 1;
            } else if (idx + 1 < input.length && input[idx].equals("n") && input[idx + 1].equals("j")) {
                idx += 1;
            } else if (idx + 1 < input.length && input[idx].equals("s") && input[idx + 1].equals("=")) {
                idx += 1;
            } else if (idx + 1 < input.length && input[idx].equals("z") && input[idx + 1].equals("=")) {
                idx += 1;
            }

            cnt++;

        }

        System.out.println(cnt);
    }
}
