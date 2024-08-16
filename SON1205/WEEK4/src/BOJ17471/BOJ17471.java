package BOJ17471;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ17471 {
    //1. 부분집합 구하기
    //2. 연결되어 있는지 확인
    //3. 집합a와 집합b의 차이 구하기
    //4. 최소값 찾기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        people = new int[N];

        for (int i = 0; i < N; i++) {
            people[i] = sc.nextInt();
        }

        int[][] graph = new int[N][];

        for (int i = 0; i < N; i++) {
            int cnt = sc.nextInt();
            graph[i] = new int[cnt];

            for (int j = 0; j < cnt; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            visited = new boolean[N];
            output = new int[i];
            combi(i, 0, 0);
        }


    }

    static int N;
    static int[] people;
    static boolean[] visited;
    static int[] output;

    static void combi(int cnt, int start, int depth) {
        if (depth == cnt) {
            //logic

            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                combi(cnt, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    //부분집합
    //select배열을 써서 따로 저장해도 되지만,
    //boolean[] 배열을 통해 선택 여부만 체크하고 넘어가서 배열의 원소가 true일 경우에 결과배열에 넣어도 된다.
    public static void subset(int[] arr, int idx, int[] select, int sidx) {
        // r개를 고르지 않아도, 원본 배열을 모두 돌았으면 출력
        if (idx == arr.length) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < sidx; i++) {
                list.add(select[i]);
            }
            System.out.println(list);
            return;
        }

        subset(arr, idx + 1, select, sidx);
        select[sidx] = arr[idx];
        subset(arr, idx + 1, select, sidx + 1);
    }
}
