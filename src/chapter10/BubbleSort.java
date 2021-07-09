package chapter10;

public class BubbleSort {

    public static void printArray(int[] arr){
        for(int el : arr){
            System.out.print(" " + el);
        }
        System.out.println("");
    }

    public static void bubbleSort(int[] arr){
        printArray(arr);
        int n = arr.length;
        // the outer loop tells the array size for processing
        /*
        * Starts with the entire array so n-2 as the last index is already taken care of by j+1 in inner loop
        * Ends when only one term is left ie i=0
        * */
        for(int i=n-2;i>0;i--){
            // Once the array size is determined by the outer loop, we iterate and keep on swapping for the bigger value to reach at the end
            for(int j=0;j<=i;j++){

                if(arr[j] > arr[j+1]){

                    // if lower index term is higher in value, swap it
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            // the higher element keeps settling at the bottom
            System.out.print("After " + (n-i-1) + " iteration: the array size is :: " + (i+2) +" and array is  :: ");
            printArray(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr =  new int[] {7,5,3,1,9,6,8,2,4};
        bubbleSort(arr);
    }
}
