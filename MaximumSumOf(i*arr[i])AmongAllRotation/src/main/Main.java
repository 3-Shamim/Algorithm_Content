package main;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 7/25/19
 * Time: 8:32 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Main {

    public Main() {
        int[] arr = {8, 3, 1, 2};
//        int[] arr = {3, 2, 1};
        int arrLen = arr.length;

//        int maxSum = allArrayRotation(arr, arrLen);

        int maxSum = findMax(arr, arrLen);


        System.out.println(maxSum);

    }

    private int findMax(int[] arr, int arrLen) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arrLen; i++) {
            int count = 0;
            for (int j = 0; j < arrLen; j++) {
                int index = (i + j) % arrLen;
                count += j * arr[index];
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private int allArrayRotation(int[] arr, int arrLen) {

        int max = maximumSum(arr, arrLen);

        for (int i = 0; i < arrLen; i++) {
            arrayRotationOneByOne(arr, arrLen);
            int rMax = maximumSum(arr, arrLen);
            if(max < rMax) max = rMax;
        }

        return max;
    }

    private void arrayRotationOneByOne(int[] arr, int arrLen) {
        int temp = arr[0];
        arrLen -= 1;
        for (int i = 0; i < arrLen; i++) arr[i] = arr[i + 1];
        arr[arrLen] = temp;
    }

    private int maximumSum(int[] arr, int arrLen) {
        int count = 0;
        for (int i = 0; i < arrLen; i++) count += (i * arr[i]);
        return count;
    }

    public static void main(String[] args) {

        new Main();

    }

}
