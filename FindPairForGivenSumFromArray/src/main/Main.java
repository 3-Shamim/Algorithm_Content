package main;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 7/21/19
 * Time: 9:27 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Main {


    int findPair(int arr[], int pairSum) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == pairSum) return i;
            }
        }

        return 0;
    }

    public Main() {
        int arr[] = {11, 15, 7, 6, 9, 10};
        int pairSum = 16;
        int ans = findPair(arr, pairSum);

        if (ans == 0) {
            System.out.println(false);
        } else {
            System.out.println("Pair (" + ans + " and " + (ans + 1) + ") = " + pairSum);
        }
    }

    public static void main(String[] args) {
        new Main();
    }


}
