package Java_Programmers.Level0;

import java.util.Arrays;

public class 배열원소의길이 {
	
	/* 문자열 배열 strlist가 매개변수로 주어집니다. 
	 * strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
	 * */
	
	static int[] solution(String[] strlist) {
        int[] answer = new int [strlist.length];
        for(int i=0; i<strlist.length; i++) 
            answer[i] = strlist[i].length();
        
        return answer;
    }
	
	public static void main(String[] args) {

		String[] s1 = {"We", "are", "the", "world!"};
		System.out.println(Arrays.toString(solution(s1)));
		
		String[] s2 = {"I", "Love", "Programmers."};
		System.out.println(Arrays.toString(solution(s2)));

	}

}
