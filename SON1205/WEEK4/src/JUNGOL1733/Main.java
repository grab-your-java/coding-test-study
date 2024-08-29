package JUNGOL1733;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int r = -1;
        int c = -1;
        boolean Bwin = false;
        boolean Wwin = false;

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
                // 가로 5개
                for (int idx = 0; idx < 5; idx++) {
                    if (arr[i][j + idx] != 1) {
                        break;
                    }

                    if (idx == 4) {
                        boolean isValid = true;

                        if (j + 5 < 19) {
                            if (arr[i][j + 5] == 1) {
                                isValid = false;
                            }
                        }

                        if (j - 1 >= 0) {
                            if (arr[i][j - 1] == 1) {
                                isValid = false;
                            }
                        }

                        if (isValid) {
                            Bwin = true;
                            r = i;
                            c = j;
                            System.out.println(1);
                            System.out.println((r + 1) + " " + (c + 1));
                            return;
                        }
                    }
                }

                for (int idx = 0; idx < 5; idx++) {
                    if (arr[i][j + idx] != 2) {
                        break;
                    }

                    if (idx == 4) {
                        boolean isValid = true;

                        if (j + 5 < 19) {
                            if (arr[i][j + 5] == 2) {
                                isValid = false;
                            }
                        }

                        if (j - 1 >= 0) {
                            if (arr[i][j - 1] == 2) {
                                isValid = false;
                            }
                        }

                        if (isValid) {
                            Wwin = true;
                            r = i;
                            c = j;
                            System.out.println(2);
                            System.out.println((r + 1) + " " + (c + 1));
                            return;
                        }
                    }
                }

                // 세로 5개
                for (int idx = 0; idx < 5; idx++) {
                    if (arr[j + idx][i] != 1) {
                        break;
                    }

                    if (idx == 4) {
                        boolean isValid = true;

                        if (j + 5 < 19) {
                            if (arr[j + 5][i] == 1) {
                                isValid = false;
                            }
                        }

                        if (j - 1 >= 0) {
                            if (arr[j - 1][i] == 1) {
                                isValid = false;
                            }
                        }

                        if (isValid) {
                            Bwin = true;
                            r = j;
                            c = i;
                            System.out.println(1);
                            System.out.println((r + 1) + " " + (c + 1));
                            return;
                        }
                    }
                }

                for (int idx = 0; idx < 5; idx++) {
                    if (arr[j + idx][i] != 2) {
                        break;
                    }

                    if (idx == 4) {
                        boolean isValid = true;

                        if (j + 5 < 19) {
                            if (arr[j + 5][i] == 2) {
                                isValid = false;
                            }
                        }

                        if (j - 1 >= 0) {
                            if (arr[j - 1][i] == 2) {
                                isValid = false;
                            }
                        }

                        if (isValid) {
                            Wwin = true;
                            r = j;
                            c = i;
                            System.out.println(2);
                            System.out.println((r + 1) + " " + (c + 1));
                            return;
                        }
                    }
                }
            }
        }

        // 대각선
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 기울기 -1 대각선
                for (int idx = 0; idx < 5; idx++) {
                    if (i + 4 < 19 && j + 4 < 19) {
                        if (arr[i + idx][j + idx] != 1) {
                            break;
                        }

                        if (idx == 4) {
                            boolean isValid = true;

                            if (i + 5 < 19 && j + 5 < 19) {
                                if (arr[i + 5][j + 5] == 1) {
                                    isValid = false;
                                }
                            }

                            if (i - 1 >= 0 && j - 1 >= 0) {
                                if (arr[i - 1][j - 1] == 1) {
                                    isValid = false;
                                }
                            }

                            if (isValid) {
                                Bwin = true;
                                r = i;
                                c = j;
                                System.out.println(1);
                                System.out.println((r + 1) + " " + (c + 1));
                                return;
                            }
                        }
                    }
                }

                for (int idx = 0; idx < 5; idx++) {
                    if (i + 4 < 19 && j + 4 < 19) {
                        if (arr[i + idx][j + idx] != 2) {
                            break;
                        }

                        if (idx == 4) {
                            boolean isValid = true;

                            if (i + 5 < 19 && j + 5 < 19) {
                                if (arr[i + 5][j + 5] == 2) {
                                    isValid = false;
                                }
                            }

                            if (i - 1 >= 0 && j - 1 >= 0) {
                                if (arr[i - 1][j - 1] == 2) {
                                    isValid = false;
                                }
                            }

                            if (isValid) {
                                Wwin = true;
                                r = i;
                                c = j;
                                System.out.println(2);
                                System.out.println((r + 1) + " " + (c + 1));
                                return;
                            }
                        }
                    }
                }

                // 기울기 1 대각선
                for (int idx = 0; idx < 5; idx++) {
                    if (0 <= j - 4 && i + 4 < 19) {
                        if (arr[i + idx][j - idx] != 1) {
                            break;
                        }

                        if (idx == 4) {
                            boolean isValid = true;

                            if (0 <= j - 5 && i + 5 < 19) {
                                if (arr[i + 5][j - 5] == 1) {
                                    isValid = false;
                                }
                            }

                            if (i - 1 >= 0 && j + 1 < 19) {
                                if (arr[i - 1][j + 1] == 1) {
                                    isValid = false;
                                }
                            }

                            if (isValid) {
                                Bwin = true;
                                r = i + 4;
                                c = j - 4;
                                System.out.println(1);
                                System.out.println((r + 1) + " " + (c + 1));
                                return;
                            }
                        }
                    }
                }

                for (int idx = 0; idx < 5; idx++) {
                    if (0 <= j - 4 && i + 4 < 19) {
                        if (arr[i + idx][j - idx] != 2) {
                            break;
                        }

                        if (idx == 4) {
                            boolean isValid = true;

                            if (0 <= j - 5 && i + 5 < 19) {
                                if (arr[i + 5][j - 5] == 2) {
                                    isValid = false;
                                }
                            }

                            if (i - 1 >= 0 && j + 1 < 19) {
                                if (arr[i - 1][j + 1] == 2) {
                                    isValid = false;
                                }
                            }

                            if (isValid) {
                                Wwin = true;
                                r = i + 4;
                                c = j - 4;
                                System.out.println(2);
                                System.out.println((r + 1) + " " + (c + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }

        if (!Bwin && !Wwin) {
            System.out.println(0);
        }

    }
}