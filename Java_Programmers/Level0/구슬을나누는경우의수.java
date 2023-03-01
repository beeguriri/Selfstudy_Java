package Java_Programmers.Level0;

import java.math.BigInteger;

public class 구슬을나누는경우의수 {
	
	/* 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 
	 * 구슬은 모두 다르게 생겼습니다. 
	 * 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, 
	 * balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 
	 * return 하는 solution 함수를 완성해주세요.
	 * 제한사항 : 
	 * 1 ≤ balls ≤ 30
	 * 1 ≤ share ≤ 30
	 * 구슬을 고르는 순서는 고려하지 않습니다.
	 * share ≤ balls
	 * 서로 다른 n개 중 r개를 뽑는 경우의 수 nCr = n! / (n-r)!r! 
	 * */
	
	
	//몇가지 케이스에서 에러 뜨는 이유 : int/long 사이즈 넘어가서..
	static long factorial(int n) {
		
		if(n>0)		return n * factorial(n-1);
		else		return 1;
	}
	
	static long solution(int balls, int share) {
		 
	        long answer = 0;
	        
	        answer = factorial(balls) / (factorial(balls-share) * factorial(share));	        
	        
	        return answer;
    }

	//런타임 에러
	static BigInteger solution1(int balls, int share) {
		 
		 BigInteger n = BigInteger.valueOf(balls);
		 BigInteger m = BigInteger.valueOf(share);
		 BigInteger n_m = BigInteger.valueOf(balls-share);
		 
		 for(int i = balls; i>1; i--) 
			 n = n.multiply(BigInteger.valueOf(i-1));
		 
		 for(int i = share; i>1; i--)
			 m = m.multiply(BigInteger.valueOf(i-1));
		 
		 for(int i = balls-share; i>1; i--)
			 n_m = n_m.multiply(BigInteger.valueOf(i-1));
		 		 
		 return n.divide(m).divide(n_m);
	 }
	
	//★통과★
	static BigInteger solution2(int balls, int share) {
		 
		 BigInteger n = BigInteger.ONE;
		 BigInteger m = BigInteger.ONE;
		 BigInteger nm = BigInteger.ONE;

		 for(int i = 1; i<=balls; i++) 
			n = n.multiply(BigInteger.valueOf(i));
		 
		 for(int i = 1; i<=share; i++)
			m = m.multiply(BigInteger.valueOf(i));

		 for(int i = 1; i<=balls-share; i++)
			 nm = nm.multiply(BigInteger.valueOf(i));
		 
		 return n.divide(m).divide(nm);
	 }
	
	public static void main(String[] args) {

		//System.out.println(factorial(3));
		System.out.println(solution(3,2));	//3
		System.out.println(solution(5,3));	//10
		
		System.out.println(solution1(3,2));
		System.out.println(solution1(5,3));
		
		System.out.println(solution2(3,2));
		System.out.println(solution2(5,3));

	}

}
