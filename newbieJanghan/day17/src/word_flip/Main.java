package word_flip;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];

            // find tag
            if (c == '<') {
                int end = i;
                for (int j = i; j < chars.length; j++) {
                    sb.append(chars[j]);
                    if (chars[j] == '>') {
                        end = j;
                        break;
                    }
                }
                i = end + 1;
                continue;
            }

            if (c != ' ') {
                int end = i;
                for (int j = i; j < chars.length; j++) {
                    if (chars[j] == ' ' || chars[j] == '<') {
                        end = j - 1;
                        break;
                    }
                    if (j == chars.length - 1) {
                        end = j;
                        break;
                    }
                }
                for (int j = end; j >= i; j--) {
                    sb.append(chars[j]);
                }
                i = end + 1;
                continue;
            }
            if (i == chars.length - 1) {
                break;
            }
            
            sb.append(chars[i++]);
        }
        System.out.println(sb);
    }
}
