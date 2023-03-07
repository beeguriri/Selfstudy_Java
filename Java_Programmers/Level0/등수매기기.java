package Java_Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 등수매기기 {
	
	/* 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다. 
	 * 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때, 
	 * 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 
	 * solution 함수를 완성해주세요.
	 * */
	
    public int[] solution(int[][] score) {
        int[] answer = new int [score.length];
        
        ArrayList<Integer> sum_list = new ArrayList<>();
        
        for(int i=0; i<score.length; i++)
        	sum_list.add(score[i][0] + score[i][1]);
        
        sum_list.sort(Comparator.reverseOrder());
        
        for(int i=0; i<score.length; i++)
            answer[i] = sum_list.indexOf(score[i][0] + score[i][1])+1;
        
        return answer;
    }
    
	public static void main(String[] args) {

		등수매기기 a = new 등수매기기();
		
		int [][] score1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
		System.out.println(Arrays.toString(a.solution(score1))); 
		//[1, 2, 4, 3]
		
		int [][] score2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90},{100, 100}, {10, 30}};
		System.out.println(Arrays.toString(a.solution(score2))); 
		//[4, 4, 6, 2, 2, 1, 7]
		
		int [][] score3 = {{1,1}, {2,1}, {3,1}, {4,1}, {5,1}, {6,1}, {7,1}, {8,1}, {9,1}, {0,0}};
		System.out.println(Arrays.toString(a.solution(score3)));
		//[9,8,7,6,5,4,3,2,1,10]

	}

}
