package Lab_1.Abstact;

public abstract class Queue <T> {

    protected int mSize;
    protected int head = 0, tail = -1, countElem = 0;


    public void InsQueue(T elem) {

    }

    public T DelQueue() {
        return null;
    }

    public Boolean EmpthyQueue() {
        return !(countElem == 0);
    }

}
