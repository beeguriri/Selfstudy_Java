package Java_Programmers.Level0;

public class 문자열안에문자열 {
	
	/* 문자열 str1, str2가 매개변수로 주어집니다. 
	 * str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.
	 * */

    public int solution(String str1, String str2) {
        
        if(str1.contains(str2))	return 1;
        else return 2;
        
    }
	
	public static void main(String[] args) {
		
		문자열안에문자열 a = new 문자열안에문자열();

		String s1 = "ab6CDE443fgh22iJKlmn1o";
		String s2 = "6CD";	
		System.out.println(a.solution(s1, s2)); //1
		//System.out.println(s1.contains(s2));
		
		String s3 = "ppprrrogrammers";
		String s4 = "pppp"; 	
		System.out.println(a.solution(s3, s4));//2
		
		String s5 = "AbcAbcA";
		String s6 = "AAA";	
		System.out.println(a.solution(s5, s6)); //2
	}

}
