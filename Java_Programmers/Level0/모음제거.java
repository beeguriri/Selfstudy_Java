package Java_Programmers.Level0;

public class 모음제거 {
	
	/* 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 
	 * 문자열 my_string이 매개변수로 주어질 때 
	 * 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
	 * */
	
    public String solution(String my_string) {
        return my_string.replaceAll("[aeiou]","");
    }

	public static void main(String[] args) {

		모음제거 a = new 모음제거();
	
		String s1 = "bus";	
		System.out.println(a.solution(s1)); //"bs"
		
		String s2 = "nice to meet you";	
		System.out.println(a.solution(s2)); //"nc t mt y"
	}

}
