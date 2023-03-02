package Java_Programmers.Level0;

public class 배열의유사도 {
	
	/* 두 배열이 얼마나 유사한지 확인해보려고 합니다. 문자열 배열 s1과 s2가 주어질 때 
	 * 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.
	 * 제한사항: 
	 * s1과 s2의 원소는 알파벳 소문자로만 이루어져 있습니다
	 * s1과 s2는 각각 중복된 원소를 갖지 않습니다.
	 * */

	public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(int i = 0; i<s1.length; i++)  
        	for(int j=0; j<s2.length; j++) 
        		if(s1[i].equals(s2[j]))	answer++;
        	
        return answer;
    }
	
	public static void main(String[] args) {

		배열의유사도 a = new 배열의유사도();
		
		String [] s1 = {"a", "b", "c"};
		String [] s2 = {"com", "b", "d", "p", "c"}; 
		
		System.out.println(a.solution(s1, s2)); //2
		
		String [] s3 = {"n", "omg"};
		String [] s4 = {"m", "dot"};
		
		System.out.println(a.solution(s3, s4)); //0
	}

}
