package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 타임머신 {

    public static class Node {

        private int from;
        private int to;
        private int cost; //가중치

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getCost() {
            return cost;
        }
    }

    public static final int INF = Integer.MAX_VALUE;
    public static ArrayList<Node> graph = new ArrayList<>();
    public static int n, m; //노드의 개수, 간선의 개수
    public static long [] d;

    public static boolean bellmanFord(int start){

        d = new long [n+1];
        Arrays.fill(d, INF);
        d[start] = 0;

        // 노드의 개수만큼 반복
        for (int i = 1; i <= n ; i++) {
            // 간선의 개수만큼 반복
            for (int j = 0; j < m ; j++) {
                Node node = graph.get(j);

                // from -> to로 갈때 시작점이 무한대면 갈 수 없음
                if (d[node.getFrom()] == INF)
                    continue;

                // from -> to 비용과, to의 비용 확인
                if (d[node.getFrom()] + node.getCost() < d[node.getTo()]){

                    // 마지막 노드에서 갱신이 일어나면, 음의 사이클 존재
                    // 음수 간선 순환은 돌면 돌수록 값이 작아짐
                    if(i==n)
                        return false;

                    d[node.getTo()] = d[node.getFrom()] + node.getCost();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Node(a, b, c));
        }

        StringBuilder sb = new StringBuilder();
        if (!bellmanFord(1)) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <=n ; i++) {
                if (d[i]==INF)
                    sb.append(-1).append("\n");
                else
                    sb.append(d[i]).append("\n");
            }
        };

        System.out.print(sb);

//        System.out.println(Arrays.toString(d));



    }
}
