package Java_Programmers.Level0;

import java.util.Arrays;

public class 가장큰수찾기 {
	
	/* 정수 배열 array가 매개변수로 주어질 때, 
	 * 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
	 * */

    public int[] solution(int[] array) {
        int[] answer = new int [2];
        
        for(int i =0; i<array.length-1; i++) {
        	answer[0] = Math.max(array[i], array[i+1]);
        }
        
        answer[1] = Arrays.binarySearch(array, answer[0]);
        		
        return answer;
    }
	
	public static void main(String[] args) {

		가장큰수찾기 a = new 가장큰수찾기();
		
		int [] arr1 = {1, 8, 3};
		System.out.println(Arrays.toString(a.solution(arr1))); //[8, 1]
		
		int [] arr2 = {9, 10, 11, 8};
		System.out.println(Arrays.toString(a.solution(arr2))); //[11, 2]
		
	}

}
