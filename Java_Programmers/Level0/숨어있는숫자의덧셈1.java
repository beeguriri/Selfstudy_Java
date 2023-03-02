package Java_Programmers.Level0;

public class 숨어있는숫자의덧셈1 {
	
	/* 문자열 my_string이 매개변수로 주어집니다. 
	 * my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 : my_string은 소문자, 대문자 그리고 한자리 자연수로만 구성되어있습니다.
	 * */
	
	//int <-> String <-> char 간의 형 변환
	//String을 int로 변환 : Integer.parseInt(String)
	//char를 String으로 변환 : String.valueOf(char)
	//String을 char로 변환 : charAt()
	
	//String 관련 함수
	//split => String 을 String[] 으로 반환
	//replace => String을 String으로 반환
	
	
    public int solution(String my_string) {
        int answer = 0;
        String s = my_string.replaceAll("[^0-9]", "");
//      String [] s1 = my_string.replaceAll("[^0-9]","").split("");
        
        for (int i =0; i<s.length(); i++)
        	answer += Integer.parseInt(String.valueOf(s.charAt(i)));

        return answer;
    }

	public static void main(String[] args) {

		숨어있는숫자의덧셈1 a = new 숨어있는숫자의덧셈1();
		
		String s1 = "aAb1B2cC34oOp";	//10
//		System.out.println(s1.replaceAll("[^0-9]", ""));
		System.out.println(a.solution(s1));
		
		String s2 = "1a2b3c4d123"; //16
		System.out.println(a.solution(s2));
		
	}

}
