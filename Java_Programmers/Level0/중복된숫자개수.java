package Java_Programmers.Level0;

public class 중복된숫자개수 {

	/* 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때, 
	 * array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.
	 * */
	
	public int solution(int[] array, int n) {
        int answer = 0;
        
        for(int i = 0; i<array.length; i++)
        	if(n==array[i])	answer++;
        
        return answer;
    }
	
	public static void main(String[] args) {

		중복된숫자개수 a = new 중복된숫자개수();
		
		int [] arr1 = {1, 1, 2, 3, 4, 5};
		System.out.println(a.solution(arr1, 1)); //2
		
		int [] arr2 = {0, 2, 3, 4};
		System.out.println(a.solution(arr2, 1)); //0
		
	}

}
