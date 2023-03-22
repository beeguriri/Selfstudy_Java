package Java_Baekjoon;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class format {
    //제출양식
    public static class Main {
        public static void main(String[] args) {

        }
    }

    public static void main(String[] args) throws IOException {

        //Scanner 쓰는 경우
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);

        //bufferReader 쓰는 경우
        //공백으로 한줄 입력받고, 한줄단위로 계산 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int i = 0;

        while(!str.equals("0 0 0")) {
            i++;
            int L = Integer.parseInt(str.split(" ")[0]);
            int P = Integer.parseInt(str.split(" ")[1]);
            int V = Integer.parseInt(str.split(" ")[2]);

            int answer = (V/P)*L + Math.min(V%P, L);

            bw.write("Case "+i+": "+answer+"\n");
            str = br.readLine();
        }
        bw.flush();
        bw.close();

        //데이터 읽어올때 Stringtokenizer 사용할 경우 (split보다 성능 좋음)
        StringTokenizer strT = new StringTokenizer(str, " ");
        System.out.println("tokenizer test");
        while(strT.hasMoreTokens()) {
            System.out.println(strT.nextToken());
        }
    }
}
