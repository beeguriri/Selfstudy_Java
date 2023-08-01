package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {

    public static int n;
    public static int result;
    public static int sharkX, sharkY;
    public static int sharkSize = 2;
    public static int minX, minY, minDist;
    public static int eatingCount;
    public static int [][] board;
    public static int [][] dist;

    public static void bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>();
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        queue.offer(new int [] {x, y});

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            for(int i=0; i<4; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;

                if(board[nx][ny]<=sharkSize && dist[nx][ny]==0) {

                    dist[nx][ny] = dist[now[0]][now[1]] + 1;
                    queue.offer(new int []{nx, ny});

                    //상어의 이동위치 갱신
                    if(board[nx][ny]!=0 && board[nx][ny]<sharkSize) {
                        if(dist[nx][ny] < minDist) {
                            minDist = dist[nx][ny];
                            minX = nx;
                            minY = ny;
                        }
                        //거리가 같으면 위쪽우선 -> 왼쪽우선
                        else if(dist[nx][ny]==minDist) {
                            if(nx<minX) {
                                minX = nx;
                                minY = ny;
                            } else if(nx==minX) {
                                if(ny<minY) {
                                    minX = nx;
                                    minY = ny;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int [n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j]==9){
                    sharkX = i;
                    sharkY = j;
                    board[i][j] = 0;
                }
            }
        }

        while(true) {

            dist = new int [n][n];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs(sharkX, sharkY);

            //물고기를 먹었다면
            if(minX!=Integer.MAX_VALUE && minY!=Integer.MAX_VALUE) {
                eatingCount++;
                board[minX][minY] = 0;
                sharkX = minX;
                sharkY = minY;
                result += dist[minX][minY];

                if(eatingCount == sharkSize) {
                    sharkSize++;
                    eatingCount=0;
                }
            } else
                break;
        }

        System.out.println(result);
    }
}
