# SWEA 1953 탈주범 검거

## 초기 계획

### DFS

    ```java
    public static void dfs(int depth, int r, int c) {
        if (depth == L) {
            return;
        }

        visited[r][c] = true;
        count++;

        int type = map[r][c];
        for (int d = 0; d < 4; d++) {
            if (!directionType[type][d]) {
                continue;
            }

            int nr = r + dr[d];
            int nc = c + dc[d];
            if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                System.out.print(printDashes(depth) + " depth  " + depth + " try [" + r + "," + c + "] type " + Arrays.toString(directionType[map[r][c]]) + " => [" + nr + "," + nc + "] type " + Arrays.toString(directionType[map[nr][nc]]));
                if (visited[nr][nc]) {
                    System.out.println(" but no, visited");
                } else if (!checkEntry(d, nr, nc)) {
                    System.out.println(" but no, entry not match");
                } else {
                    System.out.println(" yes!");
                    dfs(depth + 1, nr, nc);
                }
            }
        }
    }
    ```

### 해당 코드 의 문제

한 경우에서 끝까지 탐색한 후 visited 를 체크해두는데,
만약 다른 경우에서 더 낮은 depth 임에도 이미 방문처리되어있는 칸을 방문하지 못하면
해당 칸에서 더 탐색할 수 있는 다른 경우를 넘어가게 됨.

예를 들어 depth 한도가 7이고, depth 7에서 visited 처리 된 칸의 경우,
depth 4에서 해당 칸을 방문할 경우가 있으면 해당 칸에서 시작할 수 있는 depth 5 경우를 영영 탐색하지 못하게 됨.

그렇다면 visited 를 한 가지가 끝날 때마다 false 로 돌려놓는 방법은 안 되는가?
중복 카운트를 제어하기가 쉽지 않다. 어떤 depth 에서든 동일 칸 방문은 같은 카운트로 계산되어야 한다.
이미 visited 된 셀은 방문은 가능하되 카운트만 추가하지 않는 방법을 쓰거나 BFS 로 전환하는 것이 좋다.

### BFS VS DFS 개선

|     | BFS      | DFS      |
|-----|----------|----------|
| 메모리 | 66,024kb | 58,712kb |
| 시간  | 234ms    | 266ms    |

- BFS 는 Queue 사용으로 인한 메모리 소모로 보인다.
- 시간은 유의미한 차이가 없다.