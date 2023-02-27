package Java_Programmers.Level0;

import java.util.Arrays;

public class 배열자르기 {
	
	/* 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때, 
	 * numbers의 num1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 
	 * return 하도록 solution 함수를 완성해보세요.
	 * 제한사항 :
	 * 2 ≤ numbers의 길이 ≤ 30
	 * 0 ≤ numbers의 원소 ≤ 1,000
	 * 0 ≤num1 < num2 < numbers의 
	 * */

	static int[] solution(int[] numbers, int num1, int num2) {
        
		int answer [] = new int [num2 - num1 + 1];
		
		for (int i = num1, j = 0; i <= num2 +1 && j <answer.length ; i++, j++) {
			answer[j] = numbers[i];
		}
        return answer;
    }
	
	static int [] solution1(int [] numbers, int num1, int num2) {
		
        return Arrays.copyOfRange(numbers, num1, num2 + 1);		
	}
	
	public static void main(String[] args) {

		int [] arr1 = {1,2,3,4,5};
		int [] res1 = solution(arr1, 1,3);
		int [] res11 = solution1(arr1, 1,3);
		System.out.println("res1 : " + Arrays.toString(res1));
		System.out.println("res11 : " + Arrays.toString(res11));

		int [] arr2 = {1,3,5};
		int [] res2 = solution(arr2, 1,2);
		System.out.println("res2 : " + Arrays.toString(res2));

	}

}
