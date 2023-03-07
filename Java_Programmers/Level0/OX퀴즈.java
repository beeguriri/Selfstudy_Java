package Java_Programmers.Level0;

import java.util.Arrays;

public class OX퀴즈 {

	/* 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다. 
	 * 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.
	 * */
    public String[] solution(String[] quiz) {
        
    	String[] answer = new String[quiz.length];
            	
    	for (int i = 0; i<quiz.length; i++) {
        
    		String [] temp = quiz[i].split(" ");
    		int n1 = Integer.parseInt(temp[0]);
    		int n2 = Integer.parseInt(temp[2]);
    		
    		if(temp[1].equals("+")) {
    			
    			if(n1 + n2 == Integer.parseInt(temp[4]))
        			answer[i] = "O";
        		else answer[i] = "X";
    		} else {
    			
    			if(n1 - n2 == Integer.parseInt(temp[4]))
        			answer[i] = "O";
        		else answer[i] = "X";
    		}		
        }
        
        return answer;
    }
    
    
	public static void main(String[] args) {

		OX퀴즈 a = new OX퀴즈();
		
		String [] quiz1 = {"3 - 4 = -3", "5 + 6 = 11"};
		System.out.println(Arrays.toString(a.solution(quiz1)));
		
		String [] quiz2 = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
		System.out.println(Arrays.toString(a.solution(quiz2)));

	}

}
