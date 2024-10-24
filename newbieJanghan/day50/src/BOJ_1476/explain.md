# 풀이 설명

## 기본 로직
1. 연도를 세 옵션들의 몫 (15, 28, 19) 으로 나누어보면서 나머지 값이 일치하는지 확인하는 로직

2. 다만 연도 변수의 값을 증가시킬 때 1씩 증가시키며 확인하는 것이 아니라 나머지가 일치하는 옵션의 몫만큼 증가시키려고 했음.

3. 세 몫은 각자 연도가 증가하는 비율이 다름. 
만약 현재 연도 변수의 값이 31이고 15 옵션에서 나머지가 일치하지 않는 경우 다음 연도는 31 + 15 = 46.
한편 15 옵션에 나머지가 일치하여 28 옵션을 확인하였을 때 문제가 발생하면 다음 연도는 31 + 28 = 59.
46 - 59 사이에 최적의 연도가 존재할 수 있기 때문에 이를 탐색할 필요가 있음.

4. 따라서 각 옵션마다 연도를 증가시키고 가장 낮은 연도를 우선순위 큐에서 꺼내어 세 옵션의 나머지와 일치하는지를 따져보고자 함.

|15|28|19|pq.poll()|
|--|--|--|---------|
|6 |27|13| 6       |
|21|27|13|13       |
|21|27|31|27       |

이런 순서로 최적으로 연도를 증가시키고자 하였음.