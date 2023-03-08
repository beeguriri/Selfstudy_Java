package Java_Programmers.Level0;

import java.util.Arrays;

public class 연속된수의합 {
	
	/* 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 
	 * 두 정수 num과 total이 주어집니다. 
	 * 연속된 수 num개를 더한 값이 total이 될 때, 
	 * 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
	 * */

	/*
	 *  3	12	[3, 4, 5]
		5	15	[1, 2, 3, 4, 5]
		4	14	[2, 3, 4, 5]
		5	5	[-1, 0, 1, 2, 3]
	 * */
	
    public int[] solution(int num, int total) {
        int[] answer = new int [num];
        
        int first = (2*total + num - num*num) / (2*num);
        
        for(int i = 0; i<num; i++) 
        	answer[i] = first++;
        
        return answer;
    }
    
	public static void main(String[] args) {

		연속된수의합 a = new 연속된수의합();
		
		System.out.println(Arrays.toString(a.solution(3, 12)));
	}

}
