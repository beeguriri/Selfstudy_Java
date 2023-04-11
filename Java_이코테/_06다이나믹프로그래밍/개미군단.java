package Java_이코테._06다이나믹프로그래밍;

import java.awt.print.Printable;
import java.security.Principal;
import java.util.Arrays;

public class 개미군단 {

    public static void main(String[] args) {

        int n = 4;
        int [] quest = {1, 3, 1, 5};

        int [] d = new int [100];
        d[0] = quest[0];
        d[1] = Math.max(quest[0], quest[1]); //quest[1]이 되어야하는거 아닐까..?

        for(int i=2; i<n; i++)
            d[i] = Math.max(d[i-1], d[i-2]+quest[i]);

        System.out.println(d[n-1]);
    }

}
