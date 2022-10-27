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
		
		int num1, num2, result;
		
		bw.write("테스트 횟수를 입력하세요 : ");
		bw.flush(); 
		int T = Integer.parseInt(bf.readLine());
		
		bw.write("두 정수를 입력하세요 : ");
		bw.flush(); 
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= T; i++) {
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			result = num1 + num2;
			bw.write(result);
			bw.flush();
		}
		
		

		bw.flush();   
		bw.close();
	}

}
