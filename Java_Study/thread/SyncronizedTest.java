package Java_Study.thread;

public class SyncronizedTest {

    public static void main(String[] args) {

        Account account = new Account();
        DrawThread t1 = new DrawThread(account);
        DrawThread t2 = new DrawThread(account);

        t1.start();
        t2.start();

    }
}

class Account{

    private long balance = 1000;

    public synchronized void draw(long amount) {
//    public void draw(long amount) {
        balance -= amount;
    }

    public long getBalance() {
        return balance;
    }
}

class DrawThread extends Thread{

    Account account;

    DrawThread(Account account){
        this.account = account;
    }

    public void run() {
//        synchronized (account) {
            for (int i = 0; i < 10; i++) {
                account.draw(10);
                System.out.println(this.getName() + " 출금후 잔액 " + account.getBalance());
            }
//        }
    }
}
