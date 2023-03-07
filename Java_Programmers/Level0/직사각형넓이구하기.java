package Java_Programmers.Level0;

public class 직사각형넓이구하기 {

	/* 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다. 
	 * 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 
	 * 배열 dots가 매개변수로 주어질 때, 
	 * 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.
	 * */
		
    public int solution(int[][] dots) {
        int width = 0;
        int height = 0;
        
		//가로길이 구하기
        for(int i = 0; i<dots.length-1; i++) {
        	if(width!=0) break;
        	for(int j = 1; j<dots.length; j++) {
        		if(dots[i][1]==dots[j][1]) {
            		width = Math.abs(dots[j][0] - dots[i][0]);
            		break;
            	}
        	}
        }
        
        //세로길이 구하기
        for(int i=0; i<dots.length-1; i++) {
        	if(height!=0) break;
        	for(int j=1; j<dots.length; j++) {
            	if(dots[i][0]==dots[j][0])
            		height = Math.abs(dots[j][1] - dots[i][1]);
            		break;
        	}
        }
        
        return width * height;
    }
    
	public static void main(String[] args) {
		
		직사각형넓이구하기 a = new 직사각형넓이구하기();
		
		int [][] dots1 = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};
		System.out.println(a.solution(dots1));	//1
		
		int [][] dots2 = {{-1, -1}, {1,1}, {1,-1}, {-1,1}};
		System.out.println(a.solution(dots2));
	}

}
