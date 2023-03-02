package Java_Programmers.Level0;

import java.util.Arrays;

public class 삼각형의완성조건1 {
	
	/* 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
	 * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
	 * 삼각형의 세 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 
	 * 세 변으로 삼각형을 만들 수 있다면 1, 
	 * 만들 수 없다면 2를 return하도록 solution 함수를 완성해주세요.
	 * */

	 public int solution(int[] sides) {
		 
	        int answer = 0;
	        Arrays.sort(sides);
	        
	        if(sides[2] < sides[0] + sides[1]) answer = 1;
	        else answer = 2;
	        
	        return answer;
	    }
	
	public static void main(String[] args) {

		삼각형의완성조건1 a = new 삼각형의완성조건1();
		
		int [] sides1 = {1, 2, 3};
		System.out.println(a.solution(sides1)); //2
		
		int [] sides2 = {3, 6, 2};
		System.out.println(a.solution(sides2)); //2
		
		int [] sides3 = {199, 72, 222};
		System.out.println(a.solution(sides3)); //1
		
	}

}
