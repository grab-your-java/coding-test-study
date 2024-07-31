package ant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp = br.readLine();
		int W = Integer.valueOf(temp.split(" ")[0]);
		int H = Integer.valueOf(temp.split(" ")[1]);

		temp = br.readLine();
		int x = Integer.valueOf(temp.split(" ")[0]);
		int y = Integer.valueOf(temp.split(" ")[1]);
		int T = Integer.valueOf(br.readLine());
		
		int nextXIdx = T % (2 * W);
		int newX = x + nextXIdx;
		if (newX >= W) {
			newX = Math.abs(2 * W - newX);
		}

		int nextYIdx = T % (2 * H);
		int newY = y + nextYIdx;
		if (newY >= H) {
			newY = Math.abs(2 * H - newY);
		}

		bw.write(newX + " " + newY);
		
		bw.close();
		br.close();

	}
}