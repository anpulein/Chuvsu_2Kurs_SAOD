package Lab_3;

public class Example2 {
    public static void show(int n) {
        for (int i = 1; i < n; i++) {
            if(i % 3 == 1 && i % 4 == 1 && i % 5 == 1 && i % 5 == 1) {
                if(i % 7 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
