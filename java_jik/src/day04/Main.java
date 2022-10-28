package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer; 

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		for(int i = 1; i <= T; i++) {
//			num1 = Integer.parseInt(st.nextToken());
//			num2 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			bw.write(Integer.parseInt(st.nextToken()) + (Integer.parseInt(st.nextToken())) + "\n");
		}
		 
		bw.close();
	}

}
