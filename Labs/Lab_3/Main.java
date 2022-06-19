package Lab_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Example 1
        BacktrackingSearch backtrackingSearch = new BacktrackingSearch();
        backtrackingSearch.find(0, 10);

       // Example 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = scanner.nextInt();

        System.out.print("Числа: ");
        Example2.show(n);

        // Example 3
        Example3 ex3 = new Example3();
        System.out.println("Введите n: ");
        n = scanner.nextInt();
        int []arr = new int[n];

        System.out.print("Введите массив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        System.out.println("Result: " + ex3.longestLength(arr));
    }
}
