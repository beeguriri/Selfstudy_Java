package Java_Baekjoon._17_조합론;

import java.util.ArrayList;
import java.util.Scanner;

public class 베라의패션 {

    public static int n;
    public static int [] arr;
    public static int count;

    public static void per(ArrayList<Integer> list, int r) {

        if(r ==0){
            System.out.println(list);
            count++;
            return;
        }

        for(int i=0; i<n; i++) {

            if(list.contains(arr[i]))
                continue;

            list.add(arr[i]);
            per(list, r-1);
            list.remove(list.size()-1);

        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int [n];
        for(int i=0; i<n; i++)
            arr[i] = i+1;

        per(new ArrayList<Integer>(), 2);

        System.out.println(count);

    }
}
