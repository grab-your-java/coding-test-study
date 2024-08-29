package boj_2477_참외밭;

import java.util.Scanner;

public class Other {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 1제곱미터당 참외의 개수
        int[][] arr = new int[6][2]; // 방향과 길이를 저장할 6행 2열의 배열

        // 방향과 길이를 배열에 입력
        for (int i = 0; i < 6; i++) {
            arr[i][0] = sc.nextInt(); // 방향
            arr[i][1] = sc.nextInt(); // 길이
        }

        // x축과 y축에서 가장 긴 변을 찾기
        int maxX = 0, maxY = 0;
        int maxXIndex = -1, maxYIndex = -1;
        for (int i = 0; i < 6; i++) {
            if (arr[i][0] == 1 || arr[i][0] == 2) { // 동쪽 또는 서쪽 : x축
                if (arr[i][1] > maxX) {
                    maxX = arr[i][1];
                    maxXIndex = i;
                }
            } else if (arr[i][0] == 3 || arr[i][0] == 4) { // 남쪽 또는 북쪽 : y축
                if (arr[i][1] > maxY) {
                    maxY = arr[i][1];
                    maxYIndex = i;
                }
            }
        }

        // 작은 직사각형의 변 길이를 계산
        // x축 중 가장 긴 변과 인접한 두 변의 차이 : 작은 직사각형 세로 길이
        // y축 중 가장 긴 변과 인접한 두 변의 차이 : 작은 직사각형 가로 길이
        int smallX = Math.abs(arr[(maxYIndex + 5) % 6][1] - arr[(maxYIndex + 1) % 6][1]);
        int smallY = Math.abs(arr[(maxXIndex + 5) % 6][1] - arr[(maxXIndex + 1) % 6][1]);

        // 전체 밭의 면적 = 큰 직사각형 - 작은 직사각형
        int largeArea = maxX * maxY;
        int smallArea = smallX * smallY;
        int area = largeArea - smallArea; // 사용 가능한 면적
        int num = area * K; // 총 참외의 개수

        System.out.println(num);
    }
}
