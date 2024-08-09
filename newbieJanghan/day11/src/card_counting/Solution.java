package card_counting;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		a: for (int t = 1; t <= T; t++) {
			String string = scanner.next();
			int N = string.length() / 3;
			int[] result = new int[N];

			Player player = new Player();

			for (int i = 0; i < result.length; i++) {
				String card = string.substring(i * 3, i * 3 + 3);

				boolean added = player.play(card);
				if (!added) {
					System.out.println("#" + t + " ERROR");
					continue a;
				}
			}

			System.out.println("#" + t + player.getResult());
		}
	}

	static class Player {
		private CardCollection sc = new CardCollection();
		private CardCollection dc = new CardCollection();
		private CardCollection hc = new CardCollection();
		private CardCollection cc = new CardCollection();

		public boolean play(String card) {
			char type = card.charAt(0);
			int number = Integer.valueOf(card.substring(1));
			return getCollection(type).add(number);
		}

		public String getResult() {
			StringBuilder sb = new StringBuilder();
			sb.append(" " + sc.leftCount);
			sb.append(" " + dc.leftCount);
			sb.append(" " + hc.leftCount);
			sb.append(" " + cc.leftCount);
			return sb.toString();
		}

		private CardCollection getCollection(char type) {
			if (type == 'S') {
				return sc;
			} else if (type == 'D') {
				return dc;
			} else if (type == 'H') {
				return hc;
			} else {
				return cc;
			}
		}
	}

	static class CardCollection {
		private int[] cardList = new int[13];
		private int leftCount = 13;

		public boolean add(int number) {
			int idx = number - 1;
			if (cardList[idx] > 0) {
				return false;
			}
			cardList[idx]++;
			leftCount--;
			return true;
		}
	}
}
