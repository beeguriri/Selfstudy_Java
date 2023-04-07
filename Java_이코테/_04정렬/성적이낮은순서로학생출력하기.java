package Java_이코테._04정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 성적이낮은순서로학생출력하기 {

    /*첫번째 줄에 학생의 수 n
    * 두번째 줄부터 학생이름 점수
    * 학생의 이름을 성적이 낮은 순서대로 출력*/

    static class Student implements Comparable<Student>{

        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int compareTo(Student s) {
            if(this.score<s.score)
                return -1;
            else
                return 1;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for(int i=0; i<n; i++)
            System.out.print(list.get(i).name + " ");

    }
}
