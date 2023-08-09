package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 집합 {

    //add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    //remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    //check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    //toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    //all: S를 {1, 2, ..., 20} 으로 바꾼다.
    //empty: S를 공집합으로 바꾼다.

    public static Set<Integer> set = new HashSet<>();
    public static Set<Integer> allSet = new HashSet<>();
    //StringBuilder 안쓰면 시간초과
    public static StringBuilder sb = new StringBuilder();

    public static void setFunc(String menu, int num) {

        switch (menu) {
            case "add" -> set.add(num);
            case "remove" -> set.remove(num);
            case "check" -> {
                if (set.contains(num))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            case "toggle" -> {
                if (set.contains(num))
                    set.remove(num);
                else
                    set.add(num);
            }
            case "all" -> set = new HashSet<>(allSet);
            case "empty" -> set = new HashSet<>();
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        for(int i=1; i<=20; i++)
            allSet.add(i);


        for(int i=0; i<m; i++) {
            String line = br.readLine();
            String menu = line.split(" ")[0];
            if(menu.equals("all") || menu.equals("empty")) {
                setFunc(menu, 0);
            }
            else {
                int num = Integer.parseInt(line.split(" ")[1]);
                setFunc(menu, num);
            }

        }

        System.out.println(sb);

    }
}
