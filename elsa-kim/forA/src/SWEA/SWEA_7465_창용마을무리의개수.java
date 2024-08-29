package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_7465_창용마을무리의개수 {
	static int p, line, muri;
	static ArrayList<Integer>[] info;
	static boolean[] check;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			p = sc.nextInt();
			line = sc.nextInt();
			info = new ArrayList[p+1];
			muri = 0;
			for(int i=0; i<p+1; i++) {
				info[i] = new ArrayList<>();
			}
			for(int i=0; i<line; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				info[a].add(b);
				info[b].add(a);
			}
			check = new boolean[p+1];
			for(int i=1; i<p+1; i++) {
				if(check[i]) continue;
				muri++;
				getMuri(i);
			}
			
			System.out.println("#"+tc+" "+muri);
			
		}
	}

	private static void getMuri(int i) {
		for(int k=0; k<info[i].size(); k++) {
			if(check[info[i].get(k)]) continue;
			check[info[i].get(k)] = true;
			getMuri(info[i].get(k));
		}
		
	}
}
