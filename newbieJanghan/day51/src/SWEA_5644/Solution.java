package SWEA_5644;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Charger {
		int r, c, range, power;

		Charger(int x, int y, int range, int power) {
			this.r = y;
			this.c = x;
			this.range = range;
			this.power = power;
		}

		boolean chargable(Person p) {
			return (Math.abs(p.r - r) + Math.abs(p.c - c)) <= range;
		}
	}

	static int[] dr = { 0, -1, 0, 1, 0 }, dc = { 0, 0, 1, 0, -1 };

	static class Person {
		int r, c, idx;
		int[] commands;

		Person(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.idx = 0;
			this.commands = new int[time];
		}

		void move() {
			this.r += dr[commands[idx]];
			this.c += dc[commands[idx]];
			idx++;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			int time = sc.nextInt(), chargerCnt = sc.nextInt();

			// Person
			Person a = new Person(1, 1, time);
			for (int i = 0; i < time; i++) {
				a.commands[i] = sc.nextInt();
			}
			
			Person b = new Person(10, 10, time);
			for (int i = 0; i < time; i++) {
				b.commands[i] = sc.nextInt();
			}

			// Charger
			Charger[] chargers = new Charger[chargerCnt];
			for (int i = 0; i < chargerCnt; i++) {
				chargers[i] = new Charger(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}

			PriorityQueue<Charger> aChargers = new PriorityQueue<>((c1, c2) -> c2.power - c1.power);
			PriorityQueue<Charger> bChargers = new PriorityQueue<>((c1, c2) -> c2.power - c1.power);

			int sum = 0, spent = 0;
			while (spent <= time) {
				if (spent >= 1) {
					a.move();
					b.move();
				}

				for (Charger charger : chargers) {
					if (charger.chargable(a))
						aChargers.add(charger);
					if (charger.chargable(b))
						bChargers.add(charger);
				}

				Charger aMax = aChargers.isEmpty() ? null : aChargers.poll();
				Charger bMax = bChargers.isEmpty() ? null : bChargers.poll();

				if (aMax != null && bMax != null && aMax.equals(bMax)) {
					sum += aMax.power;

					int nextMax = 0;
					if (!aChargers.isEmpty()) {
						nextMax = aChargers.poll().power;
					}
					if (!bChargers.isEmpty()) {
						nextMax = Math.max(nextMax, bChargers.poll().power);
					}

					sum += nextMax;
				} else {
					if (aMax != null) sum += aMax.power;
					if (bMax != null) sum += bMax.power;
				}

				aChargers.clear();
				bChargers.clear();

				spent++;
			}

			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}
}
