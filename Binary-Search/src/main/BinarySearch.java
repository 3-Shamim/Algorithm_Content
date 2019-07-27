package main;

public class BinarySearch {

    int binarySearch(int arr[], int key, int low, int high){

        if(low <= high) {
            int mid = (low + high) / 2;

            if (key == arr[mid]) {
                return mid;
            }

            if (key > arr[mid]) {
                return binarySearch(arr, key, mid + 1, high);
            }

            return binarySearch(arr, key, low, mid - 1);
        }

        return -1;
    }

    public BinarySearch() {

        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int key = 7;
        int ans = binarySearch(arr, key, 0 , arr.length -1);

        if(ans == -1) {
            System.out.println("Value " + key +" Not Found");
        } else {
            System.out.println("Value " + arr[ans] +" Found At Index " + ans);
        }

    }

    public static void main(String[] args) {
       new BinarySearch();
    }
}
