package Lab_1.Lists;

import Lab_1.Abstact.Queue;
import java.util.Arrays;
import static java.lang.reflect.Array.newInstance;

public class ArrayQueue<T> extends Queue<T> {

    private T[] arr;

    public ArrayQueue(Class<T> type, int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException(
                    "Stack size cannot be negative"
            );
        }
        this.mSize = capacity;
        this.arr = (T[]) newInstance(type, capacity);
        this.countElem = 0;
    }

    public ArrayQueue(Class<T> type) {
        this.mSize = 10;
        this.arr = (T[]) newInstance(type, mSize);
        this.countElem = 0;
    }

    @Override
    public void InsQueue(T elem) {
        if(countElem == mSize -1) {
            this.mSize = mSize * 2;
            arr = Arrays.copyOf(arr, mSize);
        }
        this.arr[++tail] = elem;
        countElem++;
    }

    @Override
    public T DelQueue() {
        T elem = this.arr[head];
        for(int i = 0; i < countElem - 1; i++) {
            T a = this.arr[i + 1];
            this.arr[i] = a;
        }
        countElem--;
        return elem;
    }

    @Override
    public Boolean EmpthyQueue() {
        return super.EmpthyQueue();
    }

    @Override
    public String toString() {
        String str = "";
        if (countElem != -1) {
            str = "[";
        }

        for(int i = 0; i <= countElem - 1; i++) {
            if(i == countElem - 1) {
                str += this.arr[i] + "]";
            } else {
                str += this.arr[i] + ", ";
            }
        }
        return str;
    }
}
