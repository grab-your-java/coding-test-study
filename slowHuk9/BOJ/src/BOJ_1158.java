import java.util.Scanner;

public class BOJ_1158 {
	static int front;
	static int rear;
	static int size;

	static void enQueue(int[] queue, int num) {
		rear = (rear + 1) % queue.length;
		queue[rear] = num;
		size++;
	}

	static int deQueue(int[] queue) {
		front = (front + 1) % queue.length;
		int popNum = queue[front];
		size--;
		return popNum;
	}

	static boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] queue = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			enQueue(queue, i);
		}

		System.out.print("<");

		while (!isEmpty()) {

			for (int i = 1; i < k; i++) {
				enQueue(queue, deQueue(queue));
			}
			System.out.print(deQueue(queue));
			if(!isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}

}
