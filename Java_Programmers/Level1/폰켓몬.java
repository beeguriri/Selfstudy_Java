package Java_Programmers.Level1;

import java.util.HashSet;
public class 폰켓몬 {

    /*홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
    * 당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에,
    * 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
    * N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
    * N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
    * 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.*/

    public int solution(int[] nums) {
        int answer = 0;
        int get = nums.length/2;
        HashSet<Integer> temp = new HashSet<>();
        for(int x : nums)
            temp.add(x);

        if(get >= temp.size()) answer = temp.size();
        else answer = get;

        return answer;
    }

    public static void main(String[] args) {

        폰켓몬 a = new 폰켓몬();

        int [] nums1 = {3,1,2,3}; //get 4/2 = 2 , size : 3
        System.out.println(a.solution(nums1));  //2

        int [] nums2 = {3,3,3,2,2,4}; //get 6/2 = 3, size : 3
        System.out.println(a.solution(nums2)); //3

        int [] nums3 = {3,3,3,2,2,2}; //get 6/2 = 3, size : 2
        System.out.println(a.solution(nums3)); //2

    }
}
