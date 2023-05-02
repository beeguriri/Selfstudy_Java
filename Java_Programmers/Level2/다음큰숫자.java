package Java_Programmers.Level2;

public class 다음큰숫자 {

    public int solution(int n) {

        int count = 0;
        String nStr = Integer.toBinaryString(n);

        for(char c : nStr.toCharArray())
            if(c == '1')
                count++;

        while(true) {

            n = n+1;
            String temp = Integer.toBinaryString(n);
            int tempCount = 0;

            for(char c : temp.toCharArray())
                if (c == '1')
                    tempCount++;

            if(tempCount == count)
                return n;

        }

    }
}
