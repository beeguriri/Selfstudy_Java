package Java_Programmers.Level0;

import java.util.Arrays;

public class 인덱스바꾸기 {

	/* 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때, 
	 * my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 
	 * solution 함수를 완성해보세요.
	 * 제한사항 : num1 ≠ num2
	 * */
	
    public String solution(String my_string, int num1, int num2) {
        
    	String answer = "";
        
        char[] ch = my_string.toCharArray();
//        System.out.println(Arrays.toString(ch));
        
        ch[num1] = my_string.charAt(num2);
        ch[num2] = my_string.charAt(num1);
        
//        System.out.println(Arrays.toString(ch));

        answer = String.valueOf(ch);
        
        
        return answer;
    }
    
	public static void main(String[] args) {

		인덱스바꾸기 a = new 인덱스바꾸기();
		
		System.out.println(a.solution("hello", 1, 2)); //"hlelo"
		System.out.println(a.solution("I love you", 3, 6));	//"I l veoyou"
	}

}
