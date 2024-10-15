package BOJ_1476;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Candidate {
		int quotient, value, modular;

		Candidate(int q, int v) {
			this.quotient = q;
			this.value = v;
		}

		boolean isValid(int quotient, int modular) {
			return value % quotient == modular;
		}

		void increace() {
			this.value += quotient;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] key = { 15, 28, 19 };
		int[] modulars = new int[3];
		for (int i = 0; i < 3; i++) {
			modulars[i] = sc.nextInt();
		}

		if (modulars[0] == 15 && modulars[1] == 28 && modulars[2] == 19) {
			System.out.println(15 * 28 * 19);
			return;
		}

		int[] candidates = modulars.clone();

		int answer = 0;
		PriorityQueue<Candidate> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		for (int i = 0; i < 3; i++) {
			pq.add(new Candidate(key[i], candidates[i]));
		}

		while (!pq.isEmpty()) {
			Candidate c = pq.poll();

			boolean valid = true;
			for (int i = 0; i < 3; i++) {
				if (key[i] == modulars[i]) {
					valid = c.isValid(key[i], 0);
				} else {
					valid = c.isValid(key[i], modulars[i]);
				}
				
				if (!valid) {
					break;
				}
			}

			if (valid) {
				pq.clear();
				answer = c.value;
			} else {
				c.increace();
				pq.add(c);
			}
		}

		System.out.println(answer);

	}
}
