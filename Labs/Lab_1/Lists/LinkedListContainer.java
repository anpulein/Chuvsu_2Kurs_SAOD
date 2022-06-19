package Lab_1.Lists;

import java.util.NoSuchElementException;

public class LinkedListContainer<T> implements Linked<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public void add(T elem) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, elem, null);
        last = newNode;
        if(l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T elem) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, elem, f);
        first = newNode;
        if(f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T elem) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, elem, null);
        last = newNode;
        if(l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        for(Node<T> iter = first; iter != null; ) {
            Node<T> nextIter = iter.next;
            iter.next = null;
            iter.prev = null;
            iter.elem = null;
            iter = nextIter;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public T get(int index) {

        Node<T> iter = first;
        T elem = null;

        if(index < 1 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        for(int i = 0; i < size; i++) {
            if(i == index - 1) {
                elem = iter.elem;
            }
            iter = iter.next;
        }
        return elem;
    }

    @Override
    public T get() {

        if(last == null) {
            throw new NoSuchElementException();
        }
        return last.elem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove() {

        final Node<T> f = first;
        final T elem = f.elem;

        if(f == null) {
            throw new NoSuchElementException();
        }

        Node<T> nextIter = first.next;
        first.next = null;
        first.elem = null;
        first = nextIter;

        if(first == null) {
            last = null;
        }

        size--;
        return elem;

    }

    @Override
    public T removeLast() {
        final Node<T> l = last;
        final T elem = l.elem;

        if(l == null) {
            throw new NoSuchElementException();
        }

        Node<T> lastIter = last.prev;
        last.prev = null;
        last.elem = null;
        last = lastIter;

        if(last == null) {
            first = null;
        }

        size--;
        return elem;
    }

    public Boolean empty() {
        return !(size == 0);
    }

    @Override
    public String toString() {
        String str = null;
        if(first == null) {
            return str;
        } else {
            str = "[";
        }
        Node<T> iter = first;
        for(int i = 0; i < size; i++) {
            if(i == size - 1) {
                str = str + iter.elem.toString() + ']';
            } else {
                str = str + iter.elem.toString() + ", ";
            }
            iter = iter.next;
        }
        return str;
    }

    private class Node<T> {

        private T elem;
        private Node<T> next;
        private Node<T> prev;

        private Node(Node<T> prev, T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }
}
