package Java_Baekjoon._05_문자열;

import java.util.Scanner;

public class 다이얼 {

    /*첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다.
    단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.
    첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int answer = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            switch(c) {
                case 'A', 'B', 'C' :
                    answer += 3;
                    break;
                case 'D', 'E', 'F' :
                    answer += 4;
                    break;
                case 'G', 'H', 'I' :
                    answer += 5;
                    break;
                case 'J', 'K', 'L' :
                    answer += 6;
                    break;
                case 'M', 'N', 'O' :
                    answer += 7;
                    break;
                case 'P', 'Q', 'R', 'S' :
                    answer += 8;
                    break;
                case 'T', 'U', 'V' :
                    answer += 9;
                    break;
                default:
                    answer += 10;
                    break;
            }
        }
        System.out.println(answer);
    }
}
