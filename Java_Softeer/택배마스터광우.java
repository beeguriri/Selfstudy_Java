package Java_Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 택배마스터광우 {

    public static int N, M, K;
    public static int [] rails;
    public static boolean [] visited;
    public static int [] result;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rails = new int [N];
        visited = new boolean [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            rails[i] = Integer.parseInt(st.nextToken());

        result = new int [N];
        dfs(0);
        System.out.println(answer);

    }

    public static void dfs(int depth) {

        //dfs 종료조건
        if(depth == N) {

            //계산시작
            Queue<Integer> queue = new LinkedList<>();

            for(int i : result)
                queue.offer(i);

            int sum = 0;
            int total = 0;
            int countK = 0;

            //1번 (5+8)
            //2번 (5+8) + (10)
            //3번 (5+8) + (10) + (19)
            //4번 (5+8) + (10) + (19) + (7+5+8) = 62

            while(!queue.isEmpty()) {

                sum += queue.peek();
                queue.offer(queue.poll());

                if(sum+queue.peek()> M) {
                    total += sum;
                    countK++;
                    sum = 0;
                }

                if(countK==K)
                    break;
            }

            answer = Math.min(answer, total);
        }

        //순열로 구해야함
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = rails[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }

    }
}
