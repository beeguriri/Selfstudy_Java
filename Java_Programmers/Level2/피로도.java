package Java_Programmers.Level2;

public class 피로도 {

    public static boolean [] visited;
    public static int answer = 0;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons){

        for (int i = 0; i < dungeons.length; i++) {

            if(visited[i] || k<dungeons[i][0])
                continue;

            visited[i] = true;
            dfs(depth+1, k-dungeons[i][1], dungeons);
            visited[i] = false;

        }

        answer = Math.max(answer, depth);
    };

    public static void main(String[] args) {

        피로도 a = new 피로도();

        int [][] dungeons = {{80, 20},{50, 40},{30, 10}};

        System.out.println(a.solution(80, dungeons)); //3
    }
}
