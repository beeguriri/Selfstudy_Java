package Java_Programmers.Level0;

import java.util.Arrays;

public class 중앙값구하기 {
	
	/* 문제
	 * 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다. 
	 * 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 array가 매개변수로 주어질 때, 
	 * 중앙값을 return 하도록 solution 함수를 완성해보세요.*/
	
	/*배열의 정렬
	 * 자바 내장객체 Arrays 이용
	 * 오름차순 일 경우 : Arrays.sort(배열명)
	 * 내림차순 일 경우 : reverseOrder 사용 위하여 boxing 해줘야함
	 * Integer[] tmp = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
	 * Arrays.sort(배열명, Comparator.reverseOrder());
	 * */
	
	static int solution(int[] array) {
		
		//배열의 정렬
		System.out.print("정렬전 : ");
		for(int i=0; i<array.length; i++) System.out.print(array[i] + " ");
		
		Arrays.sort(array);
		
		System.out.print("\n정렬후 : ");
		for(int i=0; i<array.length; i++) System.out.print(array[i] + " ");		
		
		int answer = array[array.length/2];
        return answer;
    }
	
	public static void main(String[] args) {
		
		int [] array1 = {1, 2, 7, 10, 11};
		int ans1 = solution(array1);
		System.out.println("\n중앙값 ans1 : " + ans1 + "\n");
		 
		int [] array2 = {9, -1, 0};
		int ans2 = solution(array2);
		System.out.println("\n중앙값 ans2 : " + ans2);

	}

}
