package Java_Programmers.Level1;

import java.util.Arrays;

public class 가장가까운같은글자 {

    /*문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서,
    자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
    예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
    b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
    a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
    n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
    a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
    n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
    a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
    따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.*/

    public int[] solution(String s) {
        int[] answer = new int [s.length()];
        answer[0] = -1;     //제일  첫글자는 무조건 처음 나오는 글자
        String [] temp = s.split("");
        for(int i = 1; i<s.length(); i++) {
            if((s.substring(0,i).contains(temp[i]))) {
                answer[i] = i - s.indexOf(temp[i]);
                s = s.substring(0,i).replace(temp[i], temp[i].toUpperCase()) + s.substring(i);
            } else answer[i] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        가장가까운같은글자 a = new 가장가까운같은글자();

        System.out.println(Arrays.toString(a.solution("banana"))); //[-1, -1, -1, 2, 2, 2]
        System.out.println(Arrays.toString(a.solution("foobar"))); //[-1, -1, 1, -1, -1, -1]
    }
}
