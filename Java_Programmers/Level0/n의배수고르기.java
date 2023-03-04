package Java_Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;

public class n의배수고르기 {

	/* 정수 n과 정수 배열 numlist가 매개변수로 주어질 때, 
	 * numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 
	 * solution 함수를 완성해주세요.
	 * */
	
    public int[] solution(int n, int[] numlist) {
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (int i=0; i<numlist.length; i++) 
        	if(numlist[i]%n==0)	temp.add(numlist[i]);
        	
        return temp.stream().mapToInt(i -> i).toArray();
    }
	
	public static void main(String[] args) {

		n의배수고르기 a = new n의배수고르기();
		
		int [] list1 = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		System.out.println(Arrays.toString(a.solution(3, list1))); //[6, 9, 12]
		
		int [] list2 = {1, 9, 3, 10, 13, 5};
		System.out.println(Arrays.toString(a.solution(5, list2))); //[10, 5]

		int[] list3 = {2, 100, 120, 600, 12, 12};
		System.out.println(Arrays.toString(a.solution(12, list3))); //[120, 600, 12, 12]
	}

}
