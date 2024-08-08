package ant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] w_h = br.readLine().split(" ");
		int W = Integer.valueOf(w_h[0]);
		int H = Integer.valueOf(w_h[1]);

		String[] p_q = br.readLine().split(" ");
		int p = Integer.valueOf(p_q[0]);
		int q = Integer.valueOf(p_q[1]);

		int dx = 1;
		int dy = 1;

		int T = Integer.valueOf(br.readLine());
		for (int i = 0; i < T; i++) {
			if (p == 0 || p == W) {
				dx *= -1;
			}
			if (q == 0 || q == H) {
				dy *= -1;
			}
			p += dx;
			q += dy;
		}
		
		bw.write(p + " " + q);

		bw.close();
		br.close();
	}
}