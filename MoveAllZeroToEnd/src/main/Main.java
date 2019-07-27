package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 7/25/19
 * Time: 9:50 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Main {

    public Main() {

        int[] arr = {2, 8, 0, 5, 2, 0, 6, 0, 1, 9};
        List<Integer> list =  new ArrayList<>();
        list.addAll(Arrays.asList(2, 8, 0, 5, 2, 0, 6, 0, 1, 9));
        int arrLen = arr.length;
        System.out.println("Before:");
        for (int i : arr) {
            System.out.printf("%d ",i);
        }
        System.out.println();
        list.forEach(v -> System.out.printf("%d ", v));
        System.out.println();

        moveAllZeroToEnd(arr, arrLen, 2);
        moveAllZeroToEndList(list, arrLen, 2);

        System.out.println("After:");
        for (int i : arr) {
            System.out.printf("%d ",i);
        }
        System.out.println();
        list.forEach(v -> System.out.printf("%d ", v));

    }

    private void moveAllZeroToEndList(List<Integer> arr, int arrLen, int moveValue) {
        for (int i = 0; i < arrLen; i++) {
            if (arr.get(i) == moveValue) {
                arr.add(arr.get(i));
                arr.remove(i);
            }
        }
    }

    private void moveAllZeroToEnd(int[] arr, int arrLen, int moveValue) {
        int count = 0;
        for (int i = 0; i < arrLen; i++) {
            if (arr[i] != moveValue) arr[count++] = arr[i];
        }

        while (count < arrLen) {
            arr[count++] = moveValue;
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
