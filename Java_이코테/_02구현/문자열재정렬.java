package Java_이코테._02구현;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 문자열재정렬 {

    /*입력 : 알파벳 대문자와 숫자(0-9)로만 구성된 문자열
    * 알파벳을 오름차순으로 정렬하여 이어서 출력한 후 모든 숫자를 더한값을 이어서 출력
    * K1KA5CB7 => ABCKK13
    * AJKDLSI412K4JSJ9D => ADDIJJJKKLSS20*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        String [] str = input.replaceAll("[0-9]", "").split("");
        String [] num = input.replaceAll("[A-Z]", "").split("");
        int sum = 0;

        Arrays.sort(str);
        for(String s : str)
            sb.append(s);

        for(String n : num)
            sum += Integer.parseInt(n);

        sb.append(sum);

        System.out.println(sb);



    }
}
