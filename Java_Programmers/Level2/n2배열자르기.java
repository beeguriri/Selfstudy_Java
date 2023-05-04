package Java_Programmers.Level2;

public class n2배열자르기 {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int [(int)(right-left)+1];

        for(int i=0; i<answer.length; i++) {
            int x = (int)(left / n) + 1;
            int y = (int)(left % n) + 1;
            answer[i] = Math.max(x, y);
            left++;

        }

        return answer;
    }

    //메모리 초과
    public long[] solution1(int n, long left, long right) {

        long [][] board = new long [n][n];

        for(int i=0; i<n; i++) {
            board[i][i] = i+1;
            for(int j=0; j<i; j++) {
                board[j][i] = i+1;
                board[i][j] = i+1;
            }
        }

        // System.out.println(Arrays.deepToString(board));
        long [] temp = new long [n*n];
        int k = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                temp[k++] = board[i][j];

        // System.out.println(Arrays.toString(temp));
        long [] answer = new long [(int)(right-left)+1];

        int j = 0;
        for(int i = (int)left; i<=right; i++)
            answer[j++] = temp[i];

        return answer;
    }
}
