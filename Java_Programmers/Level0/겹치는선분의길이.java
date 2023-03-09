package Java_Programmers.Level0;


public class 겹치는선분의길이 {
	
	/* 선분 3개가 평행하게 놓여 있습니다. 
	 * 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 
	 * 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 
	 * 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
	 * */
	
    public int solution(int[][] lines) {
        int answer = 0;
        
        //범위가 -100 ~ 100 => 0~200으로 바꿔주려고 함
        int [] temp = new int [201];
        
        for(int i = 0; i < lines.length; i++) {
        	int a = lines[i][0] + 100;
        	int b = lines[i][1] + 100;
        	
        	while(a<b) 
        		temp[a++] += 1;
        }
        
        for (int a : temp)
        	if(a>=2) answer++;
        
        return answer;
    }

	public static void main(String[] args) {
		
		겹치는선분의길이 a = new 겹치는선분의길이();

		int [][] lines1 = {{0, 5}, {3, 9}, {1, 10}};
		System.out.println(a.solution(lines1));
		
	}
}
