package Java_Programmers.Level0;

public class 치킨쿠폰 {
	
	/* 프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다. 
	 * 쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 
	 * 서비스 치킨에도 쿠폰이 발급됩니다. 
	 * 시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 
	 * 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.
	 * */

	//100	11
	// => 100/10 = 10(0), 10/10 = 1(0);
	//1,081	120
	// => 1081 / 10 = 108(1), 108/10 = 10(8), 10/10 = 1(1);
	
    public int solution(int chicken) {

    	int coupon = chicken;
    	int service = 0;
        
    	while(coupon>=10) {
    		
    		service += coupon/10;
    		coupon = coupon%10 + coupon/10;
    	}
    	
        return service;
    }
	
	public static void main(String[] args) {
		
		치킨쿠폰 a = new 치킨쿠폰();
		
		System.out.println(a.solution(100));	//11
		
		System.out.println(a.solution(1081));	//120

		System.out.println(a.solution(1999));	//222

	}

}
