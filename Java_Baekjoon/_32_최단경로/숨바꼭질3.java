package Java_Baekjoon._32_최단경로;

import java.util.*;

public class 숨바꼭질3 {

    public static class Node {
        private final int index;
        private final int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }
    }

    public static final int INF = 100000;
    public static int [] d = new int [100001];

    public static int dijkstra(int start, int end) {

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        Arrays.fill(d, INF);

        pq.offer(new Node(start, 0));
        d[start] =0;

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();

            if(d[now]<node.getTime())
                continue;

            int next1 = now + 1;
            if(isPossible(next1) && d[now]+1 < d[next1]) {
                d[next1] = d[now]+1;
                pq.offer(new Node(next1, d[next1]));
            }

            int next2 = now - 1;
            if(isPossible(next2) && d[now]+1 < d[next2]) {
                d[next2] = d[now]+1;
                pq.offer(new Node(next2, d[next2]));
            }

            int next3 = now * 2;
            if(isPossible(next3) && d[now] < d[next3]) {
                d[next3] = d[now];
                pq.offer(new Node(next3, d[next3]));
            }

        }
        return d[end];
    }

    public static boolean isPossible(int pos){
        return pos > 0 && pos <= 100000;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();

        if (start>=end)
            System.out.println(start-end);
        else
            System.out.println(dijkstra(start, end));
    }
}
