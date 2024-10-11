# BOJ 1463 / 1로 만들기
## 오답 코드
```java
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];

		for (int number = 2; number <= N; number++) {
			arr[number] = arr[number - 1] + 1;
			if (number % 3 == 0) {
				arr[number] = Math.min(arr[number / 3] + 1, arr[number]);
			}
		    else if (number % 2 == 0) {
				arr[number] = Math.min(arr[number / 2] + 1, arr[number]);
			}
		}
		
		System.out.println(arr[N]);
	}
```
## 문제점
- 3으로 나눈 값이 최단 경로라 판단하여 if - else 로 분기처리를 했던 것
- `3으로 나눈 값이 최단 경로다.`라는 판단은 논리적 근거가 부족했다.

## 결론
- 컴퓨팅적 사고(=논리적 사고)를 잘 하자. 이번 풀이는 감각에 기반한 추측이었지 추론이 아니었음.
