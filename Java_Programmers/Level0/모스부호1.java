package Java_Programmers.Level0;

import java.util.HashMap;
import java.util.Map;

public class 모스부호1 {

	/* 문자열 letter가 매개변수로 주어질 때, 
	 * letter를 영어 소문자로 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
	 * letter의 모스부호는 공백으로 나누어져 있습니다.
	 * */
		
	static String solution(String letter) {
		
        String answer = "";

		String [] morse = {".-","-...","-.-.","-..",".","..-.","--.",
				"....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
				".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		
		Map<String, String> map = new HashMap<String, String>();

		for (int i=0; i<morse.length; i++) 
			map.put(morse[i], String.valueOf((char)(i + 97)));
		
		//letter 확인
		String [] temp = letter.split(" ");
		
		for (int i=0; i<temp.length; i++) {
			
			answer += map.get(temp[i]);
		}
		
        return answer;
    }
	
	
	public static void main(String[] args) {

		String letter1 = ".... . .-.. .-.. ---";
		System.out.println(solution(letter1));
		
		String letter2 = ".--. -.-- - .... --- -."	;
		System.out.println(solution(letter2));
		
//		System.out.println(map.keySet());
//		System.out.println(map.values());
//		System.out.println(map.size());
		
	}

}
