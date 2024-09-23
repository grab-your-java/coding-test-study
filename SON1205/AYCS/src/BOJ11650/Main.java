package BOJ11650;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new int[]{sc.nextInt(), sc.nextInt()});
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[0] - o2[0] > 0) {
                return 1;
            } else if (o1[0] - o2[0] == 0) {
                if (o1[1] - o2[1] > 0) {
                    return 1;
                } else if (o1[1] - o2[1] == 0) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
//        new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] - o2[0] > 0) {
//                    return 1;
//                } else if (o1[0] - o2[0] == 0) {
//                    if (o1[1] - o2[1] > 0) {
//                        return 1;
//                    } else if (o1[1] - o2[1] == 0) {
//                        return 0;
//                    } else {
//                        return -1;
//                    }
//                } else {
//                    return -1;
//                }
//            }
//        }
        );

        StringBuilder sb = new StringBuilder();
        for (int[] nums : list) {
            sb.append(nums[0]).append(" ").append(nums[1]).append("\n");
        }

        System.out.println(sb);

//        for (int[] nums : list) {
//            for (int num : nums) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
    }
}
