package Java_Baekjoon._31_그래프와순회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2 {

    // 1초 후 X-1, X+1, 2*X
    // 첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
    // 둘째 줄에는 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수를 출력한다.

    public static int n, k;
    public static int [] visited = new int [100001];
    public static int minTime = 100001;
    public static int result = 0;

    public static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 1;

        while(!q.isEmpty()) {

            int now = q.poll();

            if(minTime < visited[now])
                return;

            int [] directions = {now-1, now+1, now*2};

            for(int next : directions) {

                if(next<0 || next>100000)
                    continue;

                if(next==k) {
                    result += 1;
                    minTime = visited[now];
                }

                // 중복 방문 허용
                if(visited[next]==0 || visited[next]==visited[now]+1){
                    q.offer(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        if(n>=k) {
            System.out.println(n-k);
            System.out.println(1);
        } else {
            bfs();
            System.out.println(minTime);
            System.out.println(result);
        }

    }
}
