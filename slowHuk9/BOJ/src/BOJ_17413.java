import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		char[] word = s.toCharArray();
		// 열린 꺽쇄 시작일 때
		int idx = 0;
		if (word[0] == '<') {
			while (idx < word.length - 1 && word[idx] != '>') {
				System.out.println("idx :" + idx + "word[idx] : " + word[idx]);
				sb.append(word[idx]);
				idx++;
			}
			idx++;
			sb.append('>');
			result.append(sb);
			sb.delete(0, idx+1);
			System.out.println(result);
			System.out.println("sb 지우기 확인 :" + sb);
		} else {
			while (idx < word.length - 1 && word[idx] != ' ' || idx < word.length - 1 && word[idx] != '<') {
				sb.append(word[idx]);
				idx++;
			}
			sb.reverse();
			result.append(sb);
			sb.delete(0, idx+1);
			System.out.println(result);
		}
	}
}
