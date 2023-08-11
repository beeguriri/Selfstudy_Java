package Java_Baekjoon.구현;

import java.util.*;

public class 팰린드롬만들기_메모리초과 {

    public static int n;
    public static char [] charSet;
    public static char [] result;
    public static boolean [] check;
    public static Set<String> set = new HashSet<>();

    public static void makeWord(int depth) {

        if(depth==n) {
             StringBuilder sb = new StringBuilder();
            for(char c : result)
                sb.append(c);
            set.add(sb.toString());
        }

        for(int i=0; i<n; i++) {
            if(!check[i]) {
                check[i] = true;
                result[depth] = charSet[i];
                makeWord(depth+1);
                check[i] = false;
            }
        }
    }

    public static boolean isAnswer(String s){

        int pl = 0;
        int pr = s.length()-1;

        while(pl<=pr) {
            if(s.charAt(pl)!=s.charAt(pr))
                return false;

            pl++;
            pr--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        charSet = sc.next().toCharArray();

        n = charSet.length;
        check = new boolean[n];
        result = new char[n];

        makeWord(0);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        String answer="I'm Sorry Hansoo";
        for(String s : list){
            if(isAnswer(s)) {
                answer = s;
                break;
            }
        }

        System.out.println(answer);
    }
}
