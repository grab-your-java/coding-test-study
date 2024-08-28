package boj_2477_참외밭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		Side first = new Side(sc.nextInt(), sc.nextInt(), null, null);
		Side last = first;
		Side maxWidth = first;
		Side maxHeight = first;

		int inputCount = 1;
		while (++inputCount < 7) {
			Side cur = new Side(sc.nextInt(), sc.nextInt(), last, null);
			
			// allocate maxHeight Side
			if (cur.direction == 1 && maxHeight.length < cur.length) {
				maxHeight = cur;
			}
			// allocate maxWidth Side
			else if (cur.direction == 0 && maxWidth.length < cur.length) {
				maxWidth = cur;
			}

			// link
			cur.pre = last;
			last.next = cur;

			// allocate side for next linkage
			last = cur;
		}
		// link last and first
		first.pre = last;
		last.next = first;
		
		
		Side flag = first;
		System.out.println("flag: " + flag.direction + " " + flag.length);
		flag = flag.next;
		System.out.println("flag: " + flag.direction + " " + flag.length);
		flag = flag.next;
		System.out.println("flag: " + flag.direction + " " + flag.length);
		flag = flag.next;
		System.out.println("flag: " + flag.direction + " " + flag.length);
		flag = flag.next;
		System.out.println("flag: " + flag.direction + " " + flag.length);
		flag = flag.next;
		System.out.println("flag: " + flag.direction + " " + flag.length);

		int largeArea = maxHeight.length * maxWidth.length;
		int smallArea = Math.abs(maxHeight.pre.length - maxHeight.next.length)
				* Math.abs(maxWidth.pre.length - maxWidth.next.length);

		System.out.println(K * (largeArea - smallArea));
	}

	public static class Side {
		int direction, length;
		Side pre, next;

		public Side(int direction, int length, Side pre, Side next) {
			// 0: Horizontal, 1: Vertical
			if (direction == 1 || direction == 2) {
				this.direction = 0;
			} else {
				this.direction = 1;
			}
			this.length = length;
			this.pre = pre;
			this.next = next;
		}

	}
}
