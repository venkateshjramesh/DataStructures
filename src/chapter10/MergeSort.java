package chapter10;

public class MergeSort {

    public static void mergeSort(int[] arr){
        printArray(arr);
        int n = arr.length;
        mergeSort(arr,0,n-1);

    }

    public static void mergeSort(int[] arr, int start, int end){
        if(end>start){
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end){
        //get the length left array
        int n1= mid - start + 1;
        //get the length right array
        int n2 = end - mid;
        int[] l1 = new int[n1];
        int[] l2 = new int[n2];
        for(int i=0;i<n1;i++){
            l1[i] = arr[start+i];
        }
        for(int i=0;i<n2;i++){
            l2[i] = arr[mid+1+i];
        }
        int i=0;
        int j=0;
        int temp = start;
        while(i<n1 && j<n2){
            if(l1[i] < l2[j]){
               arr[temp] = l1[i];
               i++;
            }
            else{
                arr[temp] = l2[j];
                j++;
            }
            temp++;
        }

        while(i<n1){
            arr[temp] = l1[i];
            temp++;
            i++;
        }
        while(j<n2){
            arr[temp] = l2[j];
            j++;
            temp++;
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
        mergeSort(arr);
        printArray(arr);
    }
}
