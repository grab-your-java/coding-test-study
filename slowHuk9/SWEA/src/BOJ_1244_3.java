import java.util.Scanner;

public class BOJ_1244_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int switches = sc.nextInt();
        int[] arr = new int[switches];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int st = sc.nextInt(); // 학생 수
        if (st <= 100 && switches <= 100) {

            for (int i = 1; i <= st; i++) {
                int gender = sc.nextInt(); // 1이면 남자 2는 여자
                int n = sc.nextInt(); // 스위치번호

                // 남자라면
                if (gender == 1) {
                    // n 의 배수 들을 토글
                    for (int j = n - 1; j < arr.length; j += n) {
                        if (arr[j] == 0) {
                            arr[j] = 1;
                        } else {
                            arr[j] = 0;
                        }

                    }
                    // System.out.println(Arrays.toString(arr)); // 남자 구현
                } else {// 여자일때
                    int j = 1;
                    int index = n - 1;
                    // 스위치번호는 무조건 토글하기 때문에
                    if (arr[index] == 0) {
                        arr[index] = 1;
                    } else if (arr[index] == 1) {
                        arr[index] = 0;
                    }

                    while (((index - j >= 0) && (index + j) <= arr.length) && arr[index - j] == arr[index + j]) { // 대칭일때
                        if (arr[index - j] == 0) {
                            arr[index - j] = 1;
                            arr[index + j] = 1;
                        } else if (arr[index - j] == 1) {
                            arr[index - j] = 0;
                            arr[index + j] = 0;
                        }
                        j++;
                        // System.out.println(j);
                        // System.out.println(Arrays.toString(arr));

                    }
                }
            } // for문
            // System.out.println("for문 나옴");
            // System.out.println(Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                if (i > 0 && i % 20 == 0) {
                    System.out.println();
                }
            }
        }
    }
}