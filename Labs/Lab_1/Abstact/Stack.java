package Lab_1.Abstact;

public abstract class Stack <T>{

    protected int mSize; // Максимальный размер стека
    protected int top = -1; // Индекс перемещения


    public void Push(T elem) {
    }

    public T Pop() {
        return null;
    }

    public T StackTop() {
        return null;
    }

    public Boolean Empty() {
        return (top == -1);
    }

    public int Size() {
        return mSize;
    }


}
