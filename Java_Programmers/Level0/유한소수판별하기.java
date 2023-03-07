package Java_Programmers.Level0;

import java.util.ArrayList;

public class 유한소수판별하기 {
	
	/* 소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다. 
	 * 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다. 
	 * 유한소수가 되기 위한 분수의 조건은 다음과 같습니다.
	 * 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
	 * 두 정수 a와 b가 매개변수로 주어질 때, 
	 * a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.
	 * */
	
    public int solution(int a, int b) {
        int answer = 1;
        int god = godR(a,b);
        
        if(a%god==0 && b%god==0) {
        	a = a/god;
        	b = b/god;
        }
        
        ArrayList<Integer> soin = new ArrayList<>();
        
        soin.add(2);
        soin.add(5);
        
        for(int i = 3; i<=b; i++) {
        	if(b%i==0 && i!=5) {
        		
        		soin.add(i);
            	
            	for (int j = 0; j < soin.size(); j++) {
            		if(i % soin.get(j)==0 && i != soin.get(j)) {
            			soin.remove(new Integer(i));
            			break;
            		}
            			
            	}
        	}
        }
                	
        if (b % 2 ==0 || b%5 == 0 || b == 1) {
        	
        	for(int i = 2; i<soin.size(); i++) {
        		
        		if(b%soin.get(i)==0) {
        			answer = 2;
        			break;
        		}
        	}
        } else answer = 2;

        return answer;
    }
    
    static int godR (int a, int b) {
    	
    	if(b==0)
    		return a;
    	else 
    		return godR(b, a%b);
    }
	
	public static void main(String[] args) {

		유한소수판별하기 a = new 유한소수판별하기();
		
		System.out.println(a.solution(7, 20)); //1
		System.out.println(a.solution(11, 22));	//1
		System.out.println(a.solution(12, 21));	//2
		System.out.println(a.solution(1, 30)); //2
	}

}
