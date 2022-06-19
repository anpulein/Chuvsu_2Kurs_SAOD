package Lab_1.Example;

import Lab_1.Lists.ArrayStack;
import java.util.HashMap;
import java.util.Scanner;

public class Example1 {

    /**** Check of number ****/
    public static boolean isNumber(Character ch) {
        if(ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }

    /**** Priority check ****/
    public static boolean isPriority(Character ch, ArrayStack<Character> arrayStackChar, HashMap<Character, Integer> hashMap) {
        if(arrayStackChar.Empty()) {
            arrayStackChar.Push(ch);
            return false;
        }
        if(arrayStackChar.StackTop() == ')' || arrayStackChar.StackTop() == '(') {
            arrayStackChar.Push(ch);
            return false;
        }
        else if(hashMap.get(ch) <= hashMap.get(arrayStackChar.StackTop())) {
            return true;
        } else{
            arrayStackChar.Push(ch);
            return false;
        }
    }

    /**** Calculation ****/
    public static void calculator(ArrayStack<Character> arrayStackChar, ArrayStack<Double> arrayStackNumber) {
        Double a, b;
        a = arrayStackNumber.Pop();
        b = arrayStackNumber.Pop();
        switch (arrayStackChar.StackTop()) {
            case '-':
                arrayStackNumber.Push(b - a);
                arrayStackChar.Pop();
                break;
            case '+':
                arrayStackNumber.Push(b + a);
                arrayStackChar.Pop();
                break;
            case '*':
                arrayStackNumber.Push(b * a);
                arrayStackChar.Pop();
                break;
            case '/':
                arrayStackNumber.Push(b / a);
                arrayStackChar.Pop();
                break;
            case '^':
                arrayStackNumber.Push(Math.exp(Math.log(b) * a));
                arrayStackChar.Pop();
                break;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayStack<Double> arrayStackNumber = new ArrayStack<>(Double.class);
        ArrayStack<Character> arrayStackChar = new ArrayStack<>(Character.class);
        HashMap<Character, Integer> mapExpress = new HashMap<>();


        mapExpress.put('+', 1);
        mapExpress.put('-', 1);
        mapExpress.put('*', 2);
        mapExpress.put('/', 2);
        mapExpress.put('^', 3);

        System.out.print("Input example: ");
        String infixForm = scanner.nextLine();

        for(int i = 0; i < infixForm.length(); i++) {
            Character ch = infixForm.charAt(i);

            if(isNumber(ch)) { // Check of number
                arrayStackNumber.Push((double)Integer.parseInt(String.valueOf(ch))); // Character -> Integer
                continue;
            }

            if(arrayStackChar.Empty()) { // One check of empty
                arrayStackChar.Push(ch);
                continue;
            }

            if(ch == ')') {
                while (arrayStackChar.StackTop() != '(') {
                    calculator(arrayStackChar, arrayStackNumber);
                }
                arrayStackChar.Pop();
                continue;
            }
            else if(ch == '(') {
                arrayStackChar.Push(ch);
                continue;
            }

            if (isPriority(ch, arrayStackChar, mapExpress) && arrayStackNumber.Size() >= 2) {
                while (isPriority(ch, arrayStackChar, mapExpress) && arrayStackNumber.Size() >= 2) { calculator(arrayStackChar, arrayStackNumber);}
                continue;
            }

        }

        calculator(arrayStackChar, arrayStackNumber);

        System.out.println("Output: " + arrayStackNumber.Pop());

    }

}
