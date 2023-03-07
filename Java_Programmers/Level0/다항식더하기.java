package Java_Programmers.Level0;

public class 다항식더하기 {

	/* 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 
	 * 다항식을 계산할 때는 동류항끼리 계산해 정리합니다. 
	 * 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 
	 * 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요. 
	 * 같은 식이라면 가장 짧은 수식을 return 합니다.
	 * 제한사항 :
	 * polynomial은 0부터 9까지의 정수, 공백, ‘x’, ‘+'로 이루어져 있습니다.
	 * 항과 연산기호 사이에는 항상 공백이 존재합니다.
	 * */
	
    public String solution(String polynomial) {
        String answer = "";
        int tempx = 0;
        int tempn = 0;
        
        String[] poly = polynomial.split(" ");
        
        for (int i=0; i<poly.length; i=i+2) {
        	
        	if(poly[i].contains("x")) {
        		
        		if(poly[i].charAt(0)!='x') {
        			tempx += Integer.parseInt(poly[i].replace("x", ""));
        		} else {
        			tempx += 1;
        		}
        	} else {
        		tempn += Integer.parseInt(poly[i]);
        	}
        }
        
        if(tempx == 0) {
        	if(tempn == 0) answer = "0";
        	else         	answer = String.valueOf(tempn);
        } else if(tempx ==1) {
        	if(tempn == 0)	answer = "x";
        	else 			answer = "x + " + String.valueOf(tempn);
        } else {
        	if(tempn==0)	answer = String.valueOf(tempx)+"x";
        	else         
            	answer = String.valueOf(tempx)+"x + "+ String.valueOf(tempn);
        }

        return answer;
    }
	
	public static void main(String[] args) {

		다항식더하기 a = new 다항식더하기();
		
		String poly1 = "3x + 7 + x";
		System.out.println(a.solution(poly1));	//4x + 7
		
		String poly2 = "x + x + x";
		System.out.println(a.solution(poly2));	//3x
		
		String poly3 = "x + 1 + 3";
		System.out.println(a.solution(poly3));
		
		System.out.println(a.solution("2 + 3 + x"));
		System.out.println(a.solution("x + 2x + 0"));
		
		System.out.println(a.solution("5x + 2 + 9x + 9"));
		System.out.println(a.solution("10x + x"));
		
	}

}
