package stack_queue;

import java.util.*;
public class backjoon_9012_count {

	public static void backjoon_9012_count(String[] args) {
	    // TODO Auto-generated method stub

	    // 문자열을 한글자씩 순회하면서 여는 괄호면 cnt에 +1 , 닫는 괄호면 -1을 한다.
	    // 순회를 돌다가 cnt가 음수가 되면 바로 break 해서 NO 출력
	    // 순회를 다 돌았는데 cnt가 양수이면 NO (여는 괄호가 더 많았다는 뜻)
	    // 순회를 다 돌았는데 cnt가 0이다. (그러면 VPS, 여는 괄호, 닫는 괄호의 갯수가 맞아떨어졌다.)

	    Scanner sc = new Scanner(System.in);
	    // 0. 테스트 케이스의 수를 입력 받는다.
	    int t = sc.nextInt();
	    // 1. 문자열을 받되, 한 문자열에 대한 순회를 마치고 vps 판별이 끝나면 초기화시킨다.
	    for (int i = 1; i <= t; i++) {
	        int cnt = 0;

	        String s = sc.next();

	        if (s.length() < 2 || s.length() > 50) { // 문자열 길이 조건 2~50 적용
	            System.out.println("NO");
	            continue;
	        }

	        // 2. 문자열을 한글자씩 분리하면서 순회

	        for (int j = 0; j < s.length(); j++) {
	            // 3. 그 글자가 여는 괄호라면 cnt +=1 해버리기
	            if (s.charAt(j) == '(') {
	                cnt += 1;
	                //System.out.println("1:::::" + cnt);
	            } else { // 닫는 괄호일때 
	                cnt -= 1; // cnt -1 해주기
	                
	                //System.out.println("2:::::" + cnt);
	                if (cnt < 0) { // 순회를 돌다가 cnt가 음수가 되면
	                    System.out.println("NO");
	                    //System.out.println("3::::" + cnt);
	                    break;
	                }
	            }
	        } // 순회를 다 돌았다.
	        if (cnt > 0) {
	            System.out.println("NO");
	            //System.out.println("4::::" + cnt);
	        } else if (cnt == 0) {
	            System.out.println("YES");
	        //    System.out.println("5::::" + cnt);
	        }
	    }
	}

}
