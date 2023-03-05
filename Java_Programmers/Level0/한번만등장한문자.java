package Java_Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;


public class 한번만등장한문자 {

	
	/* 문자열 s가 매개변수로 주어집니다. 
	 * s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 
	 * solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
	 * */
	
    public String solution(String s) {
        String answer = "";
		String [] s_arr = s.split("");
		Arrays.sort(s_arr);
		
		ArrayList<String> temp = new ArrayList<>(Arrays.asList(s_arr));
		
		for (int i=0; i<s_arr.length-1; i++) {
			for(int j=i+1; j<s_arr.length; j++) {
				
				if(s_arr[i].equals(s_arr[j])) {
					temp.remove(s_arr[i]);
					temp.remove(s_arr[j]);
					break;
				}
			}
		}
		
		for (int i=0; i<temp.size(); i++) 
			answer += temp.get(i);
		
		
        return answer;
    }
    
	public static void main(String[] args) {

		한번만등장한문자 a = new 한번만등장한문자();
		
		String s1 = "abcabcadc";
		System.out.println(a.solution(s1));	//"d"
		
		String s2 = "abdc";
		System.out.println(a.solution(s2));	//"abcd"
		
		String s3 = "hello";
		System.out.println(a.solution(s3));	//"eho"
	}

}
