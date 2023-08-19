package Java_Programmers.Level3;

public class P_06 {

    /*
       단어 변환
       begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
    */

    public static int answer = 0;
    public static boolean [] check;

    public static void dfs(String begin, String target, String [] words, int count){

        //dfs 종료조건
        if(begin.equals(target)) {
            answer = count;
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(!check[i] && isOneDiffer(begin, words[i])) {
                check[i] = true;
                dfs(words[i], target, words, count+1);
                check[i] = false;
            }
        }
    }

    public static boolean isOneDiffer(String target1, String target2){
        int count = 0;

        for(int i=0; i<target1.length(); i++)
            if(target1.charAt(i)==target2.charAt(i))
                count++;

        return count==target1.length()-1;
    }

    public static int solution(String begin, String target, String[] words) {

        check = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog"	, new String [] {"hot", "dot", "dog", "lot", "log", "cog"})); //4
    }

}
