package Lab_1;

import Lab_1.Abstact.Stack;
import Lab_1.DoubleLists.DoubleArrayStack;
import Lab_1.Lists.LinkedListQueue;
import Lab_1.Lists.LinkedListStack;
import Lab_1.Lists.ArrayQueue;
import Lab_1.Lists.ArrayStack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>(Integer.class);
        System.out.println(stack.StackTop());
    }
}
