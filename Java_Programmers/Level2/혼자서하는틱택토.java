package Java_Programmers.Level2;

public class 혼자서하는틱택토 {

    public static char [][] graph = new char[3][3];

    public static int solution(String[] board) {

        //"O"가 "X"보다 1개 많거나 같아야함
        //빙고 만족하지 않으면
        // "O"의 개수 == "X"의 개수 또는 O의 개수가 한개 더 많음
        //빙고를 만족하면
        //"O가 이길때" : "O의 개수가 한개 더 많음"
        //"X가 이길때" : "O"의 개수 == "X"의 개수

        for(int i=0; i<3; i++)
            graph[i] = board[i].toCharArray();

        int countO = countChar('O');
        int countX = countChar('X');
        boolean successO = isTicChar('O');
        boolean successX = isTicChar('X');

        if(countO==countX) {
            if(!successO && !successX)
                return 1;
            if(!successO && successX)
                return 1;
        } else if(countO-countX==1){
            if(!successO && !successX)
                return 1;
            if(successO && !successX)
                return 1;
        }

        return 0;

    }

    public static int countChar(char c) {
        int count = 0;
        for(char [] i : graph)
            for(char ch : i)
                if(ch==c)
                    count++;
        return count;
    }

    public static boolean isTicChar(char c) {

        //가로방향
        for(int i=0; i<3; i++)
            if(graph[i][0]==c && graph[i][1]==c && graph[i][2]==c)
                    return true;

        //세로방향
        for(int i=0; i<3; i++)
            if(graph[0][i]==c && graph[1][i]==c && graph[2][i]==c)
                return true;

        //왼쪽 대각선방향
        if(graph[0][0]==c && graph[1][1]==c && graph[2][2]==c)
            return true;

        //오른쪽 대각선
        if(graph[0][2]==c && graph[1][1]==c && graph[2][0]==c)
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String [] {"O.X", ".O.", "..X"}));
        System.out.println(solution(new String [] {"OOO", "...", "XXX"}));
        System.out.println(solution(new String [] {"...", ".X.", "..."}));
        System.out.println(solution(new String [] {"...", "...", "..."}));
        System.out.println(solution(new String [] {"OXO", "XOX", "OXO"}));

    }
}
