package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();// 입력 문자열
		String bomb = br.readLine();// 폭파 문자열
		int inputlen = input.length();// 입력 문자열 길이 받아오기
		int bomblen = bomb.length();// 폭파 문자열 길이 받아오기

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < inputlen; i++) {
			stack.push(input.charAt(i));// character형으로 바꿔주고 스택에 넣어준다.

			if (stack.size() >= bomblen) {// 폭파 문자열보다 길이가 길다면
				boolean isbomb = true;

				for (int j = 0; j < bomblen; j++) {
					if (stack.get(stack.size() - bomblen + j) != bomb.charAt(j)) {// 스택에서 받아온 길이(폭파문자열 제외)와 폭파 문자열 길이가 다르면
						isbomb = false;
						break;
					}
				}
				if (isbomb) {// 길이가 같다면
					for (int j = 0; j < bomblen; j++) {
						stack.pop();// 꺼내기
					}
				}
			}
		}
		for(char ch : stack) {
			sb.append(ch);
		}
		
		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
		/*
		 * if (stack.isEmpty()) {// 스택이 비어있다면 System.out.println("FRULA"); } else { for
		 * (Character character : stack) {// 스택에 남아있는 수만큼 반복 sb.append(character);// 꺼내서
		 * 출력 }System.out.println(sb); }
		 */
	}
}
