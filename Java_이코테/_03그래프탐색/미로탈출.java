package Java_이코테._03그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}


public class 미로탈출 {

    //5 6
    //101010
    //111111
    //000001
    //111111
    //111111
    //답 : 10

    /* NxM 크기의 직사각형 형태의 미로
    (4<=N, M <= 200)
    처음위치 (1,1), 출구(N,M) 한번에 한칸씩 이동
    괴물이 있는 부분은 0, 괴물이 없는 부분은 1입니다.
    입력 : 미로 세로길이 N과 가로길이 M이 주어집니다.
    두번째줄부터 N+1번째줄까지 미로의 형태가 주어집니다.
    출력 : 탈출하기 위해 움직여야 하는 최소 칸의 개수(시작칸과 마지막칸 모두 포함)*/

    public static int n, m;
    public static int [][] graph = new int [201][201];

    public static int [] dx = {-1, 1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));

        //큐가 빌때까지 반복
        while(!q.isEmpty()) {

            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            //현재위치에서 4가지 방향 탐색
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //크기 벗어나면 무시
                if (nx < 0 || nx >=n || ny < 0 || ny >= m)
                    continue;

                //괴물이 있으면 무시
                if (graph[nx][ny] == 0)
                    continue;

                //해당노드 처음 방문하는 경우
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return graph[n-1][m-1];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();
        n = Integer.parseInt(size.split(" ")[0]);
        m = Integer.parseInt(size.split(" ")[1]);

        //입력-> 숫자로 저장
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }
}
