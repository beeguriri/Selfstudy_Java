package Java_Baekjoon._25_그리디;

import java.io.*;

public class _5와6의차이 {

    /*상근이가 숫자 5를 볼 때, 5로 볼 때도 있지만, 6으로 잘못 볼 수도 있고,
    6을 볼 때는, 6으로 볼 때도 있지만, 5로 잘못 볼 수도 있다.
    두 수 A와 B가 주어졌을 때, 상근이는 이 두 수를 더하려고 한다.
    이때, 상근이가 구할 수 있는 두 수의 가능한 합 중, 최솟값과 최댓값을 구해 출력하는 프로그램을 작성하시오.
    입력 : 첫째 줄에 두 정수 A와 B가 주어진다. (1 <= A,B <= 1,000,000)
    출력 : 첫째 줄에 상근이가 구할 수 있는 두 수의 합 중 최솟값과 최댓값을 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String num1 = str.split(" ")[0];
        String num2 = str.split(" ")[1];

        int min = Integer.parseInt(num1.replace('6','5')) + Integer.parseInt(num2.replace('6','5'));
        int max = Integer.parseInt(num1.replace('5','6')) + Integer.parseInt(num2.replace('5','6'));

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
        //11 25 => 36 37
        //1430 4862 => 6282 6292

    }
}
