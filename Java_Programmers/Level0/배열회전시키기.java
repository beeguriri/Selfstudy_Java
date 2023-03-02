package mission;

import java.util.Arrays;

public class 배열회전시키기 {
	
	/* 정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다. 
	 * 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 : 
	 * 3 ≤ numbers의 길이 ≤ 20
	 * direction은 "left" 와 "right" 둘 중 하나입니다.
	 * */
	
	static int[] solution(int[] numbers, String direction) {
        int[] answer = new int [numbers.length];
        
        if(direction.equals("right")){
            for(int i = 0; i < answer.length - 1; i++)
                answer[i + 1] = numbers[i];
            answer[0] = numbers[numbers.length -1];
            
        }else {
            for(int i = 0; i < answer.length - 1; i++)
                answer[i] = numbers[i + 1];
            answer[answer.length - 1] = numbers[0];
        }
        return answer;
	}
	
	public static void main(String[] args) {
		
		int [] num1 = {1, 2, 3};
		System.out.println(Arrays.toString(solution(num1, "right"))); //[3, 1, 2]

		
		int [] num2 = {4, 455, 6, 4, -1, 45, 6};
		System.out.println(Arrays.toString(solution(num2, "left")));

	}

}
