package main;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 7/23/19
 * Time: 8:20 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Main {



    public Main() {

        Integer[] arr = {1, 2, 3, 4, 5};

        int numberOfItem = 2;
//        arrayRotation(arr, numberOfItem);

        leftRotationWithArrayJoining(arr, numberOfItem);

//        for (int i : arr) {
//            System.out.println(i);
//        }
    }

    private void leftRotationWithArrayJoining(Integer[] arr, int numberOfItem) {
        Integer[] subArray1 = subArray(arr, 0, numberOfItem);
        Integer[] subArray2 = subArray(arr, numberOfItem, arr.length);
        System.out.println(Arrays.toString(arrayJoin(subArray1, subArray2)));
    }

    private  <T> T[] arrayJoin(T[] arr1, T[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;

        T[] result = Arrays.copyOf(arr2, length1 + length2);
        System.arraycopy(arr1, 0, result, length2, length1);

        return result;
    }

    private <T> T[] subArray(T[] arr, int start, int end) {
        return Arrays.copyOfRange(arr, start, end);
    }


    private void arrayRotation(Integer[] arr, int numberOfItem) {

        for (int i = 0; i < numberOfItem; i++) {
            arrayLeftRotation(arr, 0);
        }

    }

    private void arrayLeftRotation(Integer[] arr, int rotationPosition) {

        int temp = arr[rotationPosition];
        int arrayLength = arr.length - 1;

        for (int i = 0; i < arrayLength; i++) {
            arr[i] = arr[i+1];
        }

        arr[arrayLength] = temp;
    }

    public static void main(String[] args) {
        new Main();
    }

}
