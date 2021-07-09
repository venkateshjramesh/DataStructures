package chapter2;

public class ArrayCheck {
    
    public String checkArrayOrderAsc(int[] n,int index){
        if(index <= 1)
        {
            return "Success";
        }
        
        if(n[index-1]<n[index-2])
            return "failure";
    
        return checkArrayOrderAsc(n, index -1);
    }
    
    public static void main(String args[]){
        int arr[] = { 20, 23, 23, 45, 78, 88 };
        int arr1[] = {1,2,3,5,4};
        ArrayCheck arrayCheck = new ArrayCheck();
        System.out.println(arrayCheck.checkArrayOrderAsc(arr,arr.length));
        System.out.println(arrayCheck.checkArrayOrderAsc(arr1,arr1.length));
        
    }
    
}
