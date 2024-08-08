import java.util.Scanner;

public class BOJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
        }

        System.out.println(minTurnaround(time));
    }

    static int minTurnaround(int[] time) {
        time = sort(time);

        int sum = 0;

        for (int i = 0; i < time.length; i++) {
            sum += time[i] * (time.length - i);
        }

        return sum;
    }

    private static int[] sort(int[] time) {
        int[] counting = new int[1001];
        int[] result = new int[time.length];

        for (int i = 0; i < time.length; i++) {
            counting[time[i]]++;
        }

        for (int i = 1; i < 1001; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = time.length - 1; i >= 0; i--) {
            result[--counting[time[i]]] = time[i];
        }

        return result;
    }
}
