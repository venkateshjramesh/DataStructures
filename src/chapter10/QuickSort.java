package chapter10;

public class QuickSort {

    public static void quickSort(int[] arr){
        int n = arr.length;
        quickSort(arr,0,n-1);
    }

    public static void quickSort(int[] arr, int start, int end){
        if(end>start){

            printArray(arr);
//            int pivot_index = partitionEnd(arr,start,end);
            int pivot_index = partitionStart(arr,start,end);
            quickSort(arr,start,pivot_index-1);
            quickSort(arr,pivot_index+1,end);
        }
        return;
    }

    /*
    * Pivot can be choosen either as the first element in  the array or the last element in the array
    * */

    //Choosing last element as the pivot
    public static int partitionEnd(int[] arr, int start, int end){
        int pivot_index = end;
        int j=start;
        for(int i=start;i<end;i++){
           if(arr[i]<arr[pivot_index]){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               j++;
           }
        }
        int temp = arr[j];
        arr[j] = arr[pivot_index];
        arr[pivot_index] = temp;

        return j;
    }
    //Choosing first element as the pivot
    public static int partitionStart(int[] arr, int start, int end){
        //pivot splits the small values in left and bigger values in right
        int pivot_index = start;
        int left = start+1;
        int right = end;
        while(right >= left){
            while(left <=end && arr[left] <= arr[pivot_index]){
                left++;
            }
            while(arr[right] > arr[pivot_index]){
                right--;
            }
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int temp = arr[right];
        arr[right] = arr[pivot_index];
        arr[pivot_index] = temp;
        return right;
    }

    public static void printArray(int[] arr){
        for(int el : arr){
            System.out.print(" " + el);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr =  new int[] {7,5,3,1,9,6,8,2,4};
        quickSort(arr);
        printArray(arr);
    }
}
