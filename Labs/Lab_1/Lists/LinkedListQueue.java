package Lab_1.Lists;

import Lab_1.Abstact.Queue;

import java.util.Arrays;

import static java.lang.reflect.Array.newInstance;

public class LinkedListQueue<T> extends Queue<T> {

    private LinkedListContainer<T> linkedListContainer = new LinkedListContainer<>(); // Связной список для очереди

    @Override
    public void InsQueue(T elem) {
        this.linkedListContainer.addLast(elem);
    }

    @Override
    public T DelQueue() {
        return this.linkedListContainer.remove();
    }

    @Override
    public Boolean EmpthyQueue() {
        return this.linkedListContainer.empty();
    }

    @Override
    public String toString() {
        return this.linkedListContainer.toString();
    }
}
