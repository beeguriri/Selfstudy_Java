package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {

    /*첫째 줄에 n,m이 주어진다.
    m은 입력으로 주어지는 연산의 개수이다. 다음 m개의 줄에는 각각의 연산이 주어진다.
    합집합은 0 a b의 형태로 입력이 주어진다.
    두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
    1로 시작하는 입력에 대해서 a와 b가 같은 집합에 포함되어 있으면
    "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.*/

    public static int [] parent;

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot)
            return;

        parent[bRoot] = aRoot;

    }

    static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int [n+1];

        //parent 초기화
        for (int i=1; i<=n; i++)
            parent[i] = i;

        for(int i=0; i<m; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x==0)
                union(a,b);
            else {
                int aRoot = find(a);
                int bRoot = find(b);

                if(aRoot == bRoot)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }

        }
    }
}
