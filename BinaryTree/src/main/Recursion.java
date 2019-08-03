package main;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 8/1/19
 * Time: 9:10 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Recursion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

//        printReverse(arr, 0);

        mystery(5);

    }

    private static void printReverse(int[] arr, int len) {

        if (len > arr.length - 1) return;

        printReverse(arr, len + 1);

        System.out.println(arr[len]);

    }

    public static void mystery(int n) {

        if (n == 0 || n == 1) {
            return;
        }
        mystery(n - 2);
        System.out.println(n);
        mystery(n - 1);
    }
}

