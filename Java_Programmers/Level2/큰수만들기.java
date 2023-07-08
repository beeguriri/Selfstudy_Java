package Java_Programmers.Level2;


public class 큰수만들기 {

    public static String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();
        int idx=0;

        //검색범위 설정하고 (k=4 => 5개중에 1개 선택, 4개 빼버림)
        //그 범위안에서 최대값을 찾음
        //다음 범위 탐색 시 최대값의 인덱스 뒤로만 탐색
        for(int i=0; i<number.length()-k; i++) {
            char max = '0';
            for(int j=idx; j<=i+k; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j+1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        System.out.println(solution("1924", 2)); //"94"
        System.out.println(solution("1231234", 3)); //"3234"
        System.out.println(solution("4177252841", 4)); //"775841"


    }
}
