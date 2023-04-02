package Java_이코테._03그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus implements Comparable<Virus> {

    private final int index;  //바이러스 종류
    private final int second; //n초 후
    private final int x;  //바이러스 위치 x
    private final int y;  //바이러스 위치 y

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSecond() {
        return this.second;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // 정렬 기준은 '번호가 낮은 순서'
    @Override
    public int compareTo(Virus other) {
        if (this.index < other.index) {
            return -1;
        }
        return 1;
    }
}

public class 경쟁적전염 {

    /*매 초 번호가 낮은 바이러스부터 상하좌우로 전염
    * 첫번째줄에 N(행렬크기) K(바이러스 종류)
    * 두번째줄에 바이러스 위치
    * 세번째줄에 S초 후 X,Y의 바이러스 찾기
    * 없으면 0 */

    public static int n, k;
    public static int [][] graph;
    public static ArrayList<Virus> viruses = new ArrayList<Virus>();

    public static int [] dx = {0, 0, -1, 1}; //상하좌우
    public static int [] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int [n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());

                if(graph[i][j]!=0)
                    viruses.add(new Virus(graph[i][j], 0, i, j));
            }
        }

        //바이러스 번호로 정렬 후 큐에 넣기 (BFS)
        //Virus 클래스에 메서드 오버라이드 해둠
        Collections.sort(viruses);

        Queue <Virus> q = new LinkedList<>();
        for(int i=0; i<viruses.size(); i++)
            q.offer(viruses.get(i));

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        //q가 빌때까지
        while(!q.isEmpty()){

            Virus virus = q.poll();

            //혹은 s초일때까지 반복
            if(virus.getSecond() == s) break;

            //4가지 방향 탐핵
            for(int i=0; i<4; i++) {
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    if(graph[nx][ny]==0){
                        graph[nx][ny] = virus.getIndex();
                        q.offer(new Virus(graph[nx][ny], virus.getSecond()+1, nx, ny));
                    }
                }
            }
        }

        System.out.println(graph[x-1][y-1]);

    }
}
