package Java_Baekjoon._33_투포인터;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소수의연속합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n==1) {

            System.out.println(0);
            System.exit(0);
        }

        int [] temp = new int [n+1];

        temp[0] = temp[1] = 0;
        for(int i=2; i<=n; i++)
            temp[i] = i;

        //에라토스테네스의 체
        for (int i=2; i<=n; i++){
            if(temp[i]==0)
                continue;

            for(int j=i*2; j<=n; j+=i)
                temp[j] = 0;
        }

        List<Integer> prime = new ArrayList<>();
        for(int i : temp)
            if(i!=0)
                prime.add(i);

//        System.out.println(prime);


        int start = 0;
        int end = start + 1;
        int sum = prime.get(start);
        int cnt = 0;

        while(start<=end && end<=prime.size()){

            if(sum>=n) {

                if(sum==n)
                    cnt += 1;

                sum -= prime.get(start);
                start++;

            } else {
                if(end< prime.size())
                    sum += prime.get(end);

                end++;
            }
        }

        System.out.println(cnt);
    }
}
