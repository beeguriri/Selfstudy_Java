package Java_Programmers.Level0;

import java.util.Arrays;

public class 캐릭터의좌표 {
	
	/* 머쓱이는 RPG게임을 하고 있습니다. 
	 * 게임에는 up, down, left, right 방향키가 있으며 
	 * 각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한 칸씩 이동합니다. 
	 * 예를 들어 [0,0]에서 up을 누른다면 캐릭터의 좌표는 [0, 1], 
	 * down을 누른다면 [0, -1], left를 누른다면 [-1, 0], right를 누른다면 [1, 0]입니다. 
	 * 머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다. 
	 * 캐릭터는 항상 [0,0]에서 시작할 때 
	 * 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 return하도록 solution 함수를 완성해주세요.
	 * 제한사항 : board의 크기를 벗어난 방향키 입력은 무시합니다.
	 * */
	
	//[]	[11, 11]	
	//[]	[7, 9]	
	
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int max_x = board[0] / 2;
        int max_y = board[1] / 2;
        
        for(int i = 0; i<keyinput.length; i++) {
        	
        	switch(keyinput[i]) {
        	
        	case "up":
        		if(answer[1] < max_y)
        			answer[1] += 1; 
        		else answer[1] = max_y;
        		break;
        		
        	case "down": 
        		if(answer[1] > -max_y)
            		answer[1] -= 1;
        		else answer[1] = -max_y;
        		break;
        		
        	case "left":
        		if(answer[0] > -max_x)
            		answer[0] -= 1;
        		else answer[0] = -max_x;
        		break;
    		
        	case "right":
        		if(answer[0] < max_x)
            		answer[0] += 1;
        		else answer[0] = max_x;
        		break;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {

		캐릭터의좌표 a = new 캐릭터의좌표();
		
		String [] dir = {"left", "right", "up", "right", "right"};
		int [] board = {11,11};
		System.out.println(Arrays.toString(a.solution(dir, board))); //[2, 1]
		
		String [] dir2 = {"down", "down", "down", "down", "down"};
		int [] board2 = {7, 9};
		System.out.println(Arrays.toString(a.solution(dir2, board2))); //[0, -4]

		
	}

}
