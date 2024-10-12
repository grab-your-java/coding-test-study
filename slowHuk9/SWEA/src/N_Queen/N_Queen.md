# N-Queen

## 기존 접근 방식
- board 2차원 int 배열을 만들고 2차원 배열 이중 for문을 순회하면서 board[i][j] 가 0인 위치를 찾고, 퀸의 위치를 7로 지정, 퀸의 공격 범위를 1로 지정하는 과정을 하나의 사이클로 지정
- 한 사이클을 돌리고나서 다시 2차원 배열 순회, 0인 위치 찾기, 반복. 
- board에서 값을 0 , 1, 7 세가지의 값으로 구별하는 것보다 boolean canBeAttacked[][] 2차원 배열을 하나 만들면 fasle --> 퀸을 놓을 수 있는 위치  // true --> 이미 퀸이 놓여있거나, 이전 퀸들의 공격 범위 로 더 쉽게 판단 가능

```
static void queen(int depth, int r) {
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				if (!visited[i][j]) {
					rowNcol(i, j);
					diagnoal(i, j);
					queen(depth + 1, i + 1);
					rowNcolReverse(i, j);
					diagnoalReverse(i, j);
				}
			}
		}
	}
```
** 각 행과 열에 대한 백트래킹을 하는 것은 잘 했으나 대각선을 체크 하는 과정에서 nr, nc 좌표가 이미 true면 단순히 while문을 벗어나도록 설계. 왜 이렇게 설계했는지 모르겠음.. 탐색할 경로에 true가 있다는 건 공격을 당할 위치라는 것인데 왜 바로 return false를 안했는지 모르겠다.. ㅠ **

**  여기서 논리 오류 발생 **

```
	static void rowAndColReverse(int r, int c) {
		for (int k = 0; k < canBeAttacked.length; k++) {
			canBeAttacked[r][k] = false;
			canBeAttacked[k][c] = false;
		}

	}

	static void diagnoal(int r, int c) {
		for (int i = 1; i < 5; i++) {
			while (true) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!canBeAttacked[nr][nc]) {
						canBeAttacked[nr][nc] = true;
						r = nr;
						c = nc;
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}

	}	
```

### 다시 생각하니까?
** 각 행을 기준으로 잡고 열을 순회 하면서 queen을 놓으면, 각 행마다 퀸은 1개만 놓을 수 있기 때문에 행에 대한 queen 중복 확인을 안해도 됨 **

** 1행에 queen을 놓았다면 해당 열에 대한 중복만 확인하고 바로 2행으로 넘어가면 된다는 것 **
```
static boolean isSafe(int r, int c) {
		for (int i = 0; i < N; i++) {
			if (visited[i][c])  // c열에 대한 퀸 중복만 확인
				return false; // 퀸이 이미 있다면 false 리턴
		}
		for (int i = 1; i < 5; i++) {
			int nr = r;
			int nc = c;
			while (true) {
				nr += dr[i];
				nc += dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (visited[nr][nc]) { // 대각 경로가 이미 true로 공격 범위라면 
						return false; // 바로 false 리턴
					}
				} else
					break;

			}

		}
		return true;
	}
```


```
static void queen(int depth, int r) {
		if (depth == N) {
			cnt++;
			return;
		}
		for (int col = 0; col < N; col++) {
			if (isSafe(r, col)) { // 놓을 위치가 안전한지 판단
				placeQueen(r, col); // 퀸 놓기
				queen(depth + 1, r + 1); // 다음 행으로
				placeQueenReverse(r, col); // 백트래킹
			}
		}

	}
```

### 22,328 kb 163 ms