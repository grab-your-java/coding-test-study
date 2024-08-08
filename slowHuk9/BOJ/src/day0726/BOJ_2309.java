package day0726;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int n = sc.nextInt();
            if (n > 0 && n < 100) {
                height[i] = n;
            }
            sum += height[i];
        }
        sum = sum - 100; // 가짜 난쟁이 2명의 키의 합 

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 가짜 난쟁이의 인덱스를 찾고
                if (height[i] + height[j] == sum) {
                    int[] result = new int[7];
                    // 가짜 난쟁이 인덱스를 제외한 진짜 난쟁이들의 새로운 배열 생성 후 집어넣기
                    for (int k = 0, index = 0; k < height.length; k++) {
                        if (k != i && k != j) {
                            result[index] = height[k];
                            index++;
                        }
                    }
                    //오름차순 정렬
                    Arrays.sort(result);
                    //출력
                    for (int l = 0; l < result.length; l++) {
                        System.out.println(result[l]);
                    }
                }sc.close();
            }

        }
    }
}