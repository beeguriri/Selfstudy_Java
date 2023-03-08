package Java_Programmers.Level0;

public class 평행 {
	
	/* 점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
	 * [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
	 * 주어진 네 개의 점을 두 개씩 이었을 때, 
	 * 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 
	 * solution 함수를 완성해보세요.
	 * 제한사항 : 
	 * dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
	 * 0 ≤ x, y ≤ 100
	 * */
	
    public int solution(int[][] dots) {
        
        if(Math.abs(((double)dots[1][1] - (double)dots[0][1]) 
        		/((double)dots[1][0] - (double)dots[0][0])) == 
        		Math.abs(((double)dots[2][1] - (double)dots[3][1]) 
        		/((double)dots[2][0] - (double)dots[3][0]))) 
        	return 1;
        
        else if (Math.abs(((double)dots[2][1] - (double)dots[0][1]) 
        		/((double)dots[2][0] - (double)dots[0][0])) == 
        		Math.abs(((double)dots[3][1] - (double)dots[1][1]) 
        		/((double)dots[3][0] - (double)dots[1][0])))
        	return 1;
        else if (Math.abs(((double)dots[3][1] - (double)dots[0][1]) 
        		/((double)dots[3][0] - (double)dots[0][0])) == 
        		Math.abs(((double)dots[1][1] - (double)dots[2][1]) 
        		/((double)dots[1][0] - (double)dots[2][0])))
        	return 1;
        else return 0;
    }

	public static void main(String[] args) {

		평행 a = new 평행();
		
		int [][] dot1 = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};	//1
		System.out.println(a.solution(dot1));
		int [][] dot2 = {{3, 5}, {4, 1}, {2, 4}, {5, 10}};	//0
		System.out.println(a.solution(dot2));
	}

}
