package Java_Programmers.Level0;

import java.util.Arrays;

public class 잘라서배열로저장하기 {
	
	/* 문자열 my_str과 n이 매개변수로 주어질 때, 
	 * my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.
	 * */
	
    public String[] solution(String my_str, int n) {
        
        double len = Math.ceil((double)my_str.length()/n);
        String[] answer = new String[(int) len];
 
        for(int i=0, j=0; i<len && j < my_str.length(); i++, j=j+n) {
        	
        	if(my_str.length()%n==0) 
        		answer[i] = my_str.substring(j, j+n); 
        	else {
        		if(i<len-1) 
            		answer[i] = my_str.substring(j, j+n);
        		
        		else 
        			answer[i] = my_str.substring(j);	
        	}        	
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		잘라서배열로저장하기 a = new 잘라서배열로저장하기();
		
		System.out.println(Arrays.toString(a.solution("abc1Addfggg4556b", 6))); //["abc1Ad", "dfggg4", "556b"]
		
		System.out.println(Arrays.toString(a.solution("abcdef123", 3)));//["abc", "def", "123"]
	}

}
