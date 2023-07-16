package Java_Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 프렌즈4블록 {

    //7번 시간초과
    public static char [][] map;
    public static boolean [][] visited;

    //m이 높이, n이 너비
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char [m][n];

        //맵 초기화
        for(int i=0; i<m; i++)
            map[i] = board[i].toCharArray();

        //제거 할 블럭이 없을때 까지 반복
        while(true) {

            visited = new boolean [m][n];
            boolean flag = true;

            //블록체크
            //블럭 하나를 기준으로 오른쪽, 아래쪽, 대각선  체크해주므로
            //범위 지정을 m-1, n-1까지 해줌
            for(int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    if (map[i][j] == '-')
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

            // 삭제 할 블럭 개수
            answer += removeBlock(m, n);

            //블럭 내리기
            //제거하지않을 블럭을 행의 제일 마지막 원소부터 큐에 넣음
            //큐의 제일 마지막 원소부터 큐에서 빼서 map을 다시 채움
            //큐에서 채울것이 없을때는 '-'로 채움
            resetMap(m, n);

        }

        return answer;
    }

    public static boolean isPossible(int x, int y) {
        return map[x][y] == map[x+1][y]
                && map[x][y] == map[x][y+1]
                && map[x][y] == map[x+1][y+1];
    }

    public static int removeBlock(int m, int n) {
        int count = 0;
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j]) {
                    map[i][j] = '-';
                    count++;
                }
            }
        }
        return count;
    }

    public static void resetMap(int m, int n) {
        Queue<Character> queue = new LinkedList<>();
        for(int col=0; col<n; col++) {
            int idx = m-1;
            for(int row=m-1; row>=0; row--) {
                if(map[row][col]!='-')
                    queue.offer(map[row][col]);
            }
            while(!queue.isEmpty()) {
                map[idx--][col] = queue.poll();
            }
            while(idx>=0) {
                map[idx--][col] = '-';
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(6, 6, new String [] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"})); //15
        System.out.println(solution(4, 5, new String [] {"CCBDE", "AAADE", "AAABF", "CCBBF"})); //14
        System.out.println(solution(4, 5, new String [] {"AAAAA","AUUUA","AUUAA","AAAAA"})); //14

    }

}
