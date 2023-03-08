package Java_Programmers.Level0;

public class 문자열밀기 {
	
	/* 문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다. 
	 * 이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때, 
	 * A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 
	 * 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
	 * 밀지않아도 되면 return 0
	 * 제한사항 : 0 < A의 길이 = B의 길이 < 100
	 * */
    public int solution(String A, String B) {
        int answer = 0;
        String tempA = A;
        
        for(int i = 0; i<A.length(); i++) {
        	
        	if(tempA.equals(B)) 
        		return answer;

        	tempA = tempA.substring(A.length()-1) 
        			+ tempA.substring(0, A.length()-1);
        	answer++;
        }
        

        return -1;
    }
    
	public static void main(String[] args) {
		문자열밀기 a = new 문자열밀기();
		
		System.out.println(a.solution("hello", "ohell"));	//1
		System.out.println(a.solution("apple", "elppa"));	//-1
		System.out.println(a.solution("atat", "tata"));	//1
		System.out.println(a.solution("abc", "abc"));	//0

	}

}
