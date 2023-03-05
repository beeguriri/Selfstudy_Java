package Java_Programmers.Level0;

import java.util.ArrayList;

public class 이진수더하기 {
	
	/* 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때, 
	 * 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.
	 * */

    public String solution(String bin1, String bin2) {
        String answer = "";
        
        String [] b1 = bin1.split("");
        String [] b2 = bin2.split("");

        int dif = b1.length - b2.length;
        
        //b2의 자릿수가 더 많으면 b2를 b1으로 바꿔줌
        if(dif < 0) {
        	String [] temp = b2;
        	b2 = b1;
        	b1 = temp;
        }
        
        int [] temp1 = new int [b1.length];
        int [] temp2 = new int [b2.length];
        
        //배열 역순 저장
        for (int i =0; i<b1.length; i++) 	
        	temp1[i] = Integer.parseInt(b1[b1.length-i-1]);
        	
        for (int i =0; i<b2.length; i++)
        	temp2[i] = Integer.parseInt(b2[b2.length-i-1]);
        
        ArrayList<Integer> list1 = new ArrayList<>();
        
        //계산
        int olrim = 0;
        
        //작은 배열의 자릿수만큼 더해준 후
        for(int i =0; i<temp2.length; i++) {
        	
        	int sum = temp1[i] + temp2[i] + olrim;
        	list1.add(sum%2);
        	
        	if(sum>=2) olrim=1;
        	else olrim=0;	
        }
        
        //남은배열의 자릿수는 그대로 내려줌
    	for(int i=temp2.length; i<temp1.length; i++) {
    		
    		int sum = temp1[i] + olrim;
    		list1.add(sum%2);
    		
    		if(sum>=2) olrim=1;
    		else olrim=0;
    	}
        
        //마지막자릿수 늘려줌
        if (olrim==1)	list1.add(olrim);
        
        //역순으로 출력
        for (int i = list1.size()-1; i>=0; i--)
        	answer += String.valueOf(list1.get(i));
        
        return answer;
    }
    
    //와우...
    public String solution1(String bin1, String bin2) {        
        return Integer.toBinaryString(Integer.parseInt(bin1, 2)+Integer.parseInt(bin2,2));
    }
	
	public static void main(String[] args) {

		이진수더하기 a = new 이진수더하기();
		
		System.out.println(a.solution("10", "11"));	//101
		System.out.println(a.solution1("10", "11"));	//101
		
		System.out.println(a.solution("1001", "1111"));	//11000
		System.out.println(a.solution1("1001", "1111"));	//11000

		System.out.println(a.solution("0", "0"));	//0
		System.out.println(a.solution1("0", "0"));	//0

		System.out.println(a.solution("1111111111", "1111111111"));	//11111111110
		System.out.println(a.solution1("1111111111", "1111111111"));	//11111111110

		System.out.println(a.solution("100001", "1010101"));
		System.out.println(a.solution1("100001", "1010101"));


	}

}
