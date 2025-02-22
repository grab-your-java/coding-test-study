# SWEA 7733 치즈 도둑

## 접근법

1. BFS 로 탐색하면서 이미 방문한 좌표를 체크해두기
2. 완전 탐색 + back tracking

### why?

덩어리로 묶일 수 없는 값에 도착하면 더 이상 델타 탐색을 멈추고 그렇지 않으면 계속해서 방문을 해야 함.  
방문을 체크하지 않으면 덩어리를 구분할 수가 없기 때문이다.  
따라서 queue 에 인접한 덩어리들을 게속 담아놓고, 방문 처리하는 것이 핵심 전략이다.

덩어리가 어떻게 나뉠지 그리디하게 탐색할 방법을 모르겠으므로 완전 탐색을 시도한다.  
다만, 맛의 최소, 최대값을 미리 알아두면 굳이 모든 일수에 대해 돌 필요가 없음에 유의한다.

## 구현

### input

1. 치즈 맛을 2차원 배열에 담는다.
2. static 변수에 델타 탐색을 위한 dr, dc 를 설정하여 테스트 케이스 모두가 공유한다.
3. 치즈 중 최대 맛 값을 미리 저장한다.

### 완전 탐색

1. 1 또는 최소 값 부터 100 또는 최대 맛 값까지 BFS 후 덩어리 값을 구한다.
2. 덩어리 값을 구할 때마다 최대 값을 갱신한다.
3. 만약 덩어리가 없다면, 한 번도 쪼개지지 않았을 때의 값 1이 출력되어야 한다.

### BFS

1. 2차원 배열의 모든 좌표 중 방문하지 않은 좌표 모두를 덩어리 시작으로 인식하고 탐색한다.
2. 각 탐색 시작 시 덩어리 카운트를 증가시킨다. 이후 시작 좌표를 방문처리한 후 queue 에 집어넣는다.
3. queue 에서 좌표를 꺼낸 후 델타 방향에 해당하는 좌표를 방문처리 후 queue 에 넣는다.
4. queue 에 넣을 때, 맛 기준 일 수를 따져서 넣는다. 만약 X번째 날보다 작은 값을 가진 좌표면 queue 에 넣지 않는다.
5. queue 가 빌 때까지 3,4 를 반복한다.
6. queue 가 종료되면 1, 2가 2차원 배열 모두를 돌때까지 반복하며 덩어리 카운트를 증가시킨다.

