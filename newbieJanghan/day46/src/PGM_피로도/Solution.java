package PGM_피로도;

public class Solution {
    int answer, dungeonCnt;
    int[][] dungeons;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.dungeonCnt = dungeons.length;

        visited = new boolean[this.dungeonCnt];
        dfs(0, k);
        return answer;
    }

    public void dfs(int round, int remain) {
        if (round == dungeonCnt) {
            return;
        }

        for (int i = 0; i < dungeonCnt; i++) {
            int[] dungeon = dungeons[i];
            if (!visited[i] && remain >= dungeon[0] && remain - dungeon[1] >= 0) {
                visited[i] = true;
                answer = Math.max(answer, round + 1);
                dfs(round + 1, remain - dungeon[1]);
                visited[i] = false;
            }
        }
    }
}
