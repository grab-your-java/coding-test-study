package 실버;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = str.split("");
		
		List<String> list = new ArrayList<>();
		int listSize = 0;
		String[] resArr = new String[strArr.length];
		
		for(int i=0, idx=0; i<strArr.length; i++) {
			if(strArr[i].equals("<")) {
				while(!strArr[i].equals(">")) {
					resArr[idx++]=strArr[i++];
				}
				resArr[idx++]=strArr[i];
			}else if(!strArr[i].equals(" ")) {
				list.add(strArr[i]);
				while(i+1<strArr.length&&!strArr[i+1].equals(" ")&&!strArr[i+1].equals("<")) {
					i++;
					list.add(strArr[i]);
				}
				listSize = list.size();
				for(int j=0; j<listSize; j++) {
					resArr[idx++] = list.remove(list.size()-1);
				}
			}else if(strArr[i].equals(" ")){
				resArr[idx++]=strArr[i];
			}
		}
		for(String s:resArr) {
			System.out.print(s);
		}
	}
}
