package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에별만들기 {

    public static String[] solution(int[][] line) {

        //1. 교점을 찾고
        List<int []> list = new ArrayList<>();

        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        int minX= Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        for(int i=0; i<line.length-1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for(int j=i+1; j< line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a*d - b*c;
                long bfed = b*f - e*d;
                long ecaf = e*c - a*f;

                if(adbc==0)
                    continue;

                if(bfed%adbc!=0 || ecaf%adbc!=0)
                    continue;

                int pointX = (int)(bfed/adbc);
                int pointY = (int)(ecaf/adbc);

                list.add(new int[]{pointX, pointY});
                minX = Math.min(minX, pointX);
                minY = Math.min(minY, pointY);
                maxX = Math.max(maxX, pointX);
                maxY = Math.max(maxY, pointY);
            }
        }

        //2. 숫자에 따라 좌표찍기
        String [][] board = new String [maxY-minY+1][maxX-minX+1];
        for(String [] b : board)
            Arrays.fill(b, ".");

        for(int [] p : list) {
            int x = maxY - p[1];
            int y = p[0] - minX;
            board[x][y] = "*";
        }

        for(String [] b : board)
            System.out.println(Arrays.toString(b));

        //3. 출력하기
        String [] answer = new String[board.length];
        for(int i=0; i<board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(String s : board[i])
                sb.append(s);
            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int [][] {{2, -1, 4}, {-2, -1, 4},
                {0, -1, 1}, {5, -8, -12}, {5, 8, 12}})));

//        System.out.println(Arrays.toString(solution(new int [][] {{0, 1, -1}, {1, 0, -1},
//                {1, 0, 1}})));
//
//        System.out.println(Arrays.toString(solution(new int [][] {{1, -1, 0}, {2, -1, 0}})));
    }
}
