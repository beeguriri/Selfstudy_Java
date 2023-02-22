package Java_Programmers.Level0;

public class 배열두배만들기 {
	
	/*
	 	정수 배열 numbers가 매개변수로 주어집니다. 
	 	numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.
	 */

	static int[] solution(int[] numbers) {
        int[] answer = new int [numbers.length];
        
        for(int i=0; i<answer.length; i++) 
        		answer[i] = 2*numbers[i];
        
        return answer;
    }
	
	public static void main(String[] args) {

		int [] numbers1 = {1,2,3,4,5};
		int [] ans1 = solution(numbers1);
		
		System.out.print("ans1 : ");
		for(int i = 0; i<numbers1.length; i++)
			System.out.print(ans1[i] + " ");
		
		System.out.println();
		
		int [] numbers2 = {1, 2, 100, -99, 1, 2, 3};
		int [] ans2 = solution(numbers2);
		System.out.print("ans2 : ");
		for(int i = 0; i<numbers2.length; i++)
			System.out.print(ans2[i] + " ");

	}

}
