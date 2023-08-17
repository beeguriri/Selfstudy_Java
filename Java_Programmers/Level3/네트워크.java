package Java_Programmers.Level3;

public class 네트워크 {

    public static boolean [] check;

    public static void dfs(int node, int n, int[][] computers) {
        check[node] = true;

        for(int i=0; i<n; i++)
            if(!check[i] && computers[node][i]==1)
                dfs(i, n, computers);

    }

    //연결된 것은 하나의 네트워크로 봄
    //노드 2개가 연결 => 1, 노드 1개가 연결(연결없음) => 1
    //연결된 노드의 개수를 찾는게 아님..
    public static int solution(int n, int[][] computers) {

        check = new boolean [n];

        int answer = 0;
        for(int i=0; i<n; i++){
            if(!check[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int [][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));//2
        System.out.println(solution(3, new int [][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));//1
    }
}
