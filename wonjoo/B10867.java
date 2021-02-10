package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//중복 빼고 정렬하기
public class B10867 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());// 배열 개수
		//int[] nums = new int[N];// 배열 생성
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashSet<Integer> arr2 = new HashSet<Integer>();// 중복값 제거

		// Queue<Integer> queue = new LinkedList<>();
		//ArrayList<Integer> arr1 = new ArrayList<>();
		//st = new StringTokenizer(br.readLine(), " ");// 새로 한 줄 받기

		for (int i = 0; i < N; i++) {
			arr2.add(Integer.parseInt(st.nextToken()));
			// Arrays.sort(nums);
		}	
		
		ArrayList<Integer> arr3 = new ArrayList<>(arr2);

		for (int j = 0; j < arr2.size(); j++) {
			arr3.get(j);
			//요소 하나씩 빼기
		}			
		System.out.println(arr3.toString().replace("[", "").replace("]", "").replace(",",""));

		// }
	}
}
