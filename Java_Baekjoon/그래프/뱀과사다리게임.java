package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {

    public static int [] board = new int [101];
    public static boolean [] visited = new boolean [101];
    public static int [] count = new int [101];

    public static int bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        count[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {

            int now = q.poll();

            if(now==100)
                return count[100];

            for(int i=1; i<=6; i++){

                int next = now + i;

                if(next>100 || visited[next])
                    continue;

                visited[next] = true;

                //사다리 또는 뱀의 위치
                if(board[next]!=0){
                    if(!visited[board[next]]) {
                        visited[board[next]] = true;
                        count[board[next]] = count[now] + 1;
                        q.offer(board[next]);
                    }
                }
                //빈 칸
                else {
                    count[next] = count[now] + 1;
                    q.offer(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //사다리개수
        int m = Integer.parseInt(st.nextToken()); //뱀의개수

        for(int i=0; i<n+m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }

        System.out.println(bfs(1));
        System.out.println();
    }
}
