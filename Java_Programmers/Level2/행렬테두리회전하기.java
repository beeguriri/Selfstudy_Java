package Java_Programmers.Level2;

import java.util.Arrays;
import java.util.Stack;

public class 행렬테두리회전하기 {
    public static int[] solution(int rows, int columns, int[][] queries) {

        int [][] board = new int [rows+1][columns+1];
        int num = 1;
        for(int i=1; i<=rows; i++)
            for (int j = 1; j <= columns; j++)
                board[i][j] = num++;

//        for(int [] b : board)
//            System.out.println(Arrays.toString(b));

        int[] answer = new int [queries.length];

        Stack<Integer> stack = new Stack<>();

        int idx = 0;

        for(int [] query : queries) {

            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            int minValue = 200000;

            //방향 돌면서 추가
            //col -> 방향
            for(int i=y1; i<=y2; i++)
                stack.push(board[x1][i]);

            //row 아래방향
            for(int i=x1+1; i<=x2; i++)
                stack.push(board[i][y2]);

            //col <- 방향
            for(int i=y2-1; i>=y1; i--)
                stack.push(board[x2][i]);

            //row 위방향
            for(int i=x2-1; i>x1; i--)
                stack.push(board[i][y1]);

//            System.out.println(stack);

            // stack에서 값 꺼내면서 교체
            //row 아래방향
            for(int i=x1; i<=x2; i++) {
                board[i][y1] = stack.pop();
                minValue = Math.min(minValue, board[i][y1]);
            }

            //col -> 방향
            for(int i=y1+1; i<=y2; i++) {
                board[x2][i] = stack.pop();
                minValue = Math.min(minValue, board[x2][i]);
            }

            //row 위방향
            for(int i=x2-1; i>=x1; i--) {
                board[i][y2] = stack.pop();
                minValue = Math.min(minValue, board[i][y2]);
            }

            //col <- 방향
            for(int i=y2-1; i>y1; i--) {
                board[x1][i] = stack.pop();
                minValue = Math.min(minValue, board[x1][i]);
            }

//            for(int [] b : board)
//                System.out.println(Arrays.toString(b));

            answer[idx++] = minValue;

        }

        return answer;
    }
    public static void main(String[] args) {

        //제한사항
        //rows는 2 이상 100 이하인 자연수입니다.
        //columns는 2 이상 100 이하인 자연수입니다.
        //처음에 행렬에는 가로 방향으로 숫자가 1부터 하나씩 증가하면서 적혀있습니다.
        //즉, 아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자는 ((i-1) x columns + j)입니다.
        //queries의 행의 개수(회전의 개수)는 1 이상 10,000 이하입니다.
        //queries의 각 행은 4개의 정수 [x1, y1, x2, y2]입니다.
        //x1 행 y1 열부터 x2 행 y2 열까지 영역의 테두리를 시계방향으로 회전한다는 뜻입니다.
        //1 ≤ x1 < x2 ≤ rows, 1 ≤ y1 < y2 ≤ columns입니다.
        //모든 회전은 순서대로 이루어집니다.
        //예를 들어, 두 번째 회전에 대한 답은 첫 번째 회전을 실행한 다음, 그 상태에서 두 번째 회전을 실행했을 때 이동한 숫자 중 최솟값을 구하면 됩니다.
        System.out.println(Arrays.toString(solution(6, 6, new int [][] {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}}))); // [8, 10, 25]
        System.out.println(Arrays.toString(solution(3, 3, new int [][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}))); // [1, 1, 5, 3]
        System.out.println(Arrays.toString(solution(100, 97, new int [][] {{1,1,100,97}}))); // [1]
    }
}
