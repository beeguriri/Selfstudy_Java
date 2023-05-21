package Java_Baekjoon._32_최단경로;

import Java_이코테._07최단경로알고리즘.Dijkstra;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class 숨바꼭질3 {

    public static class Node {
        private int index;
        private int time;

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

    public static final int INF = 1000000;
    public static int start, end;
    public static int [] d;

    public static void dijkstra(int start) {

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);

        pq.offer(new Node(start, 0));
        d[start] =0;

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();
            int time = node.getTime();

            int [] dx = {now-1, now+1, now*2};

            for(int i=0; i<dx.length; i++) {

                int nx = now + dx[i];

                if(nx <start || nx>end)
                    continue;

                if(d[nx]<time)
                    continue;



            }
        }
    }

    public static void main(String[] args) {

    }
}
