package chapter10;

public class SelectionSort {

//iterate the array take minimum element and swap once
    public static void printArray(int[] arr){
        for(int el : arr){
            System.out.print(" " + el);
        }
        System.out.println("");
    }

    public static void selectionSort(int[] arr){
        printArray(arr);
        int n = arr.length;

        // we will choose the minimum value in the entire array and bring it to the front
        for(int i=0;i<n-1;i++){
            int min_index = i;
            for(int j=i+1;j<n;j++){

                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            // swap the value at ith index with min value found in the array
            int temp =  arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;

            System.out.print("After iteration :: " + (i+1) + " :: Array ::");
            printArray(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr =  new int[] {7,5,3,1,9,6,8,2,4};
        selectionSort(arr);
    }
}
