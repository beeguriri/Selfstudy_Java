package Java_Programmers.Level2;

public class 스킬트리 {

    public static int solution(String skill, String[] skill_trees) {

        int answer = 0;

        for(int i=0; i<skill_trees.length; i++) {

            String temp = skill_trees[i].replaceAll("[^" + skill + "]", "");

            if(temp.equals("")) {
                answer += 1;
                continue;
            }

            for(int j=1; j<=skill.length(); j++)
                if(skill.substring(0,j).equals(temp))
                    answer+=1;

        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution("CBD", new String [] {"BACDE", "CBADF", "AECB", "BDA"})); //2
        System.out.println(solution("CBD", new String [] {"BACDE", "CBADF", "AECB", "BDA", "AQWER"})); //3

    }
}
