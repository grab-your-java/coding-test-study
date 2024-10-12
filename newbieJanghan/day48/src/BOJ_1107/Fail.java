package BOJ_1107;

import java.util.Scanner;

public class Fail {
    static int channel, maxChannelInput, approximate;
    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        channel = sc.nextInt();
        int m = sc.nextInt();
        broken = new boolean[10];
        while (m-- > 0) {
            broken[sc.nextInt()] = true;
        }


        maxChannelInput = 1;
        while (channel / (int) Math.pow(10, maxChannelInput) > 0) {
            maxChannelInput++;
        }

        if (maxChannelInput >= Math.abs(channel-100)) {
            System.out.println(Math.abs(channel-100));
            return;
        }

        approximate = 100;
        dfs(new StringBuilder().append(0), 0);

        int fromApproximate = String.valueOf(approximate).length() + Math.abs(channel - approximate);
        int from100 = Math.abs(channel - 100);

        System.out.println(Math.min(fromApproximate, from100));
    }

    static void dfs(StringBuilder sb, int round) {
        if (round >= maxChannelInput -1) {
            int cur = parseInt(sb);
            if (Math.abs(channel - cur) < Math.abs(channel - approximate)) {
                approximate = cur;
            }
        }

        if (round == maxChannelInput) {
            return;
        }

        for (int curNum = 0; curNum <= 9; curNum++) {
            if (!broken[curNum]) {
                sb.append(curNum);
                dfs(sb, round + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static int parseInt(StringBuilder sb) {
        return Integer.parseInt(sb.toString());
    }
}