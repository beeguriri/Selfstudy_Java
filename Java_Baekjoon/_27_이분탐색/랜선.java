package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 랜선 {

    public static long [] lans;

    public static long upperBound(long start, long end, int target) {

        while(start<end){

            long mid = (start+end)/2;
            long count = 0;

            for(long l : lans)
                count += l/mid;

            //mid길이 줄여야 함
            //end = mid-1 : 런타임에러..????
            if(count<target)
                end = mid;
            //mid 길이 늘려야함
            else
                start = mid+1;

        }

        return start-1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int n = Integer.parseInt(temp.split(" ")[0]);
        int k = Integer.parseInt(temp.split(" ")[1]);

        lans = new long [n];
        long max = 0;
        for(int i=0; i<n; i++){
            lans[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lans[i]);
        }

        System.out.println(upperBound(0, max, k));
    }


}
