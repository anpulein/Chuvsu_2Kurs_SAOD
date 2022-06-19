package Lab_1.Lists;

import Lab_1.Abstact.Stack;

import java.util.Arrays;

import static java.lang.reflect.Array.newInstance;

public class LinkedListStack<T> extends Stack<T> {

    private LinkedListContainer<T> linkedListContainer = new LinkedListContainer<>(); // Связный список для Стека

    @Override
    public void Push(T elem) {
        this.linkedListContainer.add(elem);
    }

    @Override
    public T Pop() {
        return this.linkedListContainer.removeLast();
    }

    @Override
    public T StackTop() {
        return this.linkedListContainer.get();
    }

    @Override
    public Boolean Empty() {
        return this.linkedListContainer.empty();
    }

    @Override
    public String toString() {
        return this.linkedListContainer.toString();
    }
}
