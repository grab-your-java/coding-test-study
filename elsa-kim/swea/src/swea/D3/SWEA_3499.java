package swea.D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 퍼펙트 셔플
public class SWEA_3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int cnt = sc.nextInt();
			String[] arr = new String[cnt];
			for(int i=0; i<cnt; i++) {
				arr[i] = sc.next();
			}
			List<String> arrlist = new ArrayList<>();
			for(int i=0; i<cnt-cnt/2; i++) {
				arrlist.add(arr[i]);
				if(i+cnt-cnt/2==cnt) break;
				arrlist.add(arr[i+cnt-cnt/2]);
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<cnt; i++) {
				System.out.print(arrlist.remove(0));
				if(i!=cnt-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
}
