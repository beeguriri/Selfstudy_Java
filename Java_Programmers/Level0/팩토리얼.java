package Java_Programmers.Level0;

public class 팩토리얼 {

	/* i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다. 
	 * 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다. 
	 * 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 
	 * solution 함수를 완성해주세요.
	 * i! ≤ n
	 * 제한사항 : 0 < n ≤ 3,628,800 (10!)
	 * */
	
    public int solution(int n) {
        int multi = 1;
        int fact = 0;
        
        for (int i=1; i<=10; i++) {
        	
        	multi *= i;
        	
        	if(multi>n)	break;
        	else         	fact++;

        }
        
        return	fact;
    }
    
   
	public static void main(String[] args) {

		팩토리얼 a = new 팩토리얼();
		
		System.out.println(a.solution(3628800)); //10
		System.out.println(a.solution(7));	//3

	}

}
