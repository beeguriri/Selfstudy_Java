package Java_Programmers.Level0;

public class 안전지대 {
	
	/* 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
	 * 지뢰는 2차원 배열 board에 1로 표시되어 있고 
	 * board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
	 * 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 
	 * 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
	 * */
	
    public int solution(int[][] board) {
        int answer = 0;
        
        //outofbount 피하기 위해 경계 포함한 board 만들어줌
        int[][] new_board = new int[board.length+2][board[0].length+2];
        int[][] result = new int[board.length+2][board[0].length+2];
        
        for (int i =0; i < new_board.length; i++) {
        	for (int j = 0; j < new_board[0].length; j++) {
        		
        		if(i==0 || i==new_board.length-1 ||
        				j==0 || j==new_board.length-1) {
        			new_board[i][j] = 8;
        			result[i][j] = 8;
        		} else {
        			new_board[i][j] = board[i-1][j-1];
        			result[i][j] = 0;
        		}
        	}
        }
        
//        System.out.println(Arrays.deepToString(new_board));
//        System.out.println(Arrays.deepToString(result));
        
        //result=0이면 안전, result=3이면 위험으로 구분
        for (int i = 1; i<new_board.length-1; i++) {
        	for (int j = 1; j<new_board.length-1; j++) {
        		if(board[i-1][j-1]==1) { 
        			result[i][j] = 3;
        			result[i-1][j-1] = 3;
        			result[i-1][j] = 3;
        			result[i-1][j+1] = 3;
        			result[i][j-1] = 3;
        			result[i][j+1] = 3;
        			result[i+1][j-1] = 3;
        			result[i+1][j] = 3;
        			result[i+1][j+1]=3;
        		}        		
        	}
        }
        
        //result의 0의 갯수 새기
        for (int i = 1; i<new_board.length-1; i++) {
        	for (int j = 1; j<new_board.length-1; j++) {
        		if(result[i][j]==0)	answer++;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {

		안전지대 a = new 안전지대();
		
		int [][] board1 = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,1,0,0},{0,0,0,0,0}};
		System.out.println(a.solution(board1));	//16
		
		int [][] board2 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},
				{0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};	
		System.out.println(a.solution(board2));//13
		
		int [][] board3 = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, 
				{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
		System.out.println(a.solution(board3)); //0
		
	}
}
