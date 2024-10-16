package SWEA_5644;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Charger {
		int r, c, range, power;

		Charger(int r, int c, int range, int power) {
			this.r = r;
			this.c = c;
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
		int[] movements;

		Person(int r, int c) {
			this.r = r;
			this.c = c;
			this.idx = 0;
		}

		void setMovements(int[] movements) {
			this.movements = movements;
		}

		void move() {
			this.r += dr[idx];
			this.c += dc[idx];
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
			Person[] persons = new Person[2];
			persons[0] = new Person(1, 1);
			persons[1] = new Person(10, 10);
			for (int i = 0; i < 2; i++) {
				int[] movements = new int[time];
				for (int j = 0; j < time; j++) {
					movements[j] = sc.nextInt();
					persons[i].setMovements(movements);
				}
			}

			// Charger
			Charger[] chargers = new Charger[chargerCnt];
			for (int i = 0; i < chargerCnt; i++) {
				chargers[i] = new Charger(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}

			PriorityQueue<Charger>[] pqs = new PriorityQueue[2];
			for (int i = 0; i < 2; i++) {
				pqs[i] = new PriorityQueue<>((a, b) -> b.power - a.power);
			}

			int sum = 0;
			while (time-- >= 0) {
				for (int i = 0; i < 2; i++) {
					for (Charger charger : chargers) {
						if (charger.chargable(persons[i])) {
							pqs[i].add(charger);
						}
					}
				}
				
				if (pqs[0].peek().equals(pqs[1].peek())) {
					int max = pqs[0].peek().power;
					if (max != 0) {
						
					}
					
					
				} else {
					sum += (pqs[0].peek().power + pqs[1].peek().power);
				}

			}
		}
	}
}
