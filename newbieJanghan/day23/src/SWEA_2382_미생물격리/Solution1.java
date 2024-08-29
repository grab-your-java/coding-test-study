package SWEA_2382_미생물격리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
 

/**
 * from swea user biiin
 */
public class Solution1 {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    static int size; // 구역 크기
    static int time; // 격리 시간
    static int bugCnt; // 군집 개수
    static List<Bug> bugs; // 군집 정보
 
    static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dy = { 0, 0, -1, 1 };
 
    static int ans;
 
    // 입력
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        size = Integer.parseInt(st.nextToken()); // 구역 크기 입력
        time = Integer.parseInt(st.nextToken()); // 격리 시간 입력
        bugCnt = Integer.parseInt(st.nextToken()); // 군집 개수 입력
 
        bugs = new ArrayList<>();
        // 군집 개수만큼 군집 정보 입력
        for (int idx = 1; idx <= bugCnt; idx++) {
            st = new StringTokenizer(br.readLine().trim());
            Bug bug = new Bug();
            bug.x = Integer.parseInt(st.nextToken());
            bug.y = Integer.parseInt(st.nextToken());
            bug.cnt = Integer.parseInt(st.nextToken()); // 미생물 수
            bug.direction = Integer.parseInt(st.nextToken()) - 1; // 이동 방향
            bug.idx = bug.x * size + bug.y; // 구역 위치
            bugs.add(bug);
        }
    }
 
    static void solve() {
        // 매 시간 마다 모든 군집이 이동
        for (int t = 0; t < time; t++) {
            for (int idx = 0; idx < bugs.size(); idx++) {
                Bug bug = bugs.get(idx);
                bug.x += dx[bug.direction];
                bug.y += dy[bug.direction];
                bug.idx = bug.x * size + bug.y;
                int nDir = bug.direction;
 
                // 약품 만남
                if (bug.x == 0 || bug.x == size - 1 || bug.y == 0 || bug.y == size - 1) {
                    // 반감
                    bug.cnt /= 2;
                    // 방향 반대로
                    if (nDir == 0) {
                        bug.direction = 1;
                    } else if (nDir == 1) {
                        bug.direction = 0;
                    } else if (nDir == 2) {
                        bug.direction = 3;
                    } else if (nDir == 3) {
                        bug.direction = 2;
                    }
                }
            }
 
            // 위치순, 미생물 역순으로 정렬
            Collections.sort(bugs);
 
            // 충돌 처리
            for (int idx = 0; idx < bugs.size() - 1; idx++) {
                Bug curBug = bugs.get(idx);
                Bug nxtBug = bugs.get(idx + 1);
 
                // 동일한 구역에 있음
                if (curBug.idx == nxtBug.idx) {
                    curBug.cnt += nxtBug.cnt;   // 앞 군집의 미생물 수가 더 많음
                    bugs.remove(idx + 1);   // 합쳐진 군집은 삭제
                    idx--;  // bugs.size() 조심
                }
            }
        }
 
        // 남아있는 미생물 수 구하기
        ans = 0;
        for (int idx = 0; idx < bugs.size(); idx++) {
            ans += bugs.get(idx).cnt;
        }
    }
 
    static class Bug implements Comparable<Bug> {
        int idx;
        int x;
        int y;
        int cnt;
        int direction;
 
        @Override
        public int compareTo(Bug o) {
            if (this.idx == o.idx) {
                return o.cnt - this.cnt;
            }
            return this.idx - o.idx;
        }
    }
 
    public static void main(String args[]) throws IOException {
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            input();
            solve();
            System.out.println("#" + test_case + " " + ans);
        }
    }
 
}