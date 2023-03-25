package Java_Baekjoon._02_조건문;

import java.util.Scanner;

public class 사분면고르기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());

        if(x>0 && y>0) System.out.println("1");
        else if (x<0 && y>0) System.out.println("2");
        else if (x<0 && y<0) System.out.println("3");
        else System.out.println("4");
    }
}
