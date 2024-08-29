package boj_2477_참외밭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Side first = null, last = null, maxWidth = null, maxHeight = null;

		int inputCount = 6;
		while (inputCount-- > 0) {
			Side cur = new Side(sc.nextInt(), sc.nextInt());

			// allocate maxHeight Side
			if (cur.direction == 3 || cur.direction == 4) {
				if (maxHeight == null) {
					maxHeight = cur;
				} else if (maxHeight.length < cur.length) {
					maxHeight = cur;
				}
				
			}
			// allocate maxWidth Side
			else if (cur.direction == 1 || cur.direction == 2) {
				if (maxWidth == null) {
					maxWidth = cur;
				} else if (maxWidth.length < cur.length) {
					maxWidth = cur;
				}
				
			}

			// handle first case 
			if (first == null) {
				first = cur;
				last = cur;
			} else {
				cur.prev = last;
				last.next = cur;
			}

			// allocate side for next linkage
			last = cur;
		}
		// link last and first
		first.prev = last;
		last.next = first;

		int largeArea = maxHeight.length * maxWidth.length;
		int smallArea = Math.abs(maxHeight.prev.length - maxHeight.next.length)
				* Math.abs(maxWidth.prev.length - maxWidth.next.length);


		System.out.println(K * (largeArea - smallArea));
	}

	public static class Side {
		int direction, length;
		Side prev, next;

		public Side(int direction, int length) {
			this.direction = direction;
			this.length = length;
		}

	}
}

