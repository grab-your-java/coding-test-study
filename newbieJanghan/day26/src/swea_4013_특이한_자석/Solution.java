package swea_4013_특이한_자석;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    static Magnetic[] magnetics;
    static boolean[] rotated;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int rotationCnt = sc.nextInt();
            magnetics = new Magnetic[5];
            for (int i = 1; i < magnetics.length; i++) {
                Magnetic magnetic = new Magnetic();
                int polesCnt = 8;
                while (polesCnt-- > 0) {
                    magnetic.add(sc.nextInt());
                }
                magnetics[i] = magnetic;

            }

            while (rotationCnt-- > 0) {
//                System.out.println("original");
//                for (Magnetic magnetic : magnetics) {
//                    if (magnetic == null) continue;
//                    System.out.println(magnetic.poles);
//                }

                rotated = new boolean[5]; // initialize rotated trial by trial;
                rotateSequence(sc.nextInt(), sc.nextInt());

            }

//            System.out.println("after");
//            for (Magnetic magnetic : magnetics) {
//                if (magnetic == null) continue;
//                System.out.println(magnetic.poles);
//            }

            int result = 0;
            for (int i = 1; i < magnetics.length; i++) {
                result += magnetics[i].poles.pollFirst() * (int) Math.pow(2.0, (double) i - 1);
            }
            System.out.println("#" + t + " " + result);
        }
    }

    static void rotateSequence(int index, int direction) {
        if (rotated[index]) {
            return;
        }

//        System.out.println("rotate : " + index);

        rotated[index] = true;
        int currentLeft = magnetics[index].left(), currentRight = magnetics[index].right();
        magnetics[index].rotate(direction);

        // try to rotate left magnetic
        if (index > 1 && magnetics[index - 1].right() != currentLeft) {
//            System.out.println("check left from " + index + " to " + (index - 1));
            rotateSequence(index - 1, direction * -1);
        }
        // try to rotate right magnetic
        if (index < 4 && magnetics[index + 1].left() != currentRight) {
//            System.out.println("check right from " + index + " to " + (index + 1));
            rotateSequence(index + 1, direction * -1);
        }
    }

    static class Magnetic {
        Deque<Integer> poles = new ArrayDeque<>();

        int size;
        private int _right = -1, _left = -1;

        // N = 0, S = 1
        void add(int pole) {
            poles.addLast(pole);
            size++;
        }

        int right() {
            if (_right != -1) {
                return _right;
            }

            Deque<Integer> temp = new ArrayDeque<>();
            int counter = 2;
            while (counter > 0) {
                temp.addLast(poles.removeFirst());
                counter--;
            }

            _right = poles.peek();
            while (counter < 2) {
                poles.addFirst(temp.removeLast());
                counter++;
            }

            return _right;
        }

        int left() {
            if (_left != -1) {
                return _left;
            }

            Deque<Integer> temp = new ArrayDeque<>();
            int counter = 1;
            while (counter > 0) {
                temp.addLast(poles.removeLast());
                counter--;
            }

            _left = poles.peekLast();
            while (counter < 1) {
                poles.addLast(temp.removeLast());
                counter++;
            }

            return _left;
        }

        void rotate(int direction) {
            if (direction == 1) { // clockwise
                poles.addFirst(poles.pollLast());
            } else {// anti
                poles.addLast(poles.pollFirst());
            }

            // remove left, right memoize
            _left = -1;
            _right = -1;
        }

        @Override
        public String toString() {
            return "Magnetic{" +
                    "poles=" + poles +
                    ", size=" + size +
                    ", _right=" + _right +
                    ", _left=" + _left +
                    '}';
        }
    }
}
