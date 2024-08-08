package stack_queue;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_28278_스택2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int capacity = 6;
		int idx = -1; //

		int[] stack = new int[capacity];
		for (int i = 0; i < N ; i++) {
			int num = sc.nextInt();
			if (num == 1) {
				int x = sc.nextInt();
				if (idx == capacity) {
					capacity *= 2;
					stack = Arrays.copyOf(stack, capacity);
				}
				stack[++idx] = x;
			}
			if (num == 2) {
				// 스택에 정수가 있다면 그 정수를 빼고서 스택 출력
				// 스택이 비어있다면 -1 출력
				if (idx >= 0) {
					stack[idx] = 0;
					idx--;
					System.out.println(Arrays.toString(Arrays.copyOfRange(stack, 0, idx+1)));
				} else {
					System.out.println(-1);
				}
			}
			if (num == 3) {
				System.out.println(idx + 1);
			}
			if (num == 4) {
				if (idx >= 0) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			} if(num==5) {
				if (idx >= 0) {
					System.out.println(stack[idx]);
				} else {
					System.out.println(-1);
				}
			}

		}
		sc.close();
	}

}
