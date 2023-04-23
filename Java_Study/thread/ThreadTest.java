package Java_Study.thread;

public class ThreadTest {

    public static void main(String[] args) {

        Food work1 = new Food();
        Phone work2 = new Phone();

        work1.start();
        work2.start();

        for(int i=1; i<=100; i++)
            System.out.println("TV보기: "+ i);
    }
}

class Food extends Thread{
    public void run() {

        for(int i=1; i<=100; i++)
            System.out.println("음식먹기: " + i);
    }
}

class Phone extends Thread{
    public void run() {

        for(int i=1; i<=100; i++)
            System.out.println("전화받기: " + i);
    }
}
