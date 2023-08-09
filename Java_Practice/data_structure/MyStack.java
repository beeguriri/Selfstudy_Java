package Java_Practice.data_structure;

public class MyStack {

    private final int size;
    private int top = -1;
    private final int [] stack;

    public MyStack(int size){
        this.size = size;
        stack = new int [size];
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull() {
        return top>=size-1;
    }

    public void push(int x) {
        if(isFull())
            throw new IllegalStateException("배열이 가득 참");

        stack[++top] = x;
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException("배열이 비었음");

        return stack[top];
    }

    public int pop() {
        if(isEmpty())
            throw new IllegalStateException("배열이 비었음");

        return stack[top--];
    }

    public void printStack() {
        for(int i=0; i<=top; i++)
            System.out.print(stack[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        MyStack st = new MyStack(5);
        for(int i=0; i<5; i++) {
            int x = (int) (Math.random() * 30);
            st.push(x);
            System.out.println("입력 x = " + x);
        }

        st.printStack();

        System.out.println("==".repeat(30));
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());

        st.push(2);
        st.push(3);
        st.printStack();

        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }

        st.pop();

    }
}
