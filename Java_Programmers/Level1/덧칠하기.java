package Java_Programmers.Level1;

import java.util.Arrays;

public class 덧칠하기 {

    /*벽을 1미터 길이의 구역 n개로 나누고, 각 구역에 왼쪽부터 순서대로 1번부터 n번까지 번호를 붙였습니다.
    그리고 페인트를 다시 칠해야 할 구역들을 정했습니다.
    벽에 페인트를 칠하는 롤러의 길이는 m미터이고, 롤러로 벽에 페인트를 한 번 칠하는 규칙은 다음과 같습니다.
    롤러가 벽에서 벗어나면 안 됩니다. 구역의 일부분만 포함되도록 칠하면 안 됩니다.
    정수 n, m과 다시 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열 section이 매개변수로 주어질 때
    롤러로 페인트칠해야 하는 최소 횟수를 return 하는 solution 함수를 작성해 주세요.
    1 ≤ m ≤ n ≤ 100,000
    1 ≤ section의 길이 ≤ n*/

    public int solution(int n, int m, int[] section) {
        int cnt = 0;
        int [] wall = new int [100001];

        Arrays.fill(wall, 1);

        for(int i=0; i<section.length; i++)
            wall[section[i]] = 0;

        for(int i=1; i<=n; ) {

            if (wall[i] == 0) {
                for (int j = i; j < i+m; j++) {
                    if(j<=n)
                        wall[j] = 1;
                    else
                        break;
                }
                i += m;
                cnt++;
            } else
                i++;
        }
        return cnt;
    }

    public static void main(String[] args) {

        덧칠하기 a = new 덧칠하기();

        int [] section1 = {2, 3, 6};
        System.out.println(a.solution(8, 4, section1));

        int [] section2 = {1, 3};
        System.out.println(a.solution(5, 4, section2));

        int [] section3 = {1, 2, 3, 4};
        System.out.println(a.solution(4, 1, section3));
    }
}
