package Java_이코테._08기타그래프이론;

public class UnionFind2 {

    public static int v, e; //노드의개수 v, 간선의 개수 e
    public static int [] parent;

    public static int findParent(int x) {

        if(x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {

        a = findParent(a);
        b = findParent(b);

        if(a<b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) {

        v=6; e=4;
        parent = new int [v+1];

        // 부모를 자기자신으로 초기화
        for (int i = 1; i <=v; i++)
            parent[i] = i;

        boolean cycle = false;

        // Union 연산 각각 수행하며 사이클 판별
        int [][] test = {{1,2}, {1,3}, {2,3}};

        for (int i = 0; i < e; i++) {
            if(findParent(test[i][0])==findParent(test[i][1])){
                cycle = true;
                break;
            }
            else
                unionParent(test[i][0], test[i][1]);
        }

        if(cycle)
            System.out.println("사이클 발생");
        else
            System.out.println("사이클 발생X");

    }
}
