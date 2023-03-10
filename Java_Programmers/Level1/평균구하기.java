package Java_Programmers.Level1;
/* 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요. */
public class 평균구하기 {

    //[1,2,3,4]	2.5
    //[5,5]	5

    public double solution(int[] arr) {
        double answer = 0;
        for(int a: arr)
            answer += a;
        return answer/arr.length;
    }

    public static void main(String[] args) {
        평균구하기 a = new 평균구하기();
        int [] arr1 = {1,2,3,4};
        System.out.println(a.solution(arr1));

        int [] arr2 = {5,5};
        System.out.println(a.solution(arr2));
    }
}
