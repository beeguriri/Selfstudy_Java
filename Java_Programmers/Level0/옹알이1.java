package Java_Programmers.Level0;

import java.util.ArrayList;

public class 옹알이1 {
	
	/* 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 
	 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 
	 * 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다. 
	 * 문자열 배열 babbling이 매개변수로 주어질 때, 
	 * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
	 * */
	
    public int solution1(String[] babbling) {
        int answer = 0;
        String [] ano = {"aya", "ye", "woo", "ma"};
        
        for (String s : babbling) {
        	
        	for(int i = 0; i<ano.length; i++) 
        		if(s.startsWith(ano[i])|| s.endsWith(ano[i])) 
        			s = s.replace(ano[i], "");
        	
        	//앞선 글자 남아있을수있으므로
        	for(int i = 0; i<ano.length; i++) 
        		if(s.startsWith(ano[i])|| s.endsWith(ano[i])) 
        			s = s.replace(ano[i], "");
        		
        	if(s.length()==0) 
        		answer++;
        }
        
        return answer;
    }
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        ArrayList<String[]> list = new ArrayList<>();
        		
        for(String s: babbling) {
        	String [] temp = s.split("aya|ye|woo|ma");
        	list.add(temp);
        }
        
        for(int i = 0; i<list.size(); i++)
        	if(list.get(i).length ==0) answer++;
        
        return answer;
    }

	public static void main(String[] args) {

		옹알이1 a= new 옹알이1();
		
		String [] bab1 = {"aya", "yee", "u", "maa", "wyeoo"}; //	1
		System.out.println(a.solution(bab1));
		
		String [] bab2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}; //	3
		System.out.println(a.solution(bab2));
	}

}
