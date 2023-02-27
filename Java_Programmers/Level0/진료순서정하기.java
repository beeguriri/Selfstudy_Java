package Java_Programmers.Level0;

import java.util.Arrays;

public class 진료순서정하기 {
	
	/* 외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다. 
	 * 정수 배열 emergency가 매개변수로 주어질 때 
	 * 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 : 
	 * 중복된 원소는 없습니다.
	 * 1 ≤ emergency의 길이 ≤ 10
	 * 1 ≤ emergency의 원소 ≤ 100	
	 * */
	
	static int[] solution(int[] emergency) {
        
		int [] answer = new int [emergency.length];
		int [] temp = new int [emergency.length];
        
        for (int i=0; i<answer.length; i++) 
        	temp[i] = emergency[i];	//3,76,24
        
        Arrays.sort(temp);	// 3, 24, 76
        
        for (int i=0; i<answer.length; i++) {
        	for (int j=0; j<answer.length; j++) {
        		
        		if(emergency[i]==temp[j]) {
        			answer[i] = answer.length - j;
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {

		int[] e1 = {3, 76, 24};
		int[] res1 = solution(e1);
		System.out.println("res1 : " + Arrays.toString(res1)); //[3, 1, 2]
		
		int[] e2 = {1, 2, 3, 4, 5, 6, 7};
		int[] res2 = solution(e2);
		System.out.println("res2 : " + Arrays.toString(res2)); //[7, 6, 5, 4, 3, 2, 1]

		int[] e3 = {30, 10, 23, 6, 100};
		int[] res3 = solution(e3);
		System.out.println("res3 : " + Arrays.toString(res3)); //[2, 4, 3, 5, 1]
	}

}
