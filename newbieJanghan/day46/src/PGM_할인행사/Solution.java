package PGM_할인행사;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            boolean success = true;
            for (int j = 0; j < want.length; j++) {
                if (map.getOrDefault(want[j], 0) != number[j]) {
                    success = false;
                    break;
                }
            }

            map.put(discount[i], map.get(discount[i]) - 1);
            if (i + 10 <= discount.length - 1) {
                map.put(discount[i + 10], map.getOrDefault(discount[i + 10], 0) + 1);
            }


            if (success) {
                answer++;
            }

        }

        return answer;
    }
}
