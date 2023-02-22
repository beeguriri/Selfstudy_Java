package Java_Programmers.Level0;

public class 짝수는싫어요 {

	/* 문제
	 * 정수 n이 매개변수로 주어질 때, 
	 * n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.*/
	
	static int [] solution (int n) {
		
		int size =0;
		
		if (n%2==0) 	size = n/2;
		else			size = n/2 + 1;
		
		int [] ans = new int [size];
		
		for(int i=0; i<ans.length; i++)
			ans[i] = 2*i + 1;
		
		return ans;
	}
	
	
	public static void main(String[] args) {

		int n1 = 3;
		int ans1 [] = solution(n1);
		for(int i=0; i < ans1.length; i++) System.out.print(ans1[i] + " ");
		
		System.out.println();
		
		int n2 = 7;
		int ans2 [] = solution(n2);
		for(int i=0; i < ans2.length; i++) System.out.print(ans2[i] + " ");
		
	}

}
