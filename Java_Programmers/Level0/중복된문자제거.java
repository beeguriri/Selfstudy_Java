package Java_Programmers.Level0;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class 중복된문자제거 {

	/* 문자열 my_string이 매개변수로 주어집니다. 
	 * my_string에서 중복된 문자를 제거하고 
	 * 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 : 
	 * 공백(" ")도 하나의 문자로 구분합니다.
	 * 중복된 문자 중 가장 앞에 있는 문자를 남깁니다.
	 * */
	
    public String solution(String my_string) {
    	
		String [] str_arr = my_string.split("");
        String answer = "";
        
		for(int i = 0; i<str_arr.length; i++) {
			
			for(int j=0; j<i; j++) {
				
				if(str_arr[i].equals(str_arr[j])) {
					str_arr[i]="";
					break;	
				}
			}
			answer += str_arr[i];
		}
        
        return answer;
    }
    
    // 다른사람 풀이
    public String solution1(String my_string) {
    	
        String[] answer = my_string.split("");
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(answer));

        return String.join("", set);
    }
	
	public static void main(String[] args) {

		중복된문자제거 a = new 중복된문자제거();
		
		String str1 = "people";
//		System.out.println(a.solution(str1));		//"peol"
		System.out.println(a.solution1(str1));		//"peol"

		
		String str2 = "We are the world";
//		System.out.println(a.solution(str2));		//"We arthwold"
		System.out.println(a.solution1(str2));		//"We arthwold"

				
	}

}
