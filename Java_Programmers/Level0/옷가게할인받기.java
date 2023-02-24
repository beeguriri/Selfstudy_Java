package Java_Programmers.Level0;

public class 옷가게할인받기 {

	/* 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 
	 * 50만 원 이상 사면 20%를 할인해줍니다.
	 * 구매한 옷의 가격 price가 주어질 때, 
	 * 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
	 * 제한사항 : 
	 * 10 ≤ price ≤ 1,000,000
	 * 소수점 이하를 버린 정수를 return합니다. 
	 * */
	
	static int solution(int price) {
        
        double answer = 0;

        if (price >= 500000) answer = price*0.8;
        else if (price >=300000) answer = price*0.9;
        else if (price >=100000) answer = price*0.95;
        else answer = price;

        answer = Math.floor(answer);
        
        //1의 자리에서 반올림
        return (int) answer;

        //1의 자리에서 반올림 : (int) (answer+5)/10*10
        //1의 자리에서 올림 : (int) (answer+9)/10*10
        //1의 자리에서 내림 : (int) (answer - answer%10)
        
        //이렇게까지 심오한 문제는 아니었다..ㅋ
    }
	
	public static void main(String[] args) {

		int ans1 = solution(567890);
		System.out.println("ans1 : " + ans1);
		
		int ans2 = solution(157890432);
		System.out.println("ans2 : " + ans2);
		
	}

}
