package stack_queue;

import java.util.Arrays;
import java.util.Scanner;

public class backjoon_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 첫 입력은 명령의 갯수
        int capacity = n;
        int[] stack = new int[capacity]; // 배열 생성
        int ptr = -1; // 스택 포인터 // ptr = -1 이면 비어있다.
        
        while (n > 0) {
            String order = sc.next();
            switch (order) {
            case "push":
                int num = sc.nextInt();
                stack[++ptr] = num;
                /*
                 * System.out.println("stack = " + Arrays.toString(stack));
                 * System.out.println("ptr = " + ptr);
                 */
                n--;
                break;
            case "pop":
                /*
                 * System.out.println("현재 stack =" + Arrays.toString(stack));
                 * System.out.println("현재 ptr = " + ptr);
                 */
                if (ptr == -1) {
                    System.out.println(-1);
                } else {
                    //System.out.println("가장 위에 있는 값은 " + "stack [" + ptr + "]" + "=" + stack[ptr]); // 가장 위에 있던 값 출력
                    int last = stack[ptr];
                    stack[ptr]= 0; // 가장 위에 있는 값 출력 후 0으로 설정
                    System.out.println(last);
                    //System.out.println("stack = " + Arrays.toString(stack));
                    ptr--;
                }
                n--;
                break;
            case "size":
                System.out.println(ptr + 1);
                n--;
                break;
            case "empty":
                if (ptr == -1) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                n--;
                break;
            default: // order = top
                if (ptr == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack[ptr]);
                }
                n--;
                break;
            }
        }
    }
}