package Lab_3;

public class BacktrackingSearch {

    private static char str[] = new char[10];

    public static void find(int s, int l) {
        if(l != 0) {
            str[s] = '(';
            str[s + l - 1] = ')';
            find(s + 1, l - 2);
            if(l > 2) {
                str[s] = '(';
                str[s + 1] = ')';
                find(s + 2, l - 2);
            }
        } else {
            System.out.println(str);
        }
    }
}
