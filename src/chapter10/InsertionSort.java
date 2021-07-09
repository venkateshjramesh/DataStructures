package chapter10;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        int n = arr.length;
        printArray(arr);
        // since i=0 is base case, one element array is already sorted, we start from i=1
        for(int i=1;i<n;i++){
            int val = arr[i];
            int j = i;
            // keep going left till the element is not smaller than the val
            while(j>0 && arr[j-1]>val){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
            System.out.print("After " + (i) + "th iteration :: Array is :: ");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr){
        for(int el : arr){
            System.out.print(" " + el);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr =  new int[] {7,5,3,1,9,6,8,2,4};
        insertionSort(arr);
    }
}
