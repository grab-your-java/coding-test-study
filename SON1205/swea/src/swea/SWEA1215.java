package swea;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class SWEA1215 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            String[][] arr = new String[8][];

            for (int i = 0; i < 8; i++) {
                arr[i] = sc.next().split("");
            }

            int count = 0;

            for (int i = 0; i <= 8 - N; i++) {
                for (int j = 0; j < 8; j++) {
                    Deque<String> stack1 = new ArrayDeque<>();
                    Deque<String> stack2 = new ArrayDeque<>();

                    String[] arr1 = new String[N];
                    String[] arr2 = new String[N];

                    for (int p = 0; p < N; p++) {
                        arr1[p] = arr[j][i + p];
                        arr2[p] = arr[i + p][j];
                    }

                    if (N % 2 == 1) {
                        for (int q = 0; q < N; q++) {
                            if (q < N / 2) {
                                stack1.push(arr1[q]);
                                stack2.push(arr2[q]);
                            } else if (q == N / 2) {
                                continue;
                            } else {
                                if (arr1[q].equals(stack1.peek())) {
                                    stack1.pop();
                                }
                                if (arr2[q].equals(stack2.peek())) {
                                    stack2.pop();
                                }
                            }
                        }
                    } else {
                        for (int q = 0; q < N; q++) {
                            if (q < N / 2) {
                                stack1.push(arr1[q]);
                                stack2.push(arr2[q]);
                            } else {
                                if (arr1[q].equals(stack1.peek())) {
                                    stack1.pop();
                                }
                                if (arr2[q].equals(stack2.peek())) {
                                    stack2.pop();
                                }
                            }
                        }
                    }

                    if (stack1.isEmpty()) {
                        count++;
                    }

                    if (stack2.isEmpty()) {
                        count++;
                    }

                }
            }


            System.out.println("#" + test_case + " " + count);
        }
    }
}
