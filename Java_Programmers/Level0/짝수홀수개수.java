package Java_Programmers.Level0;

public class 짝수홀수개수 {

	
	/* 정수가 담긴 리스트 num_list가 주어질 때, 
	 * num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 
	 * solution 함수를 완성해보세요.
	 * 제한사항 : 
	 * 1 ≤ num_list의 길이 ≤ 100
	 * 0 ≤ num_list의 원소 ≤ 1,000
	 * 
	 * [1, 2, 3, 4, 5]	[2, 3] [짝수, 홀수]
		[1, 3, 5, 7]	[0, 4]
	 * */
	
	static int[] solution(int[] num_list) {

		int[] answer = new int [2];
		int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0; i<num_list.length; i++) {
        	
        	if (num_list[i] % 2 == 0)	++cnt1;
        	else	++cnt2;
        }
        
//        System.out.println("cnt1: " + cnt1);
//		System.out.println("cnt2: " + cnt2);
        
        answer[0] = cnt1;
        answer[1] = cnt2;
    
        return answer;
    }
	
	public static void main(String[] args) {

		int [] ex1 = {1, 2, 3, 4, 5};
		int[] ans1 = new int [2];
		ans1 = solution(ex1);
		System.out.println(ans1[0] + ", " + ans1[1]);

		
		int [] ex2 = {1, 3, 5, 7};
		int[] ans2 = new int [2];
		ans2 = solution(ex2);
		System.out.println(ans2[0] + ", " + ans2[1]);
		
//        int cnt1 = 0;
//        int cnt2 = 0;
//
//		for(int i = 0; i<ex1.length; i++) {
//			if (ex1[i] %2 == 0)	
//				System.out.println("짝수: " + ++cnt1);
//			else System.out.println("홀수: " + ++cnt2);
//		}
//		
//		System.out.println("cnt1: " + cnt1);
//		System.out.println("cnt2: " + cnt2);
//		
//		answer[0] = cnt1;
//		answer[1] = cnt2;
//		
//		System.out.println(answer[0] + ", " + answer[1]);
		

		
	}

}
