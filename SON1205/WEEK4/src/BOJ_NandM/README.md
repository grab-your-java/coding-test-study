# 순열과 조합
## 순열 & 조합 PRACTICE
### 1. 순열, 중복 X
    - visited 배열을 처음부터 순회하면서 false이면 true로 바꿔주고 depth를 1 더하기
    - 만약 depth가 원하는 순열의 길이 r과 같으면 logic 수행
    - true로 바꾼 인덱스에 해당하는 visited를 다시 false로 원상복귀
### 2. 순열, 중복 O
    - 순열과 달리 visited 배열이 인자로 없음
    - 처음부터 순회하면서 depth를 1 더하기
    - 만약 depth가 원하는 순열의 길이 r과 같으면 logic 수행
### 3. 조합, 중복 X
    - visited 배열을 start 매개변수에서부터 순회(이미 선택한 것들 고려)하면서 false이면 true로 바꿔주고 depth를 1 더하기
    - 만약 depth가 원하는 순열의 길이 r과 같으면 logic 수행
    - true로 바꾼 인덱스에 해당하는 visited를 다시 false로 원상복귀
### 4. 조합, 중복 O
    - 조합과 달리 visited 배열이 인자로 없음
    - i번째부터 순회하면서 depth를 1 더하기
    - 만약 depth가 원하는 순열의 길이 r과 같으면 logic 수행