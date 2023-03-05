package Java_Programmers.Level0;

public class 문자열계산하기 {

	/* my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 
	 * 문자열 my_string이 매개변수로 주어질 때, 
	 * 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.
	 * 제한사항:
	 * 연산자는 +, -만 존재합니다.
	 * 계산에 사용하는 숫자는 1 이상 20,000 이하인 자연수입니다.
	 * my_string의 숫자와 연산자는 공백 하나로 구분되어 있습니다.
	 * */
	
    public int solution(String my_string) {
        
        String [] arr = my_string.split(" ");
        
        int answer = Integer.parseInt(arr[0]);
        
        for (int i =1 ; i<arr.length; i++) {

        	if(i%2!=0) {
        		
        		if(arr[i].equals("+"))
        			answer += Integer.parseInt(arr[i+1]);
        		else
        			answer -= Integer.parseInt(arr[i+1]);
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {

		문자열계산하기 a = new 문자열계산하기();
		
		System.out.println(a.solution("3 + 4"));
		System.out.println(a.solution("60 + 4 - 25 - 24"));

	}

}
