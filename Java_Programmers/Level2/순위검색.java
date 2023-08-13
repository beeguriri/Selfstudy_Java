package Java_Programmers.Level2;

import java.util.*;

public class 순위검색 {

    public static Map<String, ArrayList<Integer>> scoreMap = new HashMap<>();
    public static String [] result = new String [4];

    public static void makeScoreMap(int depth, String [] params, int score) {

        if(depth==4) {

            //scoreMap에 추가하기
            String str = String.join("", result);

            if(!scoreMap.containsKey(str))
                scoreMap.put(str, new ArrayList<>());

            scoreMap.get(str).add(score);

            return;
        }

        //params 값을 쓸거냐 말거냐만 결정할거라
        //일반적인 순열로 돌릴거 아님
        result[depth] = params[depth];
        makeScoreMap(depth+1, params, score);
        result[depth] = "-";
        makeScoreMap(depth+1, params, score);

    }

    public static int lowerBinarySearch(List<Integer> list, int low, int high, int target){

        while(low<=high){

            int mid = (low+high)/2;

            if(list.get(mid)<target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int [query.length];

        //info로 scoreMap 만들기
        /*
          public static void arraycopy(
              @NotNull  Object src,
         *     int srcPos,
         *     @NotNull Object dest,
         *     int destPos,
         *     int length
         */
        for (String s : info) {

            String[] temp = s.split(" ");
            String[] params = new String[4];
            System.arraycopy(temp, 0, params, 0, params.length);
            int score = Integer.parseInt(temp[4]);

            makeScoreMap(0, params, score);
        }

        //한번에 정렬
        //왜 쿼리 안에서 정렬하면 효율성 초과 나는지 모르게뜸...
        //해당 키에 대한 정렬만 하는거라 더 효율적이지않나..?
        for(String key : scoreMap.keySet())
            Collections.sort(scoreMap.get(key));

        //쿼리로 찾기
        for(int i=0; i<query.length; i++){

            String [] temp = query[i].split(" and | ");

            String [] params = new String[4];
            System.arraycopy(temp, 0, params, 0, params.length);

            String key = String.join("",params);
            int target = Integer.parseInt(temp[4]);

            //해당 키에 대한 정렬
            if(!scoreMap.containsKey(key))
                answer[i] = 0;
            else {
                List<Integer> list = scoreMap.get(key);
//                Collections.sort(list);

                int idx = lowerBinarySearch(list, 0, list.size()-1, target);
                answer[i] = list.size() - idx;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String [] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String [] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));

    }
}
