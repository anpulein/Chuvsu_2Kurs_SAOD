package Lab_1.Lists;

import Lab_1.Abstact.Stack;
import java.util.Arrays;
import static java.lang.reflect.Array.newInstance;

public class ArrayStack<T> extends Stack <T> {

    private T[] arr; // Массив для Стека

    public ArrayStack(Class<T> type, int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException(
                    "Stack size cannot be negative"
            );
        }
        this.mSize = capacity;
        this.arr = (T[]) newInstance(type, capacity);
    }

    public ArrayStack(Class<T> type) {
        this.mSize = 10;
        this.arr = (T[]) newInstance(type, mSize);
    }

    @Override
    public void Push(T elem) {
        if(top == mSize -1) {
            this.mSize = mSize * 2;
            arr = Arrays.copyOf(arr, mSize);
        }
        this.arr[++top] = elem;
    }

    @Override
    public T Pop() {
        return arr[top--];
    }

    @Override
    public T StackTop() {
        if(super.Empty()) {
            return null;
        }
        else {
            return this.arr[top];
        }
    }

    @Override
    public Boolean Empty() {
        return super.Empty();
    }

    @Override
    public int Size() {
        return super.Size();
    }

    @Override
    public String toString() {
        String str = "";
        if (top != -1) {
            str = "[";
        }

        for(int i = 0; i <= top; i++) {
            if(i == top) {
                str += this.arr[i] + "]";
            } else {
                str += this.arr[i] + ", ";
            }
        }
        return str;
    }
}