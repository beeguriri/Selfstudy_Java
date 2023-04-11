package Java_이코테._06다이나믹프로그래밍;

import java.util.Arrays;

public class 효율적인화폐구성 {

    /* n가지 종류 화폐 개수를 최소한으로 이용해서 그 가치합이 m원이 되도록 한다
    * 1<=n<=100, 1<=m<=10000 */

    public static void main(String[] args) {

        int n = 2;
        int m = 15;
        int [] arr = {2, 3};
        int [] d = new int [m+1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int i=0; i<n; i++) {
            for (int j=arr[i]; j<=m; j++) {
                if(d[j-arr[i]]!=10001)
                    d[j] = Math.min(d[j], d[j-arr[i]]+1);
            }
        }

        if(d[m]==10001)
            System.out.println(-1);
        else
            System.out.println(d[m]);
    }

}
