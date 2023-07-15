package Java_Programmers.Level2;

import java.util.*;

public class 메뉴리뉴얼 {

    public static Map<String, Integer> map = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();

        // orders의 각 order 정렬
        for(int i=0; i< orders.length; i++) {
            char [] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }

        // course 개수만큼
        for (int count : course) {

            // 메뉴 조합 구하기
//            for(String order : orders)
//                combination("", order, count);
            for(String order: orders)
                combination2(order.toCharArray(), new char[count], 0, 0, order.length(), count);

            //자바 8에서 컴파일 안됨
//            List<String> list = map.keySet()
//                    .stream().sorted(
//                            (o1, o2) -> map.get(o2) - map.get(o1)
//                    )
//                    .toList();

            List<String> list = new ArrayList<>(map.keySet());

            if(list.size()==0)
                break;

            list.sort((o1, o2) -> map.get(o2) - map.get(o1));

            //2명 이상 고른 메뉴
            int max = map.get(list.get(0));

            if(max >= 2)
                for(String key : list)
                    if(map.get(key)==max)
                        result.add(key);

            map.clear();

        }

        Collections.sort(result);

        return result.toArray(String[]::new);
    }

    public static void combination(String order, String others, int count) {

        if(count == 0) {
            map.put(order, map.getOrDefault(order, 0)+1);
            return;
        }

        for(int i=0; i<others.length(); i++)
            combination(order + others.charAt(i), others.substring(i+1), count -1);

    }

    //속도가 더 빠름
    public static void combination2(char [] input, char [] output, int depth, int next, int n, int r) {

        if(depth == r) {
            map.put(String.valueOf(output), map.getOrDefault(String.valueOf(output), 0)+1);
            return;
        }

        for(int i=next; i<n; i++) {
            output[depth] = input[i];
            combination2(input, output, depth+1, i+1, n, r);
        }
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String []{"CFGAB", "AC", "DEC", "ADCE", "BCFG", "ACDEH"}, new int []{2,3,4})));
        System.out.println(Arrays.toString(solution(new String []{"XYZ", "XWY", "WXA"}, new int []{2,3,4})));
    }
}
