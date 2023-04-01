package Java_Baekjoon._14_집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대칭차집합 {

    /*첫째 줄에 집합 A의 원소의 개수와 집합 B의 원소의 개수가 빈 칸을 사이에 두고 주어진다.
    둘째 줄에는 집합 A의 모든 원소가, 셋째 줄에는 집합 B의 모든 원소가 빈 칸을 사이에 두고 각각 주어진다.
    각 집합의 원소의 개수는 200,000을 넘지 않으며, 모든 원소의 값은 100,000,000을 넘지 않는다.
    첫째 줄에 대칭 차집합의 원소의 개수를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> tempA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++) {
            int x = Integer.parseInt(st.nextToken());
            setA.add(x);
            tempA.add(x);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++)
            setB.add(Integer.parseInt(st.nextToken()));

        setA.removeAll(setB); //A-B
        System.out.println(setA);

        setB.removeAll(tempA); //B-A
        System.out.println(setB);

        System.out.println(setA.size() + setB.size());
    }
}
