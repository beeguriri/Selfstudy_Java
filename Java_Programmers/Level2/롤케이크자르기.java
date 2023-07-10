package Java_Programmers.Level2;

import java.util.*;

public class 롤케이크자르기 {

    public static int solution2 (int[] topping) {

        Map<Integer, Integer> toppingA = new HashMap<>();
        Set<Integer> toppingB = new HashSet<>();
        int answer = 0;

        for(int t : topping)
            toppingA.put(t, toppingA.getOrDefault(t, 0)+1);

        for(int t : topping) {

            if(toppingA.get(t)==1)
                toppingA.remove(t);
            else
                toppingA.put(t, toppingA.get(t)-1);

            toppingB.add(t);

            if(toppingA.size()==toppingB.size())
                answer++;
            System.out.println(toppingA);
            System.out.println(toppingB);
        }

        return answer;
    }

    //시간초과
    public static int solution(int[] topping) {
        int answer = 0;
        for(int i=1; i<topping.length; i++) {

            int [] arrA = Arrays.copyOfRange(topping, 0, i);
            int [] arrB = Arrays.copyOfRange(topping, i, topping.length);
            Set<Integer> setA = new HashSet<>(Arrays.asList(Arrays.stream(arrA).boxed().toArray(Integer[]::new)));
            Set<Integer> setB = new HashSet<>(Arrays.asList(Arrays.stream(arrB).boxed().toArray(Integer[]::new)));
            if(setA.size()==setB.size())
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution2(new int [] {1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(solution2(new int [] {1, 2, 3, 1, 4}));
    }
}
