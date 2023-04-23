package Java_Study.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadControlTest {

    public static void main(String[] args) {

        Pool pool = new Pool();
        Thread productGet = new Thread(new ProductGet(pool));
        Thread productAdd = new Thread(new ProductAdd(pool));

        productGet.start();
        productAdd.start();
    }
}


class Pool{

    List<String> product = new ArrayList<>();

    public synchronized void get() throws InterruptedException {

        if(product.size()==0)
            wait();

        product.remove(0);
        System.out.println("get() product list" + product);
        System.out.println("소비/재고 = " + product.size());
    }

    public synchronized void add(String value) {

        product.add(value);
        System.out.println("add() product list" + product);
        System.out.println("소비/재고 = " + product.size());
        notifyAll();

    }
}

class ProductGet implements Runnable{

    Pool pool;

    ProductGet(Pool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++)
                pool.get();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ProductAdd implements Runnable{

    Pool pool;
    ProductAdd(Pool pool){
        this.pool = pool;
    }

    @Override
    public void run() {

        for(int i=1; i<=10; i++)
            pool.add("상품" + i);
    }
}