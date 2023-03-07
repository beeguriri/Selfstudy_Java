package Java_Programmers.Level0;

import java.util.Arrays;

public class 삼각형의완성조건2 {
	
	/* 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
	 * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
	 * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 
	 * 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
	 * [1, 2]	1 
	 * [3, 6]	5
	 * -> 6이 제일 긴변일때 가능한것 : 4,5,6
	 * => (6-3) < n <= 6
	 * -> 긴변이 임의의 수일때 : 8, 7
	 * => 6 < n < (6+3)
	 * [11, 7]	13
	 * -> 11이 제일 긴변일때 : (n+7) > 11 , n= 5,6,7,8,9,10,11 (7가지) 
	 * => (11-7) < n <= 11
	 * -> 임의의수일때 : 12,13,14,15,16,17 (6가지)
	 * => 11 < n < (11+7)
	 * */
	
    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        
        int min = sides[0];
        int max = sides[1];
        
        for(int i = max-min; i<max; i++) 
        	answer++;
        
        for(int i = max+1; i<min+max; i++)
        	answer++;
        
        return answer;
    }

	public static void main(String[] args) {

		삼각형의완성조건2 a = new 삼각형의완성조건2();
		
		int [] sides1 = {1, 2};
		System.out.println(a.solution(sides1));
		
		int [] sides2 = {3,6};
		System.out.println(a.solution(sides2));
		
		int [] sides3 = {11,7};
		System.out.println(a.solution(sides3));
		
	}

}
