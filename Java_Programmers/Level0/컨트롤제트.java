package Java_Programmers.Level0;

import java.util.Arrays;

public class 컨트롤제트 {
	
	/* 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다. 
	 * 문자열에 있는 숫자를 차례대로 더하려고 합니다. 
	 * 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다. 
	 * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 
	 * 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
	 * */
	
    public int solution(String s) {
        int answer = 0;
        String [] str = s.split(" ");
        
        for(int i=0; i<str.length; i++) {
        	
        	if(!str[i].equals("Z"))
        		answer += Integer.parseInt(str[i]);
        	else answer -= Integer.parseInt(str[i-1]);
        }
        return answer;
    }

	public static void main(String[] args) {

		컨트롤제트 a = new 컨트롤제트();
		
		String s1 = "1 2 Z 3";
		System.out.println(a.solution(s1));	//4
		
		String s2 = "10 20 30 40";
		System.out.println(a.solution(s2));	//100

		String s3 = "10 Z 20 Z 1";
		System.out.println(a.solution(s3));	//1

		String s4 = "10 Z 20 Z";
		System.out.println(a.solution(s4));	//0
		
		String s5 = "-1 -2 -3 Z";
		System.out.println(a.solution(s5));	//-3
		
	}

}
