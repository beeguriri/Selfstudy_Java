package Java_Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;

public class 약수구하기 {
	
	/* 정수 n이 매개변수로 주어질 때, 
	 * n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
	 * */
	
    public int[] solution(int n) {
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i = 1; i<=n; i++) 
        	if(n%i==0)	temp.add(i);
        
        return temp.stream().mapToInt(i -> i).toArray();
    }
    
	public static void main(String[] args) {
		
		약수구하기 a = new 약수구하기();
		
		System.out.println(Arrays.toString(a.solution(24))); //[1, 2, 3, 4, 6, 8, 12, 24]
		
		System.out.println(Arrays.toString(a.solution(29))); //[1, 29]


	}

}
