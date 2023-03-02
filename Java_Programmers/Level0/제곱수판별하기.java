package Java_Programmers.Level0;

public class 제곱수판별하기 {
	
	/* 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다. 
	 * 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 
	 * solution 함수를 완성해주세요.
	 * 제한사항 : 1 ≤ n ≤ 1,000,000
	 * */
	
    public int solution(int n) {
        int answer = 1;
        
		for (int i = 1; i<=1000; i++) {
			if(n==i*i)	{
				answer = 1;
				break;
			}
			else 			answer = 2;
		}	
        return answer;
    }

	public static void main(String[] args) {
		
		제곱수판별하기 a = new 제곱수판별하기();
		
		System.out.println(a.solution(144));	//1
		System.out.println(a.solution(976));	//2

	}

}
