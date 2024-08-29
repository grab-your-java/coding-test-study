package SWEA2382;

import java.util.*;

public class SWEA2382 {
    static int delta = 1;

    static class Virus {
        int r;
        int c;
        int count;
        int direction;

        Virus(int r, int c, int count, int direction) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Virus virus = (Virus) object;
            return r == virus.r && c == virus.c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            List<Virus> list = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                list.add(new Virus(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }

            for (int i = 0; i < M; i++) {
                //이동 + 벽에 닿을 때, 방향 반대 + 개체 수 절반 감소(만약 개체 수가 0이면 remove)
                for (int j = 0; j < list.size(); j++) {
                    Virus v = list.get(j);
                    switch (v.direction) {
                        case 1:
                            if (v.r - delta == 0) {
                                v.direction = 2;
                                v.count /= 2;
                            }
                            v.r -= delta;
                            break;
                        case 2:
                            if (v.r + delta == N - 1) {
                                v.direction = 1;
                                v.count /= 2;
                            }
                            v.r += delta;
                            break;
                        case 3:
                            if (v.c - delta == 0) {
                                v.direction = 4;
                                v.count /= 2;
                            }
                            v.c -= delta;
                            break;
                        default:
                            if (v.c + delta == N - 1) {
                                v.direction = 3;
                                v.count /= 2;
                            }
                            v.c += delta;
                    }
                }

                //좌표가 겹칠 때, 가장 큰 개체의 방향, 만나는 미생물들의 합
                for (int j = 0; j < list.size() - 1; j++) {
                    Virus tmp = list.get(j);
                    if (tmp.count == 0) {
                        continue;
                    }
                    int sum = 0;
                    for (int k = j + 1; k < list.size(); k++) {
                        if (tmp.equals(list.get(k))) {
                            if (tmp.count < list.get(k).count) {
                                sum += tmp.count;
                                tmp.count = 0;
                                tmp = list.get(k);
                            } else {
                                sum += list.get(k).count;
                                list.get(k).count = 0;
                            }
                        }
                    }
                    tmp.count += sum;
                }

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).count == 0) {
                        list.remove(j);
                    }
                }
            }

            int result = 0;
            for (int i = 0; i < list.size(); i++) {
                result += list.get(i).count;
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
