package SWEA_4014_활주로_건설;

import java.util.Scanner;

public class Solution {
    static int[][] area;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            area = new int[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    area[r][c] = sc.nextInt();
                }
            }

            int result = 0;
            Row:
            for (int r = 0; r < N; r++) {
                boolean construction = false;
                int succession = 1;
                for (int c = 1; c < N; c++) {
//                    System.out.println("[ " + r + ", " + c + " ] = " + area[r][c] + " // construct:  " + construction + ", succession: " + succession);
                    int prev = area[r][c - 1];
                    int cur = area[r][c];

                    if (prev + 1 < cur || prev - 1 > cur) {
                        continue Row;
                    }

                    if (prev == cur) {
                        succession++;
                    }
                    // check ascendant
                    else if (prev + 1 == cur) {
                        if (succession < X) {
//                            System.out.println("Case1 / at [ " + r + ", " + c + " ] has failed to construct");
                            continue Row;
                        }
                        succession = 1;
                    }
                    // check descendant
                    else if (prev - 1 == cur) {
                        if (construction && succession < X) {
//                            System.out.println("Case2 / at [ " + r + ", " + c + " ] has failed to construct");
                            continue Row;
                        }
                        construction = true;
                        succession = 1;
                    }

                    if (construction && succession == X) {
                        construction = false;
                        succession = 1;
                    }
//                    System.out.println("[ " + r + ", " + c + " ] = " + area[r][c] + " // construct:  " + construction + ", succession: " + succession);
                }

                if (!construction) {
                    result++;
//                    System.out.println("**Success**");
                } else {
//                    System.out.println("Case3, row " + r + " has failed to construct");
                }
            }

            Col:
            for (int c = 0; c < N; c++) {
                boolean construction = false;
                int succession = 1;
                for (int r = 1; r < N; r++) {
//                    System.out.println("[ " + r + ", " + c + " ] = " + area[r][c] + " // construct:  " + construction + ", succession: " + succession);
                    int prev = area[r - 1][c];
                    int cur = area[r][c];

                    if (prev + 1 < cur || prev - 1 > cur) {
                        continue Col;
                    }

                    if (prev == cur) {
                        succession++;
                    }
                    // check ascendant
                    else if (prev + 1 == cur) {
                        if (succession < X) {
//                            System.out.println("Case1 / at [ " + r + ", " + c + " ] has failed to construct");
                            continue Col;
                        }
                        succession = 1;
                    }
                    // check descendant
                    else if (prev - 1 == cur) {
                        if (construction && succession < X) {
//                            System.out.println("Case2 / at [ " + r + ", " + c + " ] has failed to construct");
                            continue Col;
                        }
                        construction = true;
                        succession = 1;
                    }

                    if (construction && succession == X) {
                        construction = false;
                        succession = 1;
                    }
//                    System.out.println("[ " + r + ", " + c + " ] = " + area[r][c] + " // construct:  " + construction + ", succession: " + succession);
                }

                if (!construction) {
                    result++;
//                    System.out.println("**Success**");
                } else {
//                    System.out.println("Case3, col " + c + " has failed to construct");
                }
            }

            System.out.println("#" + i + " " + result);
        }
    }
}
