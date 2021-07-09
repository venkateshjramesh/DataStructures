package chapter11;

public class InterpolationSearch {

    public int getSearchIndex(int[] a , int data, int low, int high, int mid){

        while(a[low] <= data && a[high] >= data){
            System.out.println("low:high:mid :" + low +":"+ high +":"+ mid);
            System.out.println("a[low] : a[high] " + a[low] +":"+ a[high]);
            if(a[high]-a[low] == 0){
                return (low + high)/2;
            }
            mid = low + ((data - a[low]) * (high - low)) / (a[high] - a[low]);
            if(a[mid] < data)
                low = mid + 1;
            else if(a[mid] > data)
                high = mid - 1;
            else
                return mid;

        }
        if(a[low] == data)
            return low;
        else
            return -1;
    }




    public static void main(String args[]){
        String s = "";
        StringBuilder sb = new StringBuilder();
        

        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(interpolationSearch.getSearchIndex(a, 8 , 0,a.length-1,(0 + (((a.length-1)-0)/2))));
        System.out.println(interpolationSearch.getSearchIndex(a, 6 , 0,a.length-1,(0 + (((a.length-1)-0)/2))));
        System.out.println(interpolationSearch.getSearchIndex(a, 2 , 0,a.length-1,(0 + (((a.length-1)-0)/2))));
        a = new int[]{10,20,30,40,50,60,70,80,90};
        System.out.println(interpolationSearch.getSearchIndex(a, 30 , 0,a.length-1,(0 + (((a.length-1)-0)/2))));
        a = new int[]{10,20,21,22,23,24,30,40,50,60,70,80,90};
        System.out.println(interpolationSearch.getSearchIndex(a, 30 , 0,a.length-1,(0 + (((a.length-1)-0)/2))));
    }

}
