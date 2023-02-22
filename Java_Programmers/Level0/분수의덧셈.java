package Java_Programmers.Level0;

public class 분수의덧셈 {

	/*
		첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 
		두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다. 
		두 분수를 더한 값을 기약 분수로 나타냈을 때 
		분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
	 */
	
	static int[] solution(int numer1, int denom1, int numer2, int denom2) {
	        
	        int[] answer = new int [2];

	        int denom = denom1 * denom2; //분모
            int numer = numer1 * denom2 + numer2 * denom1; //분자
            
            //최대공약수 메서드 호출
            int result = gcd(denom, numer);
            
            //최대공약수로 분자 분모 나눠주기
            denom = denom/result;
            numer = numer/result;
            
            answer[0] = numer;
            answer[1] = denom;
	        
	        return answer;
	    }
	
	//최대공약수 구하기
    static int gcd(int x, int y) {
    	    	
        if (y == 0)       return x;
        else              return gcd(y, x % y);
    }
	
	public static void main(String[] args) {

		int [] ans1 = solution(1,2,3,4);
		System.out.println(ans1[0] + ", " + ans1[1]);
	
		int [] ans2 = solution(9,2,1,3);
		System.out.println(ans2[0] + ", " + ans2[1]);
		
		int [] ans3 = solution(9,4,1,4);
		System.out.println(ans3[0] + ", " + ans3[1]);


	}

}
