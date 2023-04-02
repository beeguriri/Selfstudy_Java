package Java_이코테._03그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {

    /*첫째 줄에 도시의 개수 n, 도로의 개수 m, 거리 k, 시작도시 x
    * 2번째줄 부터 a -> b번 도시 단방향 도로
    * x에서 출발하여 최단거리가 k인 모든 도시번호 출력(오름차순)
    * 도시가 없을경우 -1 출력*/

    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // 모든 도시에 대한 최단 거리(1<=k<=30000)
    public static int[] d = new int[300001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        //그래프 및 최단거리 초기화
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        //도로정보 입력
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        //출발도시 거리 = 0
        d[x] = 0;

        //너비우선탐색
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);

        while(!q.isEmpty()){
            int now = q.poll();

            //현재 탐색할수 있는 도시 확인
            for(int i=0; i<graph.get(now).size(); i++){
                int next = graph.get(now).get(i);
                //방문하지않은 도시라면 최단거리 update 및 q에 넣기
                if(d[next]==-1){
                    q.offer(next);
                    d[next] = d[now] + 1;
                }
            }
        }

        //최단거리가 k인 도시 출력
        boolean check = false;
        for(int i=1; i<=n; i++){
            if(d[i]==k){
                System.out.print(i);
                check = true;
            }
        }

        if(!check) System.out.println(-1);

    }
}
