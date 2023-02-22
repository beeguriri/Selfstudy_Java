package Java_Programmers.Level0;

public class 두수의나눗셈 {

	/* 정수 num1과 num2가 매개변수로 주어질 때, 
	   num1을 num2로 나눈 값에 1,000을 곱한 후 
	   정수 부분을 return 하도록 solution 함수를 완성해주세요.
	*/
	
    static int solution(double num1, double num2) {
        double answer = (num1 / num2) *1000;
        return (int) answer;
    }
	
    static int solution1(int num1, int num2) {
        double answer = (double)num1 / (double)num2 ; 
        return (int) (answer*1000);
    }
    
	public static void main(String[] args) {
		
		int ans1 = solution(3,2);
		System.out.println("ans1 : " + ans1); //1500
		
		int ans2 = solution(7,3);
		System.out.println("ans2 : " + ans2); //2333
		
		int ans3 = solution(1,16);
		System.out.println("ans3 : " + ans3); //62
		
	}

}
