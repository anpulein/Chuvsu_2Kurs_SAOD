package Lab_1.DoubleLists;

import Lab_1.Lists.ArrayStack;

import java.util.Arrays;

import static java.lang.reflect.Array.newInstance;

public class DoubleArrayStack<T> {

    private T[] arr;
    private int mSize = 0, head = -1, tail = 0, size = 0;

    public DoubleArrayStack(Class<T> type, int capacity) {
        this.arr = (T[]) newInstance(type, capacity);
        this.tail = capacity - 1;
        this.mSize = capacity;
    }

    public DoubleArrayStack(Class<T> type) {
        mSize = 20;
        this.tail = mSize;
        this.arr = (T[]) newInstance(type, mSize);
    }

    public void Push1(T item) {
        if(head + 1 - mSize != 0) {
            this.arr[++head] = item;
            size++;
        } else {
            System.out.println("Массив переполнен");
        }
    }

    public void Push2(T item) {
        if(head + 1 - mSize != 0) {
            this.arr[--tail] = item;
            size++;
        } else {
            System.out.println("Массив переполнен");
        }
    }

    public void Pop1() {
        if(head == -1) {
            System.out.println("Первый стек пуст");
        } else {
            for(int i = head; i != mSize - 1; i++) {
                this.arr[i] = this.arr[i + 1];
            }
        }
        --tail;
        --mSize;
        --size;
    }

    public void Pop2() {
        if(tail == mSize) {
            System.out.println("Второй стек пуст");
        } else {
            this.arr[tail] = this.arr[head];
            for(int i = tail + 1; i != mSize - 1; i++ ) {
                this.arr[i] = this.arr[i + 1];
            }
        }
        --size;
    }

    @Override
    public String toString() {
        String str = "";
        if (size != -1) {
            str = "[";
        }

        for(int i = 0; i <= mSize - 1; i++) {
            if (this.arr[i] == null) {
                continue;
            }
            if(i == mSize - 1) {
                str += this.arr[i] + "]";
            } else {
                str += this.arr[i] + ", ";
            }
        }
        return str;
    }
}
