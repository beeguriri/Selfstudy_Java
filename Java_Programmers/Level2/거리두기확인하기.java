package Java_Programmers.Level2;

import java.util.Arrays;

public class 거리두기확인하기 {

    //교실 5개, 교실 당 5*5의 자리가 있음
    //맨하튼거리: |r1 - r2| + |c1 - c2|
    //P: 사람
    //O: 빈자리
    //X: 파티션
    public static int[] solution(String[][] places) {
        int[] answer = new int [5];

        //전체 교실 순회
        for(int i=0; i< places.length; i++) {

            // 각 교실 순회
            String [] classInfo = places[i];
            //{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
            char [][] board = new char[5][5];
            for(int j=0; j<5; j++)
                board[j] = classInfo[j].toCharArray();

            boolean flag = true;

            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(board[j][k]=='P'){
                        //여기서 이 자리가 유효한 지 체크 함.
                        if(!checkSeat(board, j, k))
                            //한가지라도 유효하지않으면
                            flag = false;
                    }
                }
            }

            answer[i] = flag ? 1 : 0;
        }

        return answer;
    }

    public static boolean checkSeat(char [][] board, int x, int y) {

        //상하좌우
        int [] dx1 = {-1, 0, 1, 0};
        int [] dy1 = {0, -1, 0, 1};
        for(int i=0; i<4; i++) {
            int nx = x + dx1[i];
            int ny = y + dy1[i];

            if(nx<0 || nx>=5 || ny<0 || ny>=5)
                continue;

            if(board[nx][ny]=='P')
                return false;
        }

        //맨하탄거리2의 상하좌우
        int [] dx2 = {-2, 0, 2, 0};
        int [] dy2 = {0, -2, 0, 2};
        for(int i=0; i<4; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];

            if(nx<0 || nx>=5 || ny<0 || ny>=5)
                continue;

            if(board[nx][ny]=='P'){
                if(board[(x+nx)/2][(y+ny)/2]!='X')
                    return false;
            }
        }

        //대각선
        int [] dx3 = {-1, -1, 1, 1};
        int [] dy3 = {-1, 1, -1, 1};
        for(int i=0; i<4; i++) {
            int nx = x + dx3[i];
            int ny = y + dy3[i];

            if(nx<0 || nx>=5 || ny<0 || ny>=5)
                continue;

            if(board[nx][ny]=='P'){
                if(!(board[x][ny]=='X' && board[nx][y]=='X'))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String [][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }
}
