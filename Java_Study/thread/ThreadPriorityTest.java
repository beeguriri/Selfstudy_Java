package Java_Study.thread;

public class ThreadPriorityTest {

    public static void main(String[] args) {

        Food f = new Food();
        Phone p = new Phone();

        f.setPriority(Thread.MIN_PRIORITY);
        p.setPriority(Thread.MAX_PRIORITY);
        f.start();
        p.start();
    }
}
