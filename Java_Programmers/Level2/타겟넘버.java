package Java_Programmers.Level2;

public class 타겟넘버 {

    public static int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, numbers[0], 0, target);
        dfs(numbers, -1*numbers[0], 0, target);

        return answer;
    }

    public static void dfs(int [] numbers, int num, int depth, int target){

        if(depth==numbers.length-1){
            if(num==target)
                answer += 1;

            return;
        }

        dfs(numbers, num + numbers[depth+1], depth+1, target);
        dfs(numbers, num - numbers[depth+1], depth+1, target);
    }

    public static void main(String[] args) {

        타겟넘버 a = new 타겟넘버();

        int [] numbers1 = {1, 1, 1, 1, 1};
        int [] numbers2 = {4, 1, 2, 1};

//        System.out.println(a.solution(numbers1, 3)); //5
        System.out.println(a.solution(numbers2, 4)); //2
    }
}
