package SWEA_2382_미생물격리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	// _, 상, 하, 좌, 우
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, 0 };
	static Queue<Group>[][] CELL;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;
			int N = sc.nextInt();
			int TIME = sc.nextInt();
			int TOTAL = sc.nextInt();

			// initialize cell
			CELL = new LinkedList[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					CELL[y][x] = new LinkedList<Group>();
				}
			}

			// add Group
			Group[] GROUPS = new Group[TOTAL];
			for (int i = 0; i < TOTAL; i++) {
				int y = sc.nextInt(), x = sc.nextInt(), count = sc.nextInt(), direction = sc.nextInt();
				Group group = new Group(y, x, count, direction);
				GROUPS[i] = group;
			}

			while (TIME-- > 0) {
				// Move groups
				for (Group group : GROUPS) {
					group.move();
				}

				// Fight
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						Queue<Group> queue = CELL[y][x];
						if (queue.isEmpty()) {
							continue;
						}
						
						Group group = queue.poll();
						while (queue.size() > 0) {
							group = Group.fight(group, queue.poll());
						}

					}
				}
				
//				System.out.println("---------------------");
//				for (Group group : GROUPS) {
//					System.out.println(group);
//				}
//				System.out.println("---------------------");

			}

			for (Group group : GROUPS) {
				result += group.count;
			}

			System.out.println("#" + t + " " + result);
		}

	}

	static class Group {
		int y, x, count, direction;

		Group(int y, int x, int count, int direction) {
			this.y = y;
			this.x = x;
			this.count = count;
			this.direction = direction;
		}

		void eat(Group group) {
			this.count += group.count;
		}

		void move() {
			// dead
			if (this.count == 0) {
				return;
			}
			
			y += dy[this.direction];
			x += dx[this.direction];
			
			if (y == 0 || y == CELL.length - 1 || x == 0 || x == CELL.length - 1) {
				this.inDanger();
			}

			CELL[y][x].add(this);
		}

		void inDanger() {
			// dead
			if (this.count == 0) {
				return;
			}
			
			this.count /= 2;
			switch (this.direction) {
			case 1:
				this.direction = 2;
				break;
			case 2:
				this.direction = 1;
				break;
			case 3:
				this.direction = 4;
				break;
			case 4:
				this.direction = 3;
				break;
			default:
				break;
			}
		}

		static Group fight(Group a, Group b) {
			if (a.count > b.count) {
				a.eat(b);
				b.count = 0;
				
				return a;
			} else {
				b.eat(a);
				a.count = 0;
				
				return b;
			}
		}
		
//		public String toString() {
//			return this.hashCode() + "(" + this.count + "), [ " + y + ", " + x + " ]" ;
//		}

	}
}