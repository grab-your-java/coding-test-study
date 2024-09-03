package swea_2383;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static List<Person> persons;
	static int N; // persons.size();
	static boolean[] collected;

	static Stair[] stairs;
	static int minTime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int n = sc.nextInt();
			persons = new ArrayList<>();
			stairs = new Stair[2];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					int input = sc.nextInt();
					// persons
					if (input == 1) {
						persons.add(new Person(r, c));
					}
					// stairs
					else if (input > 1) {
						if (stairs[0] == null) {
							stairs[0] = new Stair(r, c, input);
						} else {
							stairs[1] = new Stair(r, c, input);
						}
					}
				}
			}

			for (Person person : persons) {
				person.calculateDist(stairs);
			}

			N = persons.size();
			collected = new boolean[N];
			minTime = Integer.MAX_VALUE;

			makeSubsets(0);

			sb.append(minTime).append("\n");
		}
		System.out.println(sb);
	}

	static void makeSubsets(int depth) {
		if (depth == N) {
			boolean target = true;
			int totalTime = 0;
			for (int i = 0; i < stairs.length; i++) {
				int index = i; // for lamda
				PriorityQueue<Person> pq = new PriorityQueue<>((a, b) -> a.dists[index] - b.dists[index]);

				for (int j = 0; j < N; j++) {
					if (collected[j] == target) {
						pq.add(persons.get(j));
					}
				}

				int[] waitlist = new int[100];
				while (!pq.isEmpty()) {
					int pivot = pq.poll().dists[i] + 1;
					while (pivot < waitlist.length) {
						if (waitlist[pivot] >= 3) {
							pivot++;
						} else {
							break;
						}
					}

					if (pq.size() == 0) {
						totalTime = Math.max(totalTime, pivot + stairs[i].time);
						break;
					}

					for (int time = pivot; time < pivot + stairs[i].time; time++) {
						waitlist[time]++;
					}
				}

				// for next stair
				target = false;
			}

			minTime = Math.min(minTime, totalTime);
			return;
		}

		collected[depth] = true;
		makeSubsets(depth + 1);
		collected[depth] = false;
		makeSubsets(depth + 1);
	}

	static class Person {
		int r, c;
		int[] dists;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

		void calculateDist(Stair[] stairs) {
			dists = new int[stairs.length];
			for (int i = 0; i < dists.length; i++) {
				dists[i] = Math.abs(this.r - stairs[i].r) + Math.abs(this.c - stairs[i].c);
			}
		}
	}

	static class Stair {
		int r, c, time;

		public Stair(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
