package Java_이코테._08기타그래프이론;

public class 서로소집합 {

    public static int v, e; //노드의 개수 v, 간선의 개수 e
    public static int [] parent;

    //특정 원소가 속한 집합을 찾기
    //루트노드 찾을때 까지 재귀 호출
    public static int findParent(int x){

        if(x==parent[x])
            return x;

        return findParent(parent[x]);
    }

    //두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b){
        //각각의 루트번호를 찾은 후
        a = findParent(a);
        b = findParent(b);

        //루트번호가 큰쪽이 작은쪽을 가르키도록 함.
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

        // Union 연산 각각 수행
        int [] a = {1, 2, 2, 5};
        int [] b = {4, 3, 4, 6};

        for(int i=0; i<e; i++)
            unionParent(a[i], b[i]);

        System.out.println("각 원소가 속한 집합");
        for (int i = 1; i <= v; i++)
            System.out.print(findParent(i) + " ");

        System.out.println();
        System.out.println("부모 테이블");
        for(int i: parent)
            System.out.print(i + " ");
    }

}
