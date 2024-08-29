package SWEA_2382_미생물격리;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	// _, 상, 하, 좌, 우
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, 0 };
	static PriorityQueue<Bacteria>[][] cells;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int result = 0;
			int N = sc.nextInt();
			int TIME = sc.nextInt();
			int TOTAL = sc.nextInt();
			sc.nextLine();

			// initialize cell
			cells = new PriorityQueue[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					cells[y][x] = new PriorityQueue<Bacteria>((a,b) -> b.count - a.count);
				}
			}

			// add bacteria
			Bacteria[] bacterium = new Bacteria[TOTAL];
			for (int i = 0; i < TOTAL; i++) {
				// [ y, x, count, direction ]
				int[] inputs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Bacteria bacteria = new Bacteria(i, inputs[0], inputs[1], inputs[2], inputs[3]);
				bacterium[i] = bacteria;
			}

			while (TIME-- > 0) {
				// Move bacterium
				for (Bacteria bacteria: bacterium) {
					bacteria.move();
				}

				// Fight
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						PriorityQueue<Bacteria> q = cells[y][x];
						if (q.isEmpty()) {
							continue;
						}
						
						Bacteria bacteria = q.poll();
						while (q.size() > 0) {
							bacteria = Bacteria.fight(bacteria, q.poll());
						}

					}
				}
			}

			for (Bacteria bacteria : bacterium) {
				result += bacteria.count;
			}

			System.out.println("#" + t + " " + result);
		}

	}

	static class Bacteria {
		int index, y, x, count, direction;

		Bacteria(int index, int y, int x, int count, int direction) {
			this.index = index;
			this.y = y;
			this.x = x;
			this.count = count;
			this.direction = direction;
		}

		void eat(Bacteria bacteria) {
			this.count += bacteria.count;
			bacteria.count = 0;
		}

		void move() {
			// dead
			if (this.count == 0) {
				return;
			}
			y += dy[this.direction];
			x += dx[this.direction];

			if (y == 0 || y == cells.length - 1 || x == 0 || x == cells.length - 1) {
				this.inDanger();
			}

			cells[y][x].add(this);
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
			default:
				this.direction = 3;
				break;
			}
		}

		static Bacteria fight(Bacteria a, Bacteria b) {
			if (a.count > b.count) {
				a.eat(b);

				return a;
			} else {
				b.eat(a);

				return b;
			}
		}

	}
}