package main;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 7/23/19
 * Time: 10:37 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Main {

    public Main() {
        // Sorted And Rotated Array
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int arrLen = arr.length - 1;
        int key = 7;

        int ans = pivotedBinarySearch(arr, arrLen, key);

        if (ans == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Index = " + ans  + " -> Value = " +arr[ans]);
        }
    }

    private int pivotedBinarySearch(int[] arr, int arrLen, int key) {

        int low = 0;
        int high = arrLen;

//        System.out.println(findPivotPoint(arr, low, high));

//        System.out.println(binarySearch(arr, low, high, key));

        int pivotPoint = findPivotPoint(arr, low, high);

        if (pivotPoint == -1) return binarySearch(arr, low, high, key);

        if (arr[pivotPoint] == key) return pivotPoint;

        if (arr[pivotPoint] > key) return binarySearch(arr, low, pivotPoint - 1, key);

        return binarySearch(arr, pivotPoint + 1, high, key);
    }

    private int binarySearch(int[] arr, int low, int high, int key) {

        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key) return mid;

        if (arr[mid] > key) return binarySearch(arr, low, mid - 1, key);

        return binarySearch(arr, mid + 1, high, key);
    }

    private int findPivotPoint(int[] arr, int low, int high) {

        if (low > high) return -1;
        if (low == high) return low;

        int mid = (low + high) / 2;

        if (mid < high && arr[mid] > arr[mid + 1]) return mid;
        if (mid > low && arr[mid] < arr[mid - 1]) return mid - 1;

        if (arr[mid] > arr[low]) return findPivotPoint(arr, mid + 1, high);

        return findPivotPoint(arr, low, mid - 1);
    }

    public static void main(String[] args) {

        new Main();

    }

}
