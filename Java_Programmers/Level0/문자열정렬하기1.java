package Java_Programmers.Level0;

import java.util.Arrays;

public class 문자열정렬하기1 {
	
	/* 문자열 my_string이 매개변수로 주어질 때, 
	 * my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 
	 * solution 함수를 작성해보세요.
	 * 제한사항 : my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다.
	 * */

    public int[] solution(String my_string) {
    	
        String [] str = my_string.replaceAll("[^0-9]", "").split("");
        Arrays.sort(str);
        
        int answer [] = new int [str.length];
        
        for(int i = 0; i < answer.length; i++)
        	answer[i] = Integer.parseInt(str[i]);
        
        return answer;
    }
	
	public static void main(String[] args) {

		문자열정렬하기1 a = new 문자열정렬하기1();
		
		String str1 = "hi12392"; //[1, 2, 2, 3, 9]
		System.out.println(Arrays.toString(a.solution(str1)));
		
		String str2 = "p2o4i8gj2";
		System.out.println(Arrays.toString(a.solution(str2)));

		
		String str3 = "abcde0";
		System.out.println(Arrays.toString(a.solution(str3)));

	}

}
