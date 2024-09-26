package BOJ10814;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Person {
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Person> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(new Person(sc.nextInt(), sc.next()));
		}
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
	
		for (int i = 0; i < list.size(); i++) {
			Person person = list.get(i);
			
			sb.append(person.age).append(" ").append(person.name);
			
			if (i != list.size() - 1) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
