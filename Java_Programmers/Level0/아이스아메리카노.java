package Java_Programmers.Level0;

public class 아이스아메리카노 {

	
	/* 머쓱이는 추운 날에도 아이스 아메리카노만 마십니다. 
	 * 아이스 아메리카노는 한잔에 5,500원입니다. 
	 * 머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때, 
	 * 머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 return 하도록 
	 * solution 함수를 완성해보세요.
	 * 제한사항 : 0 < money ≤ 1,000,000 
	 * */
	
	static int[] solution(int money) {
        
		int[] answer = new int[2];
        int price = 5500;
        
        answer[0] = money / price;
        answer[1] = money % price;
        
        return answer;
    }
	
	public static void main(String[] args) {

		int[] ans1 = solution(5500);
		for(int num : ans1) System.out.print(num + ", ");
		
		System.out.println();
		
		int[] ans2 = solution(15000);
		for(int num : ans2) System.out.print(num + ", ");
		
		
	}

}
