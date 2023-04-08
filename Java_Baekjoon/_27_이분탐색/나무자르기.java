package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {

    /*첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다.
    (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
    둘째 줄에는 나무의 높이가 주어진다.
    나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다.
    높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.
    적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다. */

    public static int binarySearch(int [] arr, int target, long start, long end){

        while(start < end){

            long mid = (start+end)/2;
            long sum = 0;

            for(int i: arr)
                if(i > mid)
                    sum += (i-mid);

            if(sum<target)
                end = mid;
            else
                start = mid + 1;

        }
        return (int)(start-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] tree = new int [n];
        long treeMax = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            treeMax = Math.max(treeMax, tree[i]);
        }

        System.out.println(binarySearch(tree, m, 0, treeMax+1));
    }
}
