package swea_2383;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<Person> persons;
    static int N; // persons.size();
    static boolean[] collected;

    static Stair stair1, stair2;
    static int[] s1waitList, s2waitList;
    static int minTime;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int n = sc.nextInt();
            persons = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int input = sc.nextInt();
                    // persons
                    if (input == 1) {
                        persons.add(new Person(r, c));
                    }
                    // stairs
                    else if (input > 1) {
                        if (stair1 == null) {
                            stair1 = new Stair(r, c, input);
                        } else {
                            stair2 = new Stair(r, c, input);
                        }
                    }
                }
            }
            N = persons.size();
            collected = new boolean[N];
            minTime = Integer.MAX_VALUE;

            makeSubsets(0);

            sb.append(minTime).append("\n");
        }
        System.out.println(sb);
    }

    static void makeSubsets(int depth) {
        if (depth == N) {
            System.out.println(Arrays.toString(collected));

            s1waitList = new int[100];
            s2waitList = new int[100];
            for (int i = 0; i < N; i++) {
                // partA
                if (collected[i]) {
                    int dist = calDistance(persons.get(i), stair1);
                    for (int time = dist + 1; time <= dist + stair1.time; time++) {
                        s1waitList[time]++;
                    }
                }
                // partB
                else {
                    int dist = calDistance(persons.get(i), stair2);
                    for (int time = dist + 1; time <= dist + stair2.time; time++) {
                        s2waitList[time]++;
                    }
                }
            }
            
            System.out.println(Arrays.toString(s1waitList));
            System.out.println(Arrays.toString(s2waitList));

            int s1Time = 0;
            for (int time = 0; time < s1waitList.length; time++) {
                if (s1waitList[time] > 0) {
                    s1Time = time;
                }
                if (s1waitList[time] > 3) {
                    s1waitList[time + 1] += s1waitList[time] - 3;
                }
            }

            int s2Time = 0;
            for (int time = 0; time < s2waitList.length; time++) {
                if (s2waitList[time] > 0) {
                    s2Time = time;
                }
                if (s2waitList[time] > 3) {
                    s2waitList[time + 1] += s2waitList[time] - 3;
                }
            }

            minTime = Math.min(minTime, Math.max(s1Time, s2Time));
            return;
        }

        collected[depth] = true;
        makeSubsets(depth + 1);
        collected[depth] = false;
        makeSubsets(depth + 1);
    }

    static class Person {
        int r, c;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Stair {
        int r, c, time;

        public Stair(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int calDistance(Person person, Stair stair) {
        return Math.abs(person.r - stair.r) + Math.abs(person.c - stair.c);
    }
}
