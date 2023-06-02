package Java_Baekjoon.구현;

import java.util.Scanner;

public class 달팽이2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean [][] visited = new boolean [m][n];
        int cnt = 0;

        int [] di = {0, 1, 0, -1};
        int [] dj = {1, 0, -1, 0};

        int cx = 0; int cy =0;
        int idx = 0;
        int result = 1;

        visited[cx][cy] = true;

        while(idx<4) {

            int nx = cx + di[idx];
            int ny = cy + dj[idx];

            if(result == n*m)
                break;

            if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                result += 1;
                cx = nx;
                cy = ny;

            } else {
                idx += 1;
                cnt += 1;
            }

            if(idx>=4)
                idx = 0;

        }

        System.out.println(cnt);
    }
}
