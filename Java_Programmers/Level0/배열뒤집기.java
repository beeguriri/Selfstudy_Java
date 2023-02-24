package Java_Programmers.Level0;

public class 배열뒤집기 {
	
	/* 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다. 
	 * num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 :
	 * 1 ≤ num_list의 길이 ≤ 1,000
	 * 0 ≤ num_list의 원소 ≤ 1,000
	 * */

	static int[] solution(int[] num_list) {
		
        int[] answer = new int [num_list.length];
        
//        System.out.println("매개변수로 넘어온 배열");
//        for(int num : num_list) System.out.print(" " + num);
//        System.out.println();
        
        for(int i = 0, j=num_list.length-1; i < answer.length && j>=0;)
        	answer[i++] = num_list[j--];
        
        return answer;
    }
	
	public static void main(String[] args) {

		int[] list1 = {1, 2, 3, 4, 5};
		int [] ans1 = solution(list1);
			for(int num : ans1) System.out.print(num + " ");
		
		System.out.println();	
			
		int[] list2 = {1, 1, 1, 1, 1, 2};
		int [] ans2 = solution(list2);
			for(int num : ans2) System.out.print(num + " ");
			
		System.out.println();	
		
		int[] list3 = {1, 0, 1, 1, 1, 3, 5};
		int [] ans3 = solution(list3);
			for(int num : ans3) System.out.print(num + " ");	
	}

}
