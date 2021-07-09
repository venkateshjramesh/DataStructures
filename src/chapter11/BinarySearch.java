package chapter11;

public class BinarySearch {

    public int getSearchIndexIterative(int[] a , int data, int low, int high, int mid){

        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (a[mid] > data) {
                high = mid - 1;
            } else if (a[mid] < data) {
                low = mid + 1;
            } else if (a[mid] == data) {
                return mid;
            }
        }
        return -1;
    }


    public int getSearchIndexRecursive(int[] a , int data, int low, int high, int mid){
        mid = low + ((high - low) / 2);

        if (a[mid] > data) {
            return getSearchIndexRecursive(a , data, low, (mid - 1), mid);
        } else if (a[mid] < data) {
            return getSearchIndexRecursive(a , data, (mid + 1), high, mid);
        } else if (a[mid] == data) {
            return mid;
        }
        return -1;
    }

    public static void main(String args[]){
        BinarySearch binarySearch = new BinarySearch();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch.getSearchIndexIterative(a,8, 0,8,(0 + ((8-0)/2))));
        System.out.println(binarySearch.getSearchIndexRecursive(a,8, 0,8,(0 + ((8-0)/2))));
        System.out.println(binarySearch.getSearchIndexIterative(a,6, 0,8,(0 + ((8-0)/2))));
        System.out.println(binarySearch.getSearchIndexRecursive(a,6, 0,8,(0 + ((8-0)/2))));
        System.out.println(binarySearch.getSearchIndexIterative(a,2, 0,8,(0 + ((8-0)/2))));
        System.out.println(binarySearch.getSearchIndexRecursive(a,2, 0,8,(0 + ((8-0)/2))));
    }


}
