package Java_Programmers.Level2;

public class 문자열압축 {

    public static int solution(String s) {

        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++) {

            String target = s.substring(0, i);
            int count = 1;
            String compare;
            StringBuilder result = new StringBuilder();

            for(int j=i; j<=s.length(); j+=i) {

                //비교할 문자열 자르기
                if(j+i>=s.length())
                    compare = s.substring(j);
                else
                    compare = s.substring(j, j+i);

                //자른 문자열 비교
                //문자열이 같으면 카운트 증가
                if(compare.equals(target)) {
                    count++;
                }
                //문자열이 다르면
                // 카운트 여부로 판단
                else if (count>=2) {
                    result.append(count).append(target);
                    target = compare;
                    count = 1;
                } else {
                    result.append(target);
                    target = compare;
                }
            }

            //자르고 남은 문자열 추가
            if(target.length()<i)
                result.append(target);

            System.out.println(result);
            answer = Math.min(answer, result.length());

        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc")); //7
        System.out.println(solution("ababcdcdababcdcd")); //9
        System.out.println(solution("xababcdcdababcdcd")); //17
    }
}
