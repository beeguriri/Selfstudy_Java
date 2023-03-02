package Java_Programmers.Level0;

public class 자릿수더하기 {
	
	/* 정수 n이 매개변수로 주어질 때 
	 * n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
	 * 제한사항 : 0 ≤ n ≤ 1,000,000
	 * */
	
    public int solution(int n) {
        int answer = 0;
        
        String s = String.valueOf(n);
        
        for (int i = 0; i<s.length(); i++) 
        	answer += Character.getNumericValue(Integer.valueOf(s.charAt(i)));
        
        
        return answer;
    }
    
    public int solution2(int n) {
        int answer = 0;
        
        String [] s = String.valueOf(n).split("");
        
        for (int i = 0; i<s.length; i++) 
        	answer += Integer.parseInt(s[i]);
        
        return answer;
    }

	public static void main(String[] args) {

		자릿수더하기 a = new 자릿수더하기();
		
		int n1 = 1234;
		System.out.println(a.solution(n1)); //10
		
		int n2 = 930211;
		System.out.println(a.solution(n2)); //16
		
//		String s1 = String.valueOf(n1);
//		System.out.println(s1.charAt(0));
		
		자릿수더하기 b = new 자릿수더하기();
		
		System.out.println(b.solution2(n1)); //10
		
		System.out.println(b.solution2(n2)); //16

	}

}
