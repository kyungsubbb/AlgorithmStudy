package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935_문자열_폭발 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder st = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String str = input.readLine();
		String boom = input.readLine();
		
		char[] output = new char[str.length()];
		int idx=0;
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if( c ==(boom.charAt(boom.length()-1))){
				if(idx<boom.length()-1) {
					output[idx++] =c;
				}else {
					boolean flag =true;
					for(int j = idx -1, k = boom.length()-2;k>=0;j--,k--) {
						if(output[j] != boom.charAt(k)) {
							flag = false;
							break;
						}
					}
					if(flag) {
						// 12a'b' 일 때 idx = 3 - (4-1) => 0으로
						idx = idx - (boom.length() - 1);
					}else {
						output[idx++] =c;
					}
				}
			}else {
				output[idx++] =c;
			}
		}
		if(idx==0) {
			st.append("FRULA");
		}else {
			for(int i=0;i<idx;i++) {
				st.append(output[i]);
			}
		}
		System.out.println(st);
		
	}

}
