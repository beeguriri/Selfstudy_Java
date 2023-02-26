package Java_Programmers.Level0;

public class 문자반복출력하기 {

	/* 문자열 my_string과 정수 n이 매개변수로 주어질 때, 
	 * my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 
	 * solution 함수를 완성해보세요.
	 * 제한사항 : 
	 * 2 ≤ my_string 길이 ≤ 5
	 * 2 ≤ n ≤ 10
	 * "my_string"은 영어 대소문자로 이루어져 있습니다.
	 * */
	
	static String solution(String my_string, int n) {
        
		String answer = "";
        
        for(int i=0; i<my_string.length(); i++) {
        	for(int j=0; j<n; j++) {
        		
        		answer += my_string.charAt(i);
        	}
        }
        return answer;
    }
	
	
	public static void main(String[] args) {

		String ex1 = "hello";
		System.out.println(solution(ex1, 3));
		
	}

}
