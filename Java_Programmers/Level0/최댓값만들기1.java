package Java_Programmers.Level0;

import java.util.Arrays;

public class 최댓값만들기1 {

	/* 정수 배열 numbers가 매개변수로 주어집니다. 
	 * numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 
	 * solution 함수를 완성해주세요.
	 * 제한사항 : 
	 * 0 ≤ numbers의 원소 ≤ 10,000
	 * 2 ≤ numbers의 길이 ≤ 100
	 * */
	
	public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1]*numbers[numbers.length-2];
    }
	
	public static void main(String[] args) {

		최댓값만들기1 a = new 최댓값만들기1();
		
		int [] nums1 = {1, 2, 3, 4, 5};
		System.out.println(a.solution(nums1)); //20
		
		int [] nums2 = {0, 31, 24, 10, 1, 9};
		System.out.println(a.solution(nums2)); //744
	}

}
