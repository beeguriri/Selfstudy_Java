package Java_Baekjoon._31_그래프와순회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {

    /*첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다.
    N과 K는 정수이다.(0 ≤ N,M ≤ 100,000)
    수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
    수빈이가 동생을 찾는 가장 빠른 시간을 출력한다. */

    public static int n, k;
    public static int [] visited = new int [100001];

    public static void bfs(int first) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(first);
        visited[first] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();
            int[] dx = {x + 1, x - 1, x * 2};

            for (int i=0; i<3; i++) {

                int nx = dx[i];

                if (nx<0 || nx>100000)
                    continue;

                if (nx==k) {
                    System.out.println(visited[x]);
                    return;
                }

                if (visited[nx] == 0) {
                    q.offer(nx);
                    visited[nx] = visited[x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if(n==k)
            System.out.println(0);
        else
            bfs(n);
    }
}
