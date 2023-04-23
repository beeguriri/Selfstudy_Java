package Java_Study.thread;

public class ThreadJoinTest {

    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.start();

        try{
            //phone의 스레드 실행 후 main 스레드 실행
            phone.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=1; i<=100; i++)
            System.out.println("음식먹기: " + i);
    }
}
