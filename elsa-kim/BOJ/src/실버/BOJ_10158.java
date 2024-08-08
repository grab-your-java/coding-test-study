package 실버;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10158 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		String[] line1 = br.readLine().split(" ");
		
		int w = Integer.parseInt(line1[0]);
		int h = Integer.parseInt(line1[1]);
		line1 = br.readLine().split(" ");
		int p = Integer.parseInt(line1[0]);
		int q = Integer.parseInt(line1[1]);
		int t = Integer.parseInt(br.readLine());
		
		p+=t%(2*w);
		q+=t%(2*h);
		
		if(p>w) {
			p=Math.abs(2*w-p);
		}
		if(q>h) {
			q=Math.abs(2*h-q);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(p+" "+q);
		bw.flush();
		bw.close();
	}
}
