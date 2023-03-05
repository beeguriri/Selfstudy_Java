package Java_Programmers.Level0;

import java.util.Arrays;

public class 가까운수 {

	/* 정수 배열 array와 정수 n이 매개변수로 주어질 때, 
	 * array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 
	 * solution 함수를 완성해주세요.
	 * 제한사항 : 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
	 * */    
	
	public int solution(int [] array, int n) {
			
		Arrays.sort(array);
		
		for(int i = 0; i<array.length; i++) {
			
			//n이 앞뒤로 비교할 위치를 찾고
			if(array[i] <= n) continue;
			else {	
				
				if(i==0)	return array[i];
				else {	
					if(Math.abs(array[i-1]-n) <= Math.abs(array[i]-n))	
						return array[i-1];
					else	return array[i];
				}
			}
		}
		
		//for문에 들어오지못하면 배열의 제일 마지막값 리턴
		return array[array.length-1];
	}
	
	public static void main(String[] args) {

		가까운수 a = new 가까운수();
		
		int [] arr1 = {3, 10, 28};
		System.out.println(a.solution(arr1, 20));	//28
		
		int [] arr2 = {10, 11, 12};
		System.out.println(a.solution(arr2, 13));	//12
		
		int [] arr3 = {4, 29, 2, 39, 18};
		System.out.println(a.solution(arr3, 20));	//18
		
		int [] arr4 = {2, 2, 3};
		System.out.println(a.solution(arr4, 1));	//1
		
		int [] arr5 = {12, 3, 4, 10, 13};
		System.out.println(a.solution(arr5, 11));
		}

}
