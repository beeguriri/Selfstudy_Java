package Java_Programmers.Level0;

public class 숨어있는숫자의덧셈2 {

	/* 문자열 my_string이 매개변수로 주어집니다. 
	 * my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. 
	 * my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 :
	 * 1 ≤ my_string 안의 자연수 ≤ 1000
	 * 연속된 수는 하나의 숫자로 간주합니다.
	 * 문자열에 자연수가 없는 경우 0을 return 해주세요.
	 * */
	
    public int solution(String my_string) {
        int answer = 0;
        
        String [] s = my_string.replaceAll("[^0-9]", " ").split(" ");
        
        for(int i = 0; i<s.length; i++) {
        	
        	if(s[i].equals(""))	continue;
        	else	answer += Integer.parseInt(s[i].trim());
        	
        }
        return answer;
    }
	
	public static void main(String[] args) {

		숨어있는숫자의덧셈2 a = new 숨어있는숫자의덧셈2();
		
		String s1 = "aAb1B2cC34oOp";
		System.out.println(a.solution(s1)); //37
		
		String s2 = "1a2b3c4d123Z";	
		System.out.println(a.solution(s2));	//133
		
	}

}
