package Lab_1.Lists;

public interface Linked<T> {

    void add(T elem);
    void addFirst(T elem);
    void addLast(T elem);
    void clear();
    T get(int index);
    T get();
    int size();
    T remove();
    T removeLast();

}
