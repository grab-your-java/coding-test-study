import java.util.Scanner;

public class BOJ10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();

        int p = sc.nextInt();
        int q = sc.nextInt();

        boolean x = true;
        boolean y = true;

        int t = sc.nextInt();

        while (t > 0) {
            //우상향
            if (x && y) {
                int deltaX = w - p;
                int deltaY = h - q;

                if (t < deltaX || t < deltaY) {
                    p += t;
                    q += t;
                    break;
                }

                if (deltaX == deltaY) {
                    p = w;
                    q = h;
                    x = !x;
                    y = !y;
                    t -= deltaX;
                } else if (deltaX > deltaY) {
                    q = h;
                    p += deltaY;
                    y = !y;
                    t -= deltaY;
                } else {
                    p = w;
                    q += deltaX;
                    x = !x;
                    t -= deltaX;
                }

            } else if (!x && y) {//좌상향
                int deltaX = p;
                int deltaY = h - q;

                if (t < deltaX || t < deltaY) {
                    p -= t;
                    q += t;
                    break;
                }

                if (deltaX == deltaY) {
                    p = 0;
                    q = h;
                    x = !x;
                    y = !y;
                    t -= deltaX;
                } else if (deltaX > deltaY) {
                    q = h;
                    p -= deltaY;
                    y = !y;
                    t -= deltaY;
                } else {
                    p = 0;
                    q += deltaX;
                    x = !x;
                    t -= deltaX;
                }
            } else if (!x && !y) {//좌하향
                int deltaX = p;
                int deltaY = q;

                if (t < deltaX || t < deltaY) {
                    p -= t;
                    q -= t;
                    break;
                }

                if (deltaX == deltaY) {
                    p = 0;
                    q = 0;
                    x = !x;
                    y = !y;
                    t -= deltaX;
                } else if (deltaX > deltaY) {
                    q = 0;
                    p -= deltaY;
                    y = !y;
                    t -= deltaY;
                } else {
                    p = 0;
                    q -= deltaX;
                    x = !x;
                    t -= deltaX;
                }
            } else {//우하향
                int deltaX = w - p;
                int deltaY = q;

                if (t < deltaX && t < deltaY) {
                    p += t;
                    q -= t;
                    break;
                }

                if (deltaX == deltaY) {
                    p = w;
                    q = 0;
                    x = !x;
                    y = !y;
                    t -= deltaX;
                } else if (deltaX > deltaY) {
                    q = 0;
                    p += deltaY;
                    y = !y;
                    t -= deltaY;
                } else {
                    p = w;
                    q -= deltaX;
                    x = !x;
                    t -= deltaX;
                }
            }
        }

//        while (t > 0) {
//            int np = p + deltaX;
//            int nq = q + deltaY;
//
//            // 꼭지점에 닿을 때, 좌우에 닿을 때, 위아래에 닿을 때
//            if ((np == 0 && nq == 0) || (np == 0 && nq == h) ||
//                    (np == w && nq == 0) || (np == w && nq == h)) {
//                deltaX = -deltaX;
//                deltaY = -deltaY;
//            } else if (np == 0 || np == w) {
//                deltaX = -deltaX;
//            } else if (nq == 0 || nq == h) {
//                deltaY = -deltaY;
//            }
//
//            q = nq;
//            p = np;
//
//            t--;
//        }

        System.out.println(p + " " + q);
    }
}
