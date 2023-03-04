package Java_Programmers.Level0;

import java.util.Arrays;

public class 최댓값만들기2 {

	/* 정수 배열 numbers가 매개변수로 주어집니다. 
	 * numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 
	 * solution 함수를 완성해주세요.
	 * */
	
    public int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        int n1 = numbers[0]*numbers[1];
        int n2 = numbers[numbers.length-1] * numbers[numbers.length-2];
        
    	if(n1<n2)	answer = n2;
    	else	answer = n1;
        
        return answer;
    }
    
	public static void main(String[] args) {

		최댓값만들기2 a = new 최댓값만들기2();
		
		int [] list1 = {1, 2, -3, 4, -5}; 
		System.out.println(a.solution(list1));	//15
		
		int [] list2 = {0, -31, 24, 10, 1, 9};
		System.out.println(a.solution(list2));	//240
		
		int [] list3 = {10, 20, 30, 5, 5, 20, 5};
		System.out.println(a.solution(list3));	//600

	}

}
