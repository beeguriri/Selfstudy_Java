package Java_Programmers.Level2;

public class 광물캐기 {

    //picks : dia -> iron -> stone
    public static int min = Integer.MAX_VALUE;

    public static int countTable(String pick, String mine) {
        if(pick.equals("diamond")) {
            if(mine.equals("diamond"))
                return 1;
            else if (mine.equals("iron"))
                return 1;
            else
                return 1;
        } else if (pick.equals("iron")) {
            if(mine.equals("diamond"))
                return 5;
            else if (mine.equals("iron"))
                return 1;
            else
                return 1;
        } else {
            if(mine.equals("diamond"))
                return 25;
            else if (mine.equals("iron"))
                return 5;
            else
                return 1;
        }
    }

    public static void dfs(int total, String tool, int index, String[] minerals, int diamond, int iron, int stone) {

        //dfs 종료조건
        if(index>=minerals.length) {
            min = Math.min(min, total);
            return;
        }

        total += countTable(tool, minerals[index]);

        if((index+1)%5==0) {

            //5개 채굴 했을때
            if(diamond==0 && iron==0 && stone==0) {
                min = Math.min(min, total);
                return;
            }

            if(diamond>0)
                dfs(total, "diamond", index+1, minerals, diamond-1, iron, stone);
            if(iron>0)
                dfs(total, "iron", index+1, minerals, diamond, iron-1, stone);
            if(stone>0)
                dfs(total, "stone", index+1, minerals, diamond, iron, stone-1);

        } else
            dfs(total, tool, index+1, minerals, diamond, iron, stone);
    }

    public static int solution(int[] picks, String[] minerals) {

        int diamond = picks[0];
        int iron = picks[1];
        int stone = picks[2];

        if(diamond>0)
            dfs(0, "diamond", 0, minerals, diamond-1, iron, stone);
        if(iron>0)
            dfs(0, "iron", 0, minerals, diamond, iron-1, stone);
        if(stone>0)
            dfs(0, "stone", 0, minerals, diamond, iron, stone-1);

        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [] {1, 3, 2},
                new String [] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
    }
}
