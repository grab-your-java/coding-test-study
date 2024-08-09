import java.util.Scanner;

public class SWEA_3499 {
	static String[] queue1 = new String[500];
	static int front1 = -1;
	static int rear1 = -1;
	static String[] queue2 = new String[500];
	static int front2 = -1;
	static int rear2 = -1;

	static void enQueue1(String item) {
		if (isFull1()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		queue1[++rear1] = item;
	}

	static String deQueue1() {
		if (isEmpty1()) {
			// System.out.println("큐가 이미 비어있습니다.");
			return null;
		}
		return queue1[++front1];
	}

	static String Qpeek1() {
		if (isEmpty1()) {
			System.out.println("큐가 이미 비어있습니다.");
			return null;
		}
		return queue1[front1 + 1];
	}

	static boolean isEmpty1() {
		return rear1 == front1;
	}

	static boolean isFull1() {
		return rear1 == queue1.length - 1;
	}

	static int size1() {
		return rear1 - front1;
	}

	static void clearQueue1() {
		for (int i = 0; i < queue1.length; i++) {
			queue1[i] = null;
		}
		rear1 = -1;
		front1 = -1;
	}

	static void clearQueue2() {
		for (int i = 0; i < queue2.length; i++) {
			queue2[i] = null;

		}
		rear2 = -1;
		front2 = -1;
	}

	static void enQueue2(String item) {
		if (isFull2()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		queue2[++rear2] = item;
	}

	static String deQueue2() {
		if (isEmpty2()) {
			// System.out.println("큐가 이미 비어있습니다.");
			return null;
		}
		return queue2[++front2];
	}

	static String Qpeek2() {
		if (isEmpty2()) {
			System.out.println("큐가 이미 비어있습니다.");
			return null;
		}
		return queue2[front2 + 1];
	}

	static boolean isEmpty2() {
		return rear2 == front2;
	}

	static boolean isFull2() {
		return rear2 == queue2.length - 1;
	}

	static int size2() {
		return rear2 - front2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 1; i <= testCase; i++) {
			clearQueue1();
			clearQueue2();
			int cards = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String[] s = str.split(" ");
			// 카드 수가 짝수 일때
			if (cards % 2 == 0) {
				for (int j = 0; j < cards / 2; j++) {
					enQueue1(s[j]);
				}
				// System.out.println("queue1");
				// System.out.println(Arrays.toString(queue1));
				for (int j = cards / 2; j < s.length; j++) {
					enQueue2(s[j]);
				}
				// System.out.println("queue2");
				// System.out.println(Arrays.toString(queue2));
			}
			// 카드 수가 홀수 일때
			else {
				for (int j = 0; j < cards / 2 + 1; j++) {
					enQueue1(s[j]);
				}
				// System.out.println("queue1");
				// System.out.println(Arrays.toString(queue1));
				for (int j = cards / 2 + 1; j < s.length; j++) {
					enQueue2(s[j]);
				}
				// System.out.println("queue2");
				// System.out.println(Arrays.toString(queue2));
			}
			System.out.print("#" + i + " ");
			for (int j = 0; j < cards / 2; j++) {
				String card1 = deQueue1();
				if (card1 != null) {
					System.out.print(card1 + " ");
				}
				String card2 = deQueue2();
				if (card2 != null) {
					System.out.print(card2 + " ");
				}
			}
			if (cards % 2 != 0) {
				System.out.print(deQueue1());
			}
			System.out.println();
		}

	}
}