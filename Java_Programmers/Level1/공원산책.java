package Java_Programmers.Level1;

import java.util.Arrays;

public class 공원산책 {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int[][] boards = new int[park.length][park[0].length()];
        int sx = 0;
        int sy = 0;

        for (int i = 0; i < park.length; i++) {
            String temp = park[i];
            for (int j = 0; j < park[0].length(); j++) {
                String s = temp.substring(j, j + 1);
                if (s.equals("S")) {
                    sx = i;
                    sy = j;
                    boards[i][j] = 0;
                } else if (s.equals("X"))
                    boards[i][j] = 1;
            }
        }

        for (int i = 0; i < routes.length; i++) {

            String dir = routes[i].split(" ")[0];
            int x = Integer.parseInt(routes[i].split(" ")[1]);

            int nx = sx;
            int ny = sy;

            for (int j = 0; j < x; j++) {

                if (dir.equals("E"))
                    ny++;

                if (dir.equals("S"))
                    nx++;

                if (dir.equals("W"))
                    ny--;

                if (dir.equals("N"))
                    nx--;

                if (nx < 0 || ny < 0 || nx >= park.length || ny >= park[0].length() || boards[nx][ny]==1)
                    break;

                if (j == x-1) {
                    sx = nx;
                    sy = ny;
                }
            }
        }

        answer[0] = sx;
        answer[1] = sy;

        return answer;
    }

    public static void main(String[] args) {

        공원산책 a = new 공원산책();

        String [] p1 = {"SOO","OOO","OOO"};
        String [] d1 = {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(a.solution(p1,d1))); //[2,1]

        String [] p2 = {"SOO","OXX","OOO"};
        String [] d2 = {"E 2","S 2","W 1"};
        System.out.println(Arrays.toString(a.solution(p2,d2)));

        String[] p3 = {"OSO", "OOO", "OXO", "OOO"};
        String[] d3 = {"E 2", "S 3", "W 1"};
        System.out.println(Arrays.toString(a.solution(p3, d3)));

    }
}
