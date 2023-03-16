package Java_Programmers.Level1;

import java.util.*;

public class 실패율 {

    /*만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
    스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.*/

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        List<Integer> stg = new ArrayList<>();
        for(int x : stages)
            stg.add(x);

        float [][] temp = new float [N][2];
        for(int i=0; i<N; i++){
            temp[i][0]=i+1;
            int cnt = 0;
            int size = stg.size();
            for(int j=stg.size()-1; j>=0; j--) {
                if(stg.get(j)==i+1) {
                    cnt++;
                    stg.remove(j);
                }
            }
            temp[i][1] = (float)cnt/size;
        }

        Arrays.sort(temp, new Comparator<float[]>(){

            @Override
            public int compare(float[] o1, float[] o2) {
                if(o1[1] > o2[1]) return -1;
                else if (o1[1] < o2[1]) return 1;
                else {
                    if(o1[0]>o2[0]) return 1;
                    else return -1;
                }
            }
        });
        System.out.println(Arrays.deepToString(temp));

        for (int i = 0; i <answer.length; i++) {
            answer[i] = (int) temp[i][0];
        }
        return answer;
    }

    public static void main(String[] args) {
        실패율 a = new 실패율();

        int [] stg1 = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(a.solution(5, stg1))); //[3,4,2,1,5]

        int [] stg2 = {4,4,4,4,4};
        System.out.println(Arrays.toString(a.solution(4, stg2))); //[4,1,2,3]
    }
}
