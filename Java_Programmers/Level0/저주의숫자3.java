package Java_Programmers.Level0;

import java.util.ArrayList;

public class 저주의숫자3 {
	
	/* 3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 
	 * 3의 배수와 숫자 3을 사용하지 않습니다. 
	 * 3x 마을 사람들의 숫자는 다음과 같습니다.
	 * 10진법	 3x   10진법	3x
		1	1		6	8
		2	2		7	10
		3	4		8	11
		4	5		9	14
		5	7		10	16
		정수 n이 매개변수로 주어질 때, 
		n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.
	 * */
	
    public int solution(int n) {
        int answer = 1;
        
        ArrayList<Integer> temp = new ArrayList<>();
        
		while(temp.size() < n) {
		
			temp.add(answer++);
			
				if(temp.get(temp.size()-1) %3==0 || String.valueOf(temp.get(temp.size()-1)).contains("3")) {
					temp.remove(temp.size()-1);
				}
			}
		
        return temp.get(temp.size()-1);
    }
    
    //다른사람 풀이
    public int solution1(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }

        return answer;
    }

	public static void main(String[] args) {

		저주의숫자3 a = new 저주의숫자3();
		//15	25
		//40	76
		
		System.out.println(a.solution1(15));	//25
		System.out.println(a.solution1(40));	//76
	}

}
