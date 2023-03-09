package Java_Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 특이한정렬 {
	
	/* 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다. 
	 * 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다. 
	 * 정수가 담긴 배열 numlist와 정수 n이 주어질 때 
	 * numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 
	 * solution 함수를 완성해주세요.
	 * numlist는 중복된 원소를 갖지 않습니다.
	 * */
	
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int [numlist.length];
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (int i : numlist) 
        	temp.add(i);
        
        
        temp.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				int abs1 = Math.abs(o1-n);
				int abs2 = Math.abs(o2-n);
				
				//내림차순정렬할것
				//절대값이 같으면 큰수를 넣어줌
				if(abs1 == abs2) {
					if(o1 > o2) return -1;
					else return 1;
				} else return abs1 - abs2;

			}
		});
        
        for (int i=0; i<temp.size(); i++) 
        	answer[i] = temp.get(i);

        return answer;
    }
    
	public static void main(String[] args) {

		특이한정렬 a = new 특이한정렬();
		
		int [] n1 = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(a.solution(n1, 4))); //[4, 5, 3, 6, 2, 1]
		
		int [] n2 = {10000,20,36,47,40,6,10,7000};
		System.out.println(Arrays.toString(a.solution(n2, 30)));
		
	}

}
