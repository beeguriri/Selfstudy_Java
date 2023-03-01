package Java_Programmers.Level0;

public class 점의위치구하기 {

	
	/* 사분면은 한 평면을 x축과 y축을 기준으로 나눈 네 부분입니다. 
	 * 사분면은 아래와 같이 1부터 4까지 번호를매깁니다.
	 * x 좌표와 y 좌표가 모두 양수이면 제1사분면에 속합니다.
	 * x 좌표가 음수, y 좌표가 양수이면 제2사분면에 속합니다.
	 * x 좌표와 y 좌표가 모두 음수이면 제3사분면에 속합니다.
	 * x 좌표가 양수, y 좌표가 음수이면 제4사분면에 속합니다.
	 * dot[0]은 x좌표를, dot[1]은 y좌표를 나타냅니다
	 * */
	
    static int solution(int[] dot) {
        int answer = 0;
        
        if(dot[0]>0 && dot[1]>0)	answer = 1;
        else if(dot[0]<0 && dot[1]>0)	answer = 2;
        else if(dot[0]<0 && dot[1]<0)	answer = 3;
        else if(dot[0]>0 && dot[1]<0)	answer = 4;
        	
    	return answer;
    }
    
	public static void main(String[] args) {

		int [] a = {2,4};
		System.out.println(solution(a));
		
		int [] b = {-7, 9};
		System.out.println(solution(b));
		
	}

}
