package Java_Programmers.Level0;

import java.util.Arrays;

public class _7의개수 {
	
	/* 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 
	 * 정수 배열 array가 매개변수로 주어질 때, 
	 * 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.
	 * 7이 없으면 rerutn 0;
	 */
	
    public int solution(int[] array) {
        int answer = 0;

        String str = "";
        
        for(int i=0; i<array.length; i++)
        	str += String.valueOf(array[i]);
        
        for(int i=0; i<str.length(); i++) 
        	if(str.charAt(i)=='7') answer++;
        
        return answer;
    }

	public static void main(String[] args) {

		_7의개수 a = new _7의개수();
		
		int [] arr1 = {7, 77, 17};
		System.out.println(a.solution(arr1));//4
		
		int [] arr2 = {10, 29};
		System.out.println(a.solution(arr2));//0
		
	}

}
