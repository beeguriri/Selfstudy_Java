package Java_이코테._08기타그래프이론;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {

    public static int v, e;
    public static int [] indegree;
    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static List<Integer> result = new ArrayList<>();

    public static void topologySort() {

        Queue<Integer> q = new LinkedList<>();

        //진입차수가 0인 노드 큐에 삽입
        for(int i=1; i<=v; i++)
            if(indegree[i]==0)
                q.offer(i);

        //큐가 빌때까지 반복
        while(!q.isEmpty()) {

            int now = q.poll();
            result.add(now);

            for(int i=0; i<graph.get(now).size(); i++){
                int temp = graph.get(now).get(i);
                indegree[temp] -= 1;

                if(indegree[temp] == 0)
                    q.offer(temp);
            }
        }
    }

    public static void main(String[] args) {

        v = 7; e = 8;
        indegree = new int [v+1];

        //그래프 초기화
        for (int i = 0; i <= v; i++)
            graph.add(new ArrayList<>());

        //간선정보 입력
        graph.get(1).add(2); indegree[2] += 1;
        graph.get(1).add(5); indegree[5] += 1;
        graph.get(2).add(3); indegree[3] += 1;
        graph.get(2).add(6); indegree[6] += 1;
        graph.get(3).add(4); indegree[4] += 1;
        graph.get(4).add(7); indegree[7] += 1;
        graph.get(5).add(6); indegree[6] += 1;
        graph.get(6).add(4); indegree[4] += 1;

        //위상정렬
        topologySort();

        for(int i: result)
            System.out.print(i + " ");
    }
}
