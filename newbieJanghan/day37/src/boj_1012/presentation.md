# BFS 사용하면서 시간 초과

## 두 코드의 차이는?

> boolean[][] planted: 좌표에서 배추가 심어져 있으면 true 아니면 false  
> 두 bfs 모두 배추가 심어져있는지를 확인하고 queue 에 넣는 로직

```java
static void bfs(int r, int c) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(r);
    queue.add(c);

    while (!queue.isEmpty()) {
        int cr = queue.poll();
        int cc = queue.poll();
        planted[cr][cc] = false;

        for (int d = 0; d < 4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if (0 <= nr && nr < R && 0 <= nc && nc < C && planted[nr][nc]) {
                queue.add(nr);
                queue.add(nc);
            }
        }
    }
}
```

```java
static void bfs(int r, int c) {
    Queue<Integer> queue = new ArrayDeque<>();
    planted[r][c] = false;
    queue.add(r);
    queue.add(c);

    while (!queue.isEmpty()) {
        int cr = queue.poll();
        int cc = queue.poll();

        for (int d = 0; d < 4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if (0 <= nr && nr < R && 0 <= nc && nc < C && planted[nr][nc]) {
                planted[nr][nc] = false;
                queue.add(nr);
                queue.add(nc);
            }
        }
    }
}
```

## 명시적으로 queue 의 역할을 정의해보자

### queue 에 좌표 값을 넣는 이유

- queue 는 그다음 델타 탐색의 대상이 들어와야 함
- 더 이상 델타 방향에 대한 탐색 대상이 없는 경우, 배추 인접 영역을 다 돌았다고 판단할 수 있다.

### 델타 탐색 시 신경써야 할 것

- queue 에 넣고자 하는 대상(좌표)가 이미 queue 에 들어간 적은 없는지 알고리즘 단계 내에서 따질 필요가 있다.

## 결론

- 두 로직 모두 planted 의 좌표 값을 false 로 초기화하여 중복 탐색을 막고자 했음.
- 하지만 첫 로직은 델타 탐색 대상이 중복으로 queue 에 들어갈 수 있음.
- queue 에서 나오기 전부터 이미 planted 에 체크가 되어있어야, 다른 방향에서 같은 좌표를 탐색할 때도 확인이 됨.
- **queue 에 담겨있는지 여부를 외부에서 미리 확인할 수 있도록 신경쓰자.** 
