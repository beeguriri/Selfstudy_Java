package Java_Programmers.Level0;

public class 다음에올숫자 {

	
	/* 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 
	 * 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
	 * */
	
    public int solution(int[] common) {
        int answer = 0;
        
        //등차수열일때
        if (common[1] - common[0] == common[2] - common[1]) 
        	answer = common[common.length-1] + common[1] - common[0];
        //등비수열일때
        else if (common[1]/common[0] == common[2] / common[1])
        	answer = common[common.length-1]*(common[1]/common[0]);
        	
        
        return answer;
    }
    
	public static void main(String[] args) {

		다음에올숫자 a = new 다음에올숫자();
		
		int [] arr1 = {1, 2, 3, 4};
		System.out.println(a.solution(arr1));  //5
		
		int [] arr2 = {2, 4, 8};
		System.out.println(a.solution(arr2));	//16
	}

}
