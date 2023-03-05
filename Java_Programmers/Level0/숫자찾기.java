package Java_Programmers.Level0;

public class 숫자찾기 {

	/* 정수 num과 k가 매개변수로 주어질 때, 
	 * num을 이루는 숫자 중에 k가 있으면 
	 * num의 그 숫자가 있는 자리 수를 return하고 
	 * 없으면 -1을 return 하도록 solution 함수를 완성해보세요.
	 * */
	
    public int solution(int num, int k) {
        int answer = 0;
        
        String [] arr = String.valueOf(num).split("");
        String k1 = String.valueOf(k);
        
        for(int i = 0; i<arr.length; i++) {
        	
        	if(arr[i].equals(k1))	{
        		answer = i+1;
        		break;
        	}
        	else answer = -1;
        }
        
        
        return answer;
    }
    
    //다른사람 풀이
    public int solution1(int num, int k) {
        return ("0" + num).indexOf(String.valueOf(k));	//인덱스1부터 반환하게
    }
    
	public static void main(String[] args) {

		숫자찾기 a = new 숫자찾기();
		
		System.out.println(a.solution(29183, 1)); //3
		System.out.println(a.solution1(29183, 1)); //3

		System.out.println(a.solution(232443, 4)); //4
		System.out.println(a.solution1(232443, 4)); //4

		System.out.println(a.solution(123456, 7));	//-1
		System.out.println(a.solution1(123456, 7));	//-1

	}

}
