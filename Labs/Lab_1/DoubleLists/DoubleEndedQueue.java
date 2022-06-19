package Lab_1.DoubleLists;

import Lab_1.Lists.LinkedListContainer;

public class DoubleEndedQueue<T> {

    private LinkedListContainer<T> linkedListContainer;

    public DoubleEndedQueue() {
        this.linkedListContainer = new LinkedListContainer<>();
    }

    public boolean empty() {
        return linkedListContainer.empty();
    }

    public void pushBack(T item) {
        this.linkedListContainer.addLast(item);
    }

    public void pushFront(T item) {
        this.linkedListContainer.addFirst(item);
    }

    public T popBack() {
        return this.linkedListContainer.removeLast();
    }

    public T popFront() {
        return this.linkedListContainer.remove();
    }

    @Override
    public String toString() {
        return this.linkedListContainer.toString();
    }
}
