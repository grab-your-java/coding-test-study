# SWEA1952 수영장
## 설계
1. 주어지는 tc마다 fee가 다르므로 모든 경우의 수를 탐색해야한다고 생각
2. dfs를 사용하여 1일, 1달, 3달, 12달을 이용권을 구매하는 것으로 설계
3. 12달을 커버할 수 있는 이용권을 구매했다면 연산 종료
4. 중간중간 가지치기를 할 수 있도록 조건을 추가함

## 다른 방법
1. 효율적인 dfs 실시
    * 1일권과 1달권 중 최소 값으로 다음 dfs 실시
    * 1년권은 dfs를 수행하지 않고 맨 마지막에 비교만 하기
2. dp
    * 1일권과 1달권의 최소 값을 기존 plan 배열에 저장
    * 3월부터 3개월 전의 가격에서 3개월권의 가격을 더했을 때 최소값을 저장