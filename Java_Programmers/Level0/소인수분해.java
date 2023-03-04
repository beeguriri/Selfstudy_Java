package Java_Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class 소인수분해 {
	/* 소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다. 
	 * 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 
	 * 따라서 12의 소인수는 2와 3입니다. 
	 * 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 
	 * solution 함수를 완성해주세요.
	 * 제한사항 : 2 ≤ n ≤ 10,000
	 * */
	    
    public int [] solution(int n) {
    	
    	ArrayList<Integer> a = new ArrayList<>();
    	
    	//소인수 모두 찾기
        for(int i =0,j=2; i<=n-2 && j<=n; i++, j++)	
        	if(n%j==0) 
        		a.add(j);
        
        //소인수 제거
        for(int i=a.size()-1; i>=0; i--) {
        	
        	for(int j=0; j<i; j++) {

            	if(a.get(i)%a.get(j)==0) {
            		a.remove(i);
            		break;
            	}
        	}
        }
        
        int [] answer = new int [a.size()];
        for(int i=0; i<answer.length; i++) 
        	answer[i] = a.get(i);
        
    	return answer;
    	
    }
    
    public int [] solution2(int n) {
    	
    	LinkedHashSet<Integer> primeNumbers = new LinkedHashSet<>();
    	//hashset 중복허용 안함

        int i = 2;
        while (n != 0 && i <= n) {
            if (n % i == 0) {
                primeNumbers.add(i);
                n /= i;
            } else	i++;
        }
        
        return primeNumbers.stream().mapToInt(Integer::intValue).toArray();
    	
    }

	public static void main(String[] args) {
		
		소인수분해 a = new 소인수분해();
		
//		System.out.println(Arrays.toString(a.solution(12)));
		System.out.println(Arrays.toString(a.solution2(12)));

		
		//System.out.println(Arrays.toString(a.solution(17)));
		System.out.println(Arrays.toString(a.solution2(17)));

//		System.out.println(Arrays.toString(a.solution(240)));
		System.out.println(Arrays.toString(a.solution2(240)));

	}

}
