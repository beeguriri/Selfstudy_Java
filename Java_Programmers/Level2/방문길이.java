package Java_Programmers.Level2;

public class 방문길이 {

    public static int solution(String dirs) {

        int answer = 0;

        char [] dir = dirs.toCharArray();
        boolean [][][] visited = new boolean[11][11][4];
        int [] dx = {-1, 1, 0, 0}; //UDRL
        int [] dy = {0, 0, 1, -1};

        int ix = 5;
        int iy = 5;

        for(char c : dir) {

            int dt = 0;
            int df = 0;

            switch (c) {
                case 'U' -> {
                    dt = 0;
                    df = 1;
                }
                case 'D' -> {
                    dt = 1;
                    df = 0;
                }
                case 'R' -> {
                    dt = 2;
                    df = 3;
                }
                case 'L' -> {
                    dt = 3;
                    df = 2;
                }
            }

            int nx = ix + dx[dt];
            int ny = iy + dy[dt];

            if(nx<0 || nx>=11 || ny<0 || ny>=11)
                continue;

            if(!visited[ix][iy][df] && !visited[nx][ny][dt]){
                visited[ix][iy][df] = true;
                visited[nx][ny][dt] = true;
                answer += 1;
            }

            ix = nx;
            iy = ny;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDDUUD"));
    }
}
