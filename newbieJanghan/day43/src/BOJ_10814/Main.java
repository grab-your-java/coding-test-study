package BOJ_10814;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static class User {
		int id, age;
		String name;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		User[] users = new User[N];
		for (int i = 0; i < N; i++) {
			User user = new User();
			user.id = i;
			user.age = sc.nextInt();
			user.name = sc.next();

			users[i] = user;
		}

		Arrays.sort(users, (a, b) -> {
			if (a.age == b.age) {
				return a.id - b.id;
			}
			return a.age - b.age;
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			User user = users[i];
			sb.append(user.age).append(" ").append(user.name).append("\n");
		}

		System.out.println(sb);
	}
}
