package stack_queue;

import java.util.Scanner;

public class backjoon_18258 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int capacity = 8;
		int[] que = new int[capacity];
		int front = 0; // 처음 인큐 할때의 인덱스
		int rear = -1; // 큐의 끝을 나타내는 인덱스 rear

		while (n == 0) {
			String order = sc.next();
			switch (order) {
			case "push":
				int num = sc.nextInt();
				if (que.length == capacity) {
					capacity *= 2;
				}
				que[++rear] = num;
			case "pop":
				

			}
		}

//		정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//
//		명령은 총 여섯 가지이다.
//
//		push X: 정수 X를 큐에 넣는 연산이다.

//		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		size: 큐에 들어있는 정수의 개수를 출력한다.
//		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//		첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
//		주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

	}

}
