package Java_Programmers.Level0;

public class 공던지기 {
	
	/* 머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다. 
	 * 공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다. 
	 * 친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때, 
	 * k번째로 공을 던지는 사람의 번호는 무엇인지 return 하도록 
	 * solution 함수를 완성해보세요.
	 * 제한사항: 
	 * 2 < numbers의 길이 < 100
	 * 0 < k < 1,000
	 * */
	
	public int solution(int[] numbers, int k) {
        int answer = 0;
        
        int [] temp = new int [numbers.length*k];
        
        for (int i = 0; i<numbers.length*k; i++) 
        	temp[i] = numbers[i%numbers.length];
                
        return answer=temp[(k-1)*2];
        
        //다른사람꺼
        //return numbers[((k-1)*2)%numbers.length];
        
    }	
	
	public static void main(String[] args) {

		공던지기 a = new 공던지기();
		
		int [] numbers1 = {1, 2, 3, 4};
		System.out.println(a.solution(numbers1, 2)); //3
		
		int [] numbers2 = {1, 2, 3, 4, 5, 6};
		System.out.println(a.solution(numbers2, 5)); //3

		int [] numbers3 = {1, 2, 3};
		System.out.println(a.solution(numbers3, 3)); //2

	}

}
