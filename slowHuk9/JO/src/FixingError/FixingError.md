# 오류교정 - JUNGOL #1037

## 문제

> 패리티 검사법은 메시지를 주고받을 때 메시지가 패리티 성질을 가지고 있을 경우엔 메시지가 제대로 도착을 하였다 보고 그렇지 않을 경우 메시지가 제대로 도착을 하지 않았다고 판별을 하는 메시지 전송시의 오류 판별 및 교정을 하는 방법을 말한다.

> 불리언 행렬의 각각의 열과 각각의 행이 짝수 합을 가질 때 패리티 성질을 가지고 있다고 하자. 다시 말하자면 한 집합에 짝수개의 1이 있다는 이야기 이다.

>아래는 패리티 성질을 가진 4 x 4의 행렬이다.
`1 0 1 0`
`0 0 0 0`
`1 1 1 1`
`0 1 0 1`

>각각의 행의 합은 2, 0, 4, 2 이고 열의 합은 2, 2, 2, 2 이다.
당신이 할일은 행렬의 정보를 읽어서 이것이 패리티 성질을 가지고 있는지 없는지 판단해야한다.
만약 그렇지 않을 경우 하나의 비트를 바꿔서 이 행렬이 패리티 성질을 가질 수 있는가 확인하고 그렇지 않을 경우 행렬은 잘못된 행렬이라고 판단한다.​

## 접근 방식

- 각각의 행의 합과 열의 합이 모두 짝수인 경우에 "OK"를 출력한다.
<br>
>	<u>하나의 비트</u>를 바꿔서 이 행렬이 패리티 성질을 가질 수 있는가 확인하고
- 행의 합과, 열의 합 중 홀수인 경우가  각각 1개라면, 홀수 합에 해당하는 행과 열의 인덱스를 저장 후 출력한다.
<br>
>  <u>그렇지 않을 경우 행렬은 잘못된 행렬</u>이라고 판단한다.​
- 각각의 행의 합과 열의 합 중에서 홀수인 경우가 2개 이상이라면 "Corrupt"를 출력한다.
## 제출 코드
> 394ms / 48.6MB

```
import java.util.Scanner;
  
public  class Main {
	static  int[][] map;
	static  int  n;
	static  boolean[] rowSum;
	static  boolean[] colSum;
	static  int  falseCnt;
	static  int  targetRow = -1;
	static  int  targetCol = -1;
	static  boolean  rowParity;
	static  boolean  colParity;

		public  static  void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			map = new  int[n][n];
			rowSum = new  boolean[n];
			colSum = new  boolean[n];
			for (int  i = 0; i < map.length; i++) {
				for (int  j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
					}
				}
			calRowSum();
			calColSum();
			countRowFalse();
			countColFalse();
  
			if (rowParity && colParity) {
				System.out.println("OK");
			} else  if (targetRow != -1 && targetCol != -1) {
			System.out.println("Change bit (" + (targetRow + 1) + "," + (targetCol + 1) + ")");
			} else {
				System.out.println("Corrupt");
				}
			}

		static  void calRowSum() {
			for (int  i = 0; i < map.length; i++) {
				int  sum = 0;
				for (int  j = 0; j < map.length; j++) {
					sum += map[i][j];
					}
				if (sum % 2 == 0)
					rowSum[i] = true;
				}
			}

		static  void calColSum() {
			for (int  j = 0; j < map.length; j++) {
				int  sum = 0;
				for (int  i = 0; i < map.length; i++) {
					sum += map[i][j];
					}
				if (sum % 2 == 0)
					colSum[j] = true;
					}
				} 

		static  void countRowFalse() {
			int  a = 0;
			for (int  i = 0; i < rowSum.length; i++) {
				if (rowSum[i] == false) {
					falseCnt++;
					a = i;
				}
			}
			if (falseCnt == 1) {
				targetRow = a;
			} else  if (falseCnt > 1) {
				rowParity = false;
			} else
				rowParity = true;
		}

		static  void countColFalse() {
			falseCnt = 0;
			int  a = 0;
			for (int  i = 0; i < colSum.length; i++) {
				if (colSum[i] == false) {
					falseCnt++;
					a = i;
					}
				}
			if (falseCnt == 1) {
				targetCol = a;
			} else  if (falseCnt > 1) {
				colParity = false;
			} else
				colParity = true;
		}
	}
```

## 비교 코드
>  244ms  39.8MB

```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int sum = 0, y = 0, x = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sum = 0;
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
			if(sum%2 != 0)
				if(y != 0) {
					System.out.println("Corrupt");
					return;
				}else {
					y = i;
				}
		}
		
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < N; j++) {
				sum += arr[j][i];
			}
			if(sum%2 != 0)
				if(x != 0) {
					System.out.println("Corrupt");
					return;
				}else {
					x = i;
				}
		}

		if(x+y == 0) System.out.println("OK");
		else System.out.printf("Change bit (%d,%d)",y+1,x+1);
	}
}
```

## 피드백

- 너무 과하게 세분화하여 메소드를 작성했다. 물론 이 방식으로 한다면 제 3자가 봤을 때 이해하기 편하고, 디버깅에 편하겠지만, 유지보수가 목적이 아니고 
	시간 내에 푸는 것이 중요한 알고리즘 풀이이기 때문에 조금은 이기적이어도 될 것 같다. 
- for문을 돌면서 할 수 있는 연산은 최대한 같은 for문 안에 넣어서 해보자.
	- 내 코드에서, 2차원 배열에 값을 저장하면서 충분히 rowSum과 colSum 둘 중 하나는 같이 구할 수 있으므로 메소드 1개를 줄일 수 있다. 


## 비교 코드에서 인상 깊은 부분 (핵심 포인트)

```
행의 합 짝수 판별
			if(sum%2 != 0) 
				if(y != 0) { // 만약 이미 y가 다른 값이라면 이미 한 번 저장된 것이므로 2번 이상 홀수가 나온 것
					System.out.println("Corrupt"); // 그러므로 바로 Corrupt를 출력하고
					return; // 종료.
				}else { // 홀수인 행의 인덱스를 y에 저장한다.
					y = i;
				}

=======================================================================================================
열의 합 짝수 판별
			if(sum%2 != 0)
				if(x != 0) {
					System.out.println("Corrupt");
					return;
				}else {
					x = i;
				}
				if(x+y == 0) System.out.println("OK");
				else System.out.printf("Change bit (%d,%d)",y+1,x+1);
	}
```
짝수가 아닌 행과 열의 인덱스를 저장하고, 
저장한 변수가 0 (초기값)이 아니라면 홀수가 2개 이상이라는 것이므로 Corrupt를 출력하고 종료했다.

내 코드의 falseCnt 와 같은 추가 변수 없이 x, y 만으로 Corrupt를 판별해낸 것이 인상 깊었다.
> x, y 가 내 코드에서는 targetRow, targetCol 