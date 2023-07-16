package Java_Programmers.Level2;

import java.util.Arrays;

public class 프렌즈4블록 {

    //7번 시간초과
    public static int m, n;
    public static char [][] map;
    public static boolean [][] visited;

    //m이 높이, n이 너비
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char [m][n];

        //맵 초기화
        for(int i=0; i<m; i++)
            map[i] = board[i].toCharArray();

        //반복 횟수 모름
        while(true) {
            visited = new boolean [m][n];
            boolean flag = true;

            //블록체크
            //블럭 하나를 기준으로 오른쪽, 아래쪽, 대각선  체크해주므로
            //범위 지정을 m-1, n-1까지 해줌
            for(int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    if (map[i][j] == '0')
                        continue;

                    if(isPossible(i, j)) {
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                        flag = false;
                    }
                }
            }

            // 블록체크 통과 못했으면 반복문 종료
            if(flag)
                break;

            for(boolean [] b : visited)
                System.out.println(Arrays.toString(b));

            for(char [] b : map)
                System.out.println(Arrays.toString(b));

            System.out.println("=".repeat(30));

            //체크된 블럭 삭제
            for(int i=0; i<m; i++) {
                for (int j=0; j<m; j++) {
                    if (visited[i][j]) {
                        map[i][j] = '0';
                        answer++;
                    }
                }
            }

            //블럭 내리기
            for(int c=0; c<n; c++) {
                for (int r=m-1; r>=0; r--) {
                    if(map[r][c]=='0') {
                        for(int k=r-1; k>=0; --k) {
                            if(map[k][c]=='0')
                                continue;

                            map[r][c] = map[k][c];
                            map[k][c] = '0';
                            break;
                        }
                    }
                }
            }
        }

        for(char [] b : map)
            System.out.println(Arrays.toString(b));

        System.out.println("=".repeat(30));


        return answer;
    }

    public static boolean isPossible(int x, int y) {
        return map[x][y] == map[x+1][y]
                && map[x][y] == map[x][y+1]
                && map[x][y] == map[x+1][y+1];
    }

    public static void main(String[] args) {
//        System.out.println(solution(6, 6, new String [] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
//        System.out.println(solution(4, 5, new String [] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(4, 5, new String [] {"AAAAA","AUUUA","AUUAA","AAAAA"}));
//4 , 5, ["AAAAA","AUUUA","AUUAA","AAAAA"] 답은 14입니다
    }

}
