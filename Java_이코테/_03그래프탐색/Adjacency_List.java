package Java_이코테._03그래프탐색;

import java.util.ArrayList;

class Node1 {

    private int index;
    private int distance;

    //생성자
    public Node1(int idx, int dist){
        this.index = idx;
        this.distance = dist;
    }

    public void show() {
        System.out.println("(" + this.index + ", " + this.distance + ")");
    }
}

public class Adjacency_List {

    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();

    public static void main(String[] args) {

        //graph ArrayList 초기화
        for(int i=0; i<3; i++)
            graph.add(new ArrayList<Node1>());

        //Node0번의 연결정보 저장
        graph.get(0).add(new Node1(1, 7));
        graph.get(0).add(new Node1(2, 5));

        //Node1번의 연결정보 저장
        graph.get(1).add(new Node1(0, 7));

        //Node2번의 연결정보 저장
        graph.get(2).add(new Node1(0, 5));

        //출력
        for(int i=0; i<3; i++){
            for(int j=0; j<graph.get(i).size(); j++){
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}
