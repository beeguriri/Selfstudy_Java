package Java_Programmers.Level1;

import java.util.Stack;

public class 크레인인형뽑기게임 {

    /*게임 화면의 격자의 상태가 담긴 2차원 배열 board와
    인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
    크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
    board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
    0은 빈 칸을 나타냅니다.
    1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.*/

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> temp = new Stack<>();
        for (int n : moves) {
            for (int i=0; i<board.length; i++) {
                if (board[i][n-1] != 0) {
                    if (temp.isEmpty()) {
                        temp.push(board[i][n-1]);
                        board[i][n-1] = 0;
                        break;
                    } else {
                        if(temp.peek() == board[i][n-1]) {
                            temp.pop();
                            board[i][n-1] = 0;
                            answer += 2;
                            break;
                        } else {
                            temp.push(board[i][n-1]);
                            board[i][n-1] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        크레인인형뽑기게임 a = new 크레인인형뽑기게임();

        int [][] board1 = {{0,0,0,0,0},{0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int [] moves1 = {1,5,3,5,1,2,1,4};

        System.out.println(a.solution(board1, moves1)); //4

    }
}
