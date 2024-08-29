package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();

            Stack<String> stack = new Stack<>();

            String[] inputs = sc.next().split("");

            boolean isValid = true;

            for (int i = 0; i < N; i++) {
                if (inputs[i].equals("(") || inputs[i].equals("[") || inputs[i].equals("{") || inputs[i].equals("<")) {
                    stack.push(inputs[i]);
                } else {
                    if (inputs[i].equals(")")) {
                        if ("(".equals(stack.peek())) {
                            stack.pop();
                        } else {
                            isValid = false;
                            break;
                        }
                    } else if (inputs[i].equals("]")) {
                        if ("[".equals(stack.peek())) {
                            stack.pop();
                        } else {
                            isValid = false;
                            break;
                        }
                    } else if (inputs[i].equals("}")) {
                        if ("{".equals(stack.peek())) {
                            stack.pop();
                        } else {
                            isValid = false;
                            break;
                        }
                    } else {
                        if ("<".equals(stack.peek())) {
                            stack.pop();
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }


        }


    }

    static class Stack<T> {
        List<T> input = new ArrayList<>();

        public boolean push(T item) {
            return input.add(item);
        }

        public T pop() {
            if (isEmpty()) {
                return null;
            }

            return input.remove(input.size() - 1);
        }

        public T peek() {
            return input.get(input.size() - 1);
        }

        public boolean isEmpty() {
            if (input.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
