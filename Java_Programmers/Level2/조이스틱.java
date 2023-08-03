package Java_Programmers.Level2;

public class 조이스틱 {

    public static int solution(String name) {

        int answer = 0;
        int dir = name.length()-1;

        for(int i=0; i<name.length(); i++) {

            //A에서 올라갈지, Z에서 내려갈지 결정
            int up = name.charAt(i) - 'A';
            int down = 'Z' - name.charAt(i) + 1;
            answer += Math.min(up, down);

            //좌우로 이동
            //내 뒤에 연속되는 A의 개수 확인
            int idx = i+1;
            while(idx<name.length() && name.charAt(idx)=='A')
                idx++;

            //해당인덱스에서 역방향 확인
            int reverse = i*2 + (name.length()-idx);
            dir = Math.min(dir, reverse);

            //예외케이스
            //처음부터 뒤로가서 변경 후 다시 오는 방법
            reverse = (name.length()-idx)*2 + i;
            dir = Math.min(dir, reverse);

        }

        return answer + dir;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN")); //56
        System.out.println(solution("JAN")); //23
        System.out.println(solution("BBBBAAAAAAAB")); //10

    }
}
