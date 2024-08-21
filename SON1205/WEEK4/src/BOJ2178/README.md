# 미로 탐색

## 문제 포인트
1. 최단 경로 찾기 (bfs)
2. 갈 수 있는 곳으로만 가기 (0, 1)

## 의문점
1. 이 문제를 dfs로 풀면?
    - 방문 처리를 통해 갈 수 있는 모든 길을 탐색할 것이라고 예상됨
    - 방문 처리를 한 곳은 가지 않게 되므로 경로 설정에 문제가 생김
    - 따로 visited를 더 만들더라도 첫 번째 문제가 발생

## 문제 응용
1. distance가 1씩 증가를 다양한 숫자로 변경
2. 돌아가는데 오히려 짧은 경로가 존재