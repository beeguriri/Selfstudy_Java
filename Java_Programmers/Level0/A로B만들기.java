package Java_Programmers.Level0;

import java.util.Arrays;

public class A로B만들기 {

	/* 문자열 before와 after가 매개변수로 주어질 때, 
	 * before의 순서를 바꾸어 after를 만들 수 있으면 1을, 
	 * 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
	 * 제한사항 : 0 < before의 길이 == after의 길이 < 1,000
	 * */
	
    public int solution(String before, String after) {

        String [] b = before.split("");
        String [] a = after.split("");
        
        Arrays.sort(b);
        Arrays.sort(a);
        
        if(Arrays.equals(b, a))		return 1;
        else return 0;
        
    }
    
	public static void main(String[] args) {
		
		A로B만들기 a = new A로B만들기();
		
		System.out.println(a.solution("olleh", "hello"));	//1
		System.out.println(a.solution("allpe", "apple"));	//0
	}

}
