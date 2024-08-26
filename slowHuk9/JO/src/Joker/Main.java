package Joker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] input = new int[n];
		int num = -1;
		int joker = 0;
		for (int i = 0; i < input.length; i++) {
			num = sc.nextInt();
			if (num == 0) {
				joker++;
			}
			input[i] = num;
		}
		int[] cards = new int[n - joker];
		int idx = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != 0)
				cards[idx++] = input[i];
		}
		Arrays.sort(cards);
		System.out.println(Arrays.toString(cards));
		System.out.println(joker);

		int straight = 1;
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		for (int i = 1; i < cards.length; i++) {
			if (cards[i] == cards[i - 1] + 1) {
				straight++;
			} else {
				hashmap.put(cards[i-1], straight);
			}
		}

	}

}
