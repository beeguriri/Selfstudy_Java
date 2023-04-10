package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 국영수 {

    /*도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다.
    이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
    국어 점수가 감소하는 순서로
    국어 점수가 같으면 영어 점수가 증가하는 순서로
    국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
    모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
    (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
    문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.*/

    static class Students implements Comparable<Students> {

        private String name;
        private int korean;
        private int english;
        private int math;

        public Students(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKorean() {
            return korean;
        }

        public void setKorean(int korean) {
            this.korean = korean;
        }

        public int getEnglish() {
            return english;
        }

        public void setEnglish(int english) {
            this.english = english;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        @Override
        public int compareTo(Students o) {

            //국어 내림차순
            //영어 오름차순
            //수학 내림차순
            //이름 사전순 -> 오름차순

            if(this.korean > o.korean)
                return -1;
            else if (this.korean < o.korean)
                return 1;
            else {

                if(this.english > o.english )
                    return 1;
                else if (this.english < o.english)
                    return -1;
                else {

                    if(this.math > o.math )
                        return -1;
                    else if (this.math < o.math)
                        return 1;
                    else {

                        if(this.name.compareTo(o.name) > 0 )
                            return 1;
                        else
                            return -1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Students> list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            Students student = new Students(name, korean, english, math);
            list.add(student);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append(list.get(i).getName()).append("\n");

        System.out.println(sb);
    }
}
