package Lab_3;


import java.util.ArrayList;
import java.util.Arrays;

public class Example3 {

    private ArrayList arr = new ArrayList<Integer>();

    int longestLength(int numbers[]) {
        if(numbers.length == 1) {
            return 1;
        }

        int lengthOfSubsequence[] = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            lengthOfSubsequence[i] = 1;
        }

        for (int j = 1; j < numbers.length; j++) {
            for (int k = 0; k < j; k++) {
                if(numbers[j] > numbers[k]) {
                    if(lengthOfSubsequence[j] <= lengthOfSubsequence[k]) {
                        lengthOfSubsequence[j] = lengthOfSubsequence[k] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < lengthOfSubsequence.length; i++) {
            max = Math.max(max, lengthOfSubsequence[i]);
        }

        int k = 1;
        for (int i = 0; i < numbers.length; i++) {
            if(k > max) {
                break;
            }

            if(k == lengthOfSubsequence[i]) {
                System.out.print(numbers[i] + " ");
                k++;
            }
        }

        System.out.println();


        return max;



    }
}
