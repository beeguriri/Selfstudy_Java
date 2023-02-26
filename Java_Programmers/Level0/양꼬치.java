package Java_Programmers.Level0;

public class 양꼬치 {
	
	/* 머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다. 
	 * 양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다. 
	 * 정수 n과 k가 매개변수로 주어졌을 때, 양꼬치 n인분과 음료수 k개를 먹었다면 
	 * 총얼마를 지불해야 하는지 return 하도록 solution 함수를 완성해보세요.
	 * 제한사항 : 
	 * 0 < n < 1,000
	 * n / 10 ≤ k < 1,000
	 * 서비스로 받은 음료수는 모두 마십니다.
	 * */
	
	static int solution(int n, int k) {

		int answer = 0;
        
        if(n>=10) 
        	answer = 12000*n + 2000 * (k- (n/10));
        else answer = 12000 * n + 2000 * k;
  
        return answer;
    }

	public static void main(String[] args) {

		int ans1 = solution(10,3);
		System.out.println("ans1 :" + ans1 );	//124,000
		
		int ans2 = solution(64,6);
		System.out.println("ans2 :" + ans2 );	//768,000
		
	}

}
