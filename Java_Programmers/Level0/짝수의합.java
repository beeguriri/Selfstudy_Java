package Java_Programmers.Level0;

public class 짝수의합 {

	/* 정수 n이 주어질 때, 
	 * n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.
	 * 제한사항 : 0 < n ≤ 1000
	 * */
	
	static int solution(int n) {
        int answer = 0;
        
        for(int i = 0; i <= n; i=i+2) {
        	answer += i;
        }
        return answer;
    }
	
	public static void main(String[] args) {

		int ex1 = 10; //결과 30
		int ans1 = solution(ex1);
		System.out.println("ans1: "+ ans1);
		
	}

}
