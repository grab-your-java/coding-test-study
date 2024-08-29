# DFS와 BFS

## DFS
- 루트노드에서 다음 분기로 넘어가기 전에, 해당 분기를 모두 탐색하는 방법
- 구현: 재귀 또는 스택
- `boolean[] visited`, `visited[i] = true`
- 검색 속도: BFS에 비해 느림
```java
static void dfs(int i) {
    visited[i] = true;
    System.out.print(i + " ");
    
    for (int j = 1; j < N + 1; j++) {
        if (map[i][j] == 1 && visited[j] == false) {
            dfs(j);
        }
    }
}
```
## BFS
- 재귀적으로 동작 X
- `boolean[] visited`, `visited[i] = true`
- 구현: 큐
- 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법
- 예시:
  - 두 노드 사이의 최단 경로 찾기
  - 임의의 경로 찾기
    - ex) 지구 상에 존재하는 모든 친구 관계를 그래프로 표현한 후 A와 B 사이에 존재하는 경로를 찾는 경우
      - DFS -> 모든 친구 관계를 다 살펴볼 가능성
      - BFS -> A와 가까운 관계부터 탐색

