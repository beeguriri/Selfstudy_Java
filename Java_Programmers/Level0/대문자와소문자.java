package Java_Programmers.Level0;

public class 대문자와소문자 {
	
	/* 문자열 my_string이 매개변수로 주어질 때, 
	 * 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 
	 * solution 함수를 완성해주세요.
	 * */
	
    public String solution(String my_string) {

    	String answer = "";

    	for(char c : my_string.toCharArray()) {
    		
    		if(Character.isUpperCase(c))	answer += Character.toLowerCase(c);
    		else answer += Character.toUpperCase(c);
    	}
    		
        return answer;
    }

	public static void main(String[] args) {

		대문자와소문자 a = new 대문자와소문자();
		
		System.out.println(a.solution("cccCCC"));
		
		System.out.println(a.solution("abCdEfghIJ"));
	}

}
