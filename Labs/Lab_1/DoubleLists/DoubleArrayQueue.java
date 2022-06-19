package Lab_1.DoubleLists;

import java.util.Stack;

public class DoubleArrayQueue <T> extends Stack<T>{

    private Stack<T> stack_1;
    private Stack<T> stack_2;
    private  int count = 0;

    public DoubleArrayQueue() {
        this.stack_1 = new Stack<>();
        this.stack_2 = new Stack<>();
    }

    @Override
    public T push(T item) {
        return this.stack_1.push(item);
    }

    @Override
    public synchronized T pop() {
        if(stack_1.isEmpty()) {
            System.out.println("Список пуст");
            return null;
        }
        else if(stack_2.isEmpty()) {
            while(this.stack_1.isEmpty()) {
                this.stack_2.push(this.stack_1.pop());
            }
        }
        return this.stack_2.pop();
    }
}
