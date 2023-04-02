package Java_이코테._03그래프탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();

        // 현재 노드를 방문 처리
        q.offer(start);
        visited[start] = true;

        //q가 empty가 될때까지 반복
        while(!q.isEmpty()) {

            int x = q.poll(); //1 -> 2 -> 3 -> 8 -> 7 -> 4 -> 5 -> 6
            System.out.print(x + " ");

            //해당 원소와 연결된 노드를 queue에 넣고 반복
            for(int i=0; i<graph.get(x).size(); i++){

                int y = graph.get(x).get(i); //2, 3, 8 => (1) , 7 => 4, 5 => (1), (7) => 6
                if(!visited[y]){
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        // 그래프 초기화
        for (int i = 0; i < 9; i++)
            graph.add(new ArrayList<Integer>());

        //노드1에 연결된 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        //노드2에 연결된 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        //노드3에 연결된 정보 저장
        graph.get(3).add(4);
        graph.get(3).add(5);

        //노드 4에 연결된 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        //노드 5에 연결된 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        //노드 6에 연결된 정보 저장
        graph.get(6).add(7);

        //노드 7에 연결된 정보 저장
        graph.get(7).add(6);
        graph.get(7).add(8);

        //노드 8에 연결된 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        //방문 함수 호출
        bfs(1); //1 2 3 8 7 4 5 6



    }
}
