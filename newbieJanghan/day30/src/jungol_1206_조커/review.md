# 왜 이렇게 어렵게 생각했을까?

## 해결책과 비교

막상 풀고 나니 이렇게 쉽게 풀릴 수 없는 문제였는데,
처음에는 엄청 어렵게 생각했고, 심지어는 DFS로 경우의 수 따지는 것까지 생각했다.

기존 접근과 해결책 모두 카운팅 배열을 사용했다.

해결책은 맨 앞의 숫자부터 순회하며 조커를 최대한 쓰면서 스트레이트를 만들어보는 것이다.
기존 접근들은 이 생각을 하지 못했다. 한 번의 순회에 모든 걸 해결하려고 했기 때문이다.

## 기존 접근의 문제

```java
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbersCnt = new int[1000000 + 1]; // jokerCnt: joker count
        for (int i = 0; i < N; i++) {
            numbersCnt[sc.nextInt()]++;
        }

        int jokerCnt = numbersCnt[0];
        int count = 0, prev = 0, straight = 0, result = 0, maxJokerUsage = 0, jokerUsage = 0;
        for (int number = 1; number < numbersCnt.length && count < N - jokerCnt; number++) {
            if (prev == 0 && numbersCnt[number] == 0) {
                continue;
            }

            // try to use joker
            if (numbersCnt[number] == 0) {
                if (jokerCnt == 0) {
                    continue;
                }
                // can use joker
                if (jokerUsage < jokerCnt) {
                    jokerUsage++;
                    prev++;
                    straight++;
                }
                // cannot use joker
                else {
                    jokerUsage = 0;
                    prev = 0;
                    straight = 0;
                }

                continue;
            }

            count++;
            if (prev == 0 || prev + 1 == number) {
                straight++;
            } else {
                straight = 1;
                jokerUsage = 0;
            }

            if (straight > result) {
                result = straight;
                maxJokerUsage = jokerUsage;
            }
            prev = number;
        }

        // use left jokers
        result += (jokerCnt - maxJokerUsage);
        System.out.println(result);
    }
}
```

> 현재 숫자의 개수가 0이면 조커를 사용할 수 있는지를 확인하고,   
> 현재 숫자의 개수가 0이 아니라면 straight 여부를 확인한다

충분히 한 번의 순회해 해볼 수 있겠다는 생각이 들었다.  
하지만 결국 DFS까지 생각해보게 된 이유는, 이런 접근이 모든 경우의 수를 따지지 않기 때문이다.

이번에 조커 사용 여부를 따질 때, 기존에 쓰인 조커를 다시 취소할 지에 대한 경우의 수를 생각하면 무척 복잡해진다.  
조커가 3-5, 6-10, 13-? 라는 세 간극에서 쓰여야한다고 할 때, 13-? 의 ?는 아직 탐색하지 않았으므로 얼마나 조커 사용의 효용이 있을지를 알지 못한다.

## 결론

지금 사용하고자 하는 접근이 정말 모든 경우의 수를 따질 수 있는지 철저하게 생각해야한다.   
이번엔 펜을 안 잡고 접근했어서 그런지, 설계 과정에 시간을 많이 들이지 않았다.
혹여 시간을 더 들였다한들 이렇게 모든 논리적 결함을 발견할 수 있었을지는 의문이다.