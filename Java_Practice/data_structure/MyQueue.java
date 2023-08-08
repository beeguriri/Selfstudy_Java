package Java_Practice.data_structure;

import java.util.Scanner;

public class MyQueue {

    private final int capacity;
    private int front, rear;
    private int count;
    private final int [] queue;

    public MyQueue(int size) {
        capacity = size;
        front = rear = 0;
        count = 0;
        queue = new int [size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return capacity ==count;
    }

    public void offer(int x){
        if(isFull())
            throw new IllegalStateException("배열이 가득 참");

        count++;
        queue[rear++] = x;
        rear %= capacity;

        System.out.println("offer() front/rear = " + front + "/" + rear);

    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException("배열이 비었음");

        System.out.println("peek() front/rear = " + front + "/" + rear);
        return queue[front];
    }

    public int poll() {
        if(isEmpty())
            throw new IllegalStateException("배열이 비었음");

        count--;
        int temp = queue[front++];
        front %= capacity;
        System.out.println("poll() front/rear = " + front + "/" + rear);

        return temp;
    }

    public void printQueue() {
        if(isEmpty())
            throw new IllegalStateException("배열이 비었음");

        for(int i=0; i<count; i++)
            System.out.print(queue[(i+front)%capacity] + " ");

        System.out.println();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyQueue que = new MyQueue(5);

        while (true) {
            System.out.println("===================="); // 메뉴 구분을 위한 빈 행 추가
            System.out.printf("현재 데이터 개수: %d / %d\n", que.count, que.capacity);
            System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

            int menu = sc.nextInt();
            if (menu == 0)
                break;

            switch (menu) {
                case 1 -> que.offer((int) (Math.random() * 30));
                case 2 -> System.out.println(que.poll());
                case 3 -> System.out.println(que.peek());
                case 4 -> que.printQueue();
            }
        }



    }
}
