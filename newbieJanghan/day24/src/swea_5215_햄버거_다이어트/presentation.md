### 문제 분석

주어진 재료의 조합으로 햄버거를 만들자. 칼로리 제한 안에서 최고의 맛 값을 구하라.

### 기존 접근

재료 조합하는 거니까 연습했던 조합 공식을 적용.
수열의 개수가 정해져 있지 않으니, 수열의 개수마다 순회를 돌면서 탐색.

``` java
static void combination(Ingredient[] sequence, int accCalorie, int accTaste, int depth, int start) {
        if (depth == sequence.length) {
            TASTE = Math.max(TASTE, accTaste);
            return;
        }

        for (int i = start; i < INGREDIENTS.length; i++) {
            Ingredient ingredient = INGREDIENTS[i];
            if (accCalorie + ingredient.calorie > CALORIE_LIMIT) {
                continue;
            }
            sequence[depth] = ingredient;

            combination(sequence, accCalorie + ingredient.calorie, accTaste + ingredient.taste, depth + 1, i + 1);
        }
    }
```

하지만 다른 풀이보다 시간이 다섯 배 가까이 느렸음.

### 놓친 것

수열의 개수 제한이 없다는 것은, 굳이 특정 수열의 개수만큼 채울 필요가 없을 수 있다는 것.
만약 한 원소 만으로도 조건에 어긋나면, 해당 원소를 포함 시킨 조합을 만들 필요가 없다.

### 개선

기존 코드는 수열의 크기 단위로 순회를 시작하고 있음. 사실 크기랑 상관 없이 조건을 위반하는 수열이 조합에 누적되면 순회를 멈출 필요가 있다.

또한 일단 다음 차례의 원소를 받고 나서 제한 조건을 따지고 있는데, 기존 원소도 제한을 따질 필요가 있다.

### 반성

조합 문제라고 해서 수열의 크기를 설정하고, 모든 조합을 다 완성시킬 필요는 없다.