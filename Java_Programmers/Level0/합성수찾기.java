package Java_Programmers.Level0;

public class 합성수찾기 {
	
	/* 약수의 개수가 세 개 이상인 수를 합성수라고 합니다. 
	 * 자연수 n이 매개변수로 주어질 때 
	 * n이하의 합성수의 개수를 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 : 1 ≤ n ≤ 100
	 * */

	public int solution(int n) {
		
        int answer = 0;
        int count = 0;
        
        if(n<=3) answer = 0;
        else {
        	
            for (int i =4; i<=n; i++) {
            	for(int j=1; j<=i; j++) {
                	if(i%j==0) count++;
            	}
            if(count>=3)	answer++;
            count=0;
            }
        }

        return answer;
    }

	public static void main(String[] args) {

		합성수찾기 a = new 합성수찾기();
		
		System.out.println(a.solution(10));	//5
		
		System.out.println(a.solution(15)); //8

	}

}
