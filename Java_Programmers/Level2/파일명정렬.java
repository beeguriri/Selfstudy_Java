package Java_Programmers.Level2;

import java.util.*;

public class 파일명정렬 {

    public static String[] solution(String[] files) {

        Arrays.sort(files, (o1, o2) -> {

            String [] temp1 = modPart(o1);
            String [] temp2 = modPart(o2);

            return temp1[0].compareTo(temp2[0])==0 ?
                    Integer.parseInt(temp1[1])-Integer.parseInt(temp2[1]):
                    temp1[0].compareTo(temp2[0]);
        });

        return files;
    }

    public static String[] modPart(String fileName) {

        //head, number, tail
        String [] part = new String [3];
        int idx = -1;
        boolean flag = false;

        for(int i=0; i<fileName.length(); i++) {
            //head
            if(!flag && isNumber(fileName.charAt(i))) {
                part[0] = fileName.substring(0,i).toLowerCase();
                idx = i;
                flag = true;
            }
            //tale
            else if(flag && !isNumber(fileName.charAt(i))) {
                part[1] = fileName.substring(idx, i);
                part[2] = fileName.substring(i);
                break;
            }
        }

        if(part[1]==null)
            part[1] = fileName.substring(idx);

        return part;
    }

    public static boolean isNumber(char c) {
        return c>='0' && c<='9';
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String [] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        //출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

        System.out.println(Arrays.toString(solution(new String [] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
        //출력: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]

        System.out.println(Arrays.toString(modPart("f-15")));
    }
}
