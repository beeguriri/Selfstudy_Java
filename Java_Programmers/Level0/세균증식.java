package Java_Programmers.Level0;

public class 세균증식 {

	/* 어떤 세균은 1시간에 두배만큼 증식한다고 합니다. 
	 * 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 
	 * t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 : 
	 * 1 ≤ n ≤ 10
	 * 1 ≤ t ≤ 15
	 * */
	
    public int solution(int n, int t) {
        int answer = 1;
        int cnt = 0;
        
        while(cnt<t) {
        	
        	answer *= 2;
        	cnt++;
 
        }
        
//        answer = (int)Math.pow(2,t)*n;

        
        return answer;
    }
    
	public static void main(String[] args) {

		세균증식 a = new 세균증식();
		
		System.out.println(a.solution(2, 10));	//2048
		System.out.println(a.solution(7, 15));	//229,376
	}

}
